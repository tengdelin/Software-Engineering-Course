#include<iostream>
using namespace std;
#include<fstream>
#include<vector>
#include<windows.h>
#include<QString>
#include<QMessageBox>

//unsigned int bit_len(unsigned int n);
int lenth(int i);
void dp(int n, unsigned int dataline[], unsigned int s[], unsigned int l[], unsigned int b[]);
void Traceback(int n, int& m, unsigned int s[], unsigned int l[]);
void Output(unsigned int dataline[],unsigned int s[], unsigned int l[], unsigned int b[], int n);


struct CCompressImage
{
    CCompressImage  () {};
    tagBITMAPFILEHEADER bf;//文件头结构体
    tagBITMAPINFOHEADER bi;// 文件信息头结构体
    tagRGBQUAD rgb[256];//调色板
    unsigned char** Mapdata;//保存位图信息的二维数组
    unsigned int *dataline;//保存蛇形位图信息的一位数组
    string Filename;

    bool ReadBitmap(string filename)//读灰度图
    {
        //读文件头、信息头和调色板
        Filename = filename;
        ifstream fp(filename, ios::binary);
        if (!fp)
        {
            QMessageBox::critical(0 ,
                                  "提示" , "图片打开失败！",
                                  QMessageBox::Ok | QMessageBox::Default ,
                                  QMessageBox::Cancel | QMessageBox::Escape ,  0 );
            return false;
        }
        fp.read((char*)&bf, sizeof(tagBITMAPFILEHEADER));//读文件头
        fp.read((char*)&bi, sizeof(tagBITMAPINFOHEADER));//读信息头
        fp.read((char*)&rgb, sizeof(tagRGBQUAD) * 256);//读调色板
        //初始化保存位图信息的二维数组
        Mapdata = new unsigned char* [bi.biHeight];
        for (int i = 0; i < bi.biHeight; i++)
        {
            Mapdata[i] = new unsigned char[bi.biWidth];
        }
        //读位图信息
        for (int i = 0; i < bi.biHeight; i++)
        {
            for (int j = 0; j < bi.biWidth; j++)
            {
                fp.read((char*)&Mapdata[i][j], 1);
            }
        }
        fp.close();

        //将保存位图信息的二维数组蛇形读入该一维数组
        dataline = new unsigned int[bi.biHeight * bi.biWidth];
        int k = 0;
        for (int i = 0; i < bi.biHeight; i++)
        {
            if (i % 2 == 0)//偶数行正读
            {
                for (int j = 0; j < bi.biWidth; j++)
                {
                    dataline[k++] = (int)Mapdata[i][j];
                }
            }
            else//奇数行逆读
            {
                for (int j = bi.biWidth - 1; j >= 0; j--)
                {
                    dataline[k++] = (int)Mapdata[i][j];
                }
            }
        }
        return true;
    };
    bool Compress()//压缩
    {
        ofstream bmpzip("Compressed.bmp", ios::binary);
        int n = bi.biHeight * bi.biWidth;
        unsigned int* b = new unsigned int[bi.biHeight * bi.biWidth + 1];
        unsigned int* l = new unsigned int[bi.biHeight * bi.biWidth + 1];
        unsigned int* s = new unsigned int[bi.biHeight * bi.biWidth + 1];
        dp(n, dataline, s, l, b);
        int m = 0;
        Traceback(n, m, s, l);
        Output(dataline,s, l, b, n);

        //先像压缩文件中写入 文件头、信息头、调色板
        bmpzip.write((char*)&bf, sizeof(tagBITMAPFILEHEADER));
        bmpzip.write((char*)&bi, sizeof(tagBITMAPINFOHEADER));
        bmpzip.write((char*)&rgb, sizeof(tagRGBQUAD) * 256);

        vector<int> bitset;
        s[0] = 0;//第一段的第一个元素的序号为1
        //然后向压缩文件写入分好段的位图信息
        for (int i = 1; i <=m; i++)
        {
            int maxbit = b[i];//这一段要保留的位数
            int lengh = l[i];//这一段的段长
            int start = s[i - 1]+1;//这一段的起始位置
            int end = s[i];//这一段的结束位置

            //向压缩文件写入段长 8位 的l[i]
            for (int j = 7; j >= 0; j--)
            {
                bitset.push_back(((lengh-1) >> j) & 1);
            }
            //向压缩文件写入段内位数 3位的b[i]
            for (int j = 2; j >= 0; j--)
            {
                bitset.push_back(((maxbit - 1) >> j) & 1);
            }
            //向压缩文件写入每一段的像素值 maxbit 位的dataline[i]
            for (int k = start -1 ; k <= end-1; k++)//在dataline中要index要减1
            {
                int pixel = dataline[k];
                for (int j = maxbit - 1; j >= 0; j--)
                {
                    bitset.push_back((pixel >> j) & 1);
                }
            }
        }
        int count = 0;
        char temp = 0;
        for (auto e : bitset) {
            if (count % 8 == 0 && count != 0) {
                count = 0;
                bmpzip.write((char*)&temp, sizeof(char));
                temp = 0;
            }
            if (e == 0) {
                temp &= ~(1 << (7 - count));//将temp的7-count位置0
                count++;
            }
            else {
                temp |= (1 << (7 - count));//将temp的7-count位置1
                count++;
            }
        }
        if (count != 0) {//最后一个字节不足8位补0
            for (int i = count; i < 8; i++) {
                temp &= ~(1 << 7 - i);
            }
        }
        bmpzip.write((char*)&temp, sizeof(char));
        return true;
    }
    bool UnCompress(string filenamezip)//解压缩
    {
        ifstream ufp(filenamezip, ios::binary);
        if (!ufp)
        {
            QMessageBox::critical(0 ,
                                  "提示" , "图片打开失败！",
                                  QMessageBox::Ok | QMessageBox::Default ,
                                  QMessageBox::Cancel | QMessageBox::Escape ,  0 );
            return false;
        }
        ofstream newfp("UnCompressed.bmp", ios::binary);
        ufp.read((char*)&bf, sizeof(tagBITMAPFILEHEADER));//读文件头
        ufp.read((char*)&bi, sizeof(tagBITMAPINFOHEADER));//读信息头
        ufp.read((char*)&rgb, sizeof(tagRGBQUAD) * 256);//读调色板
        //将压缩文件的3个头信息写入还原的文件
        newfp.write((char*)&bf, sizeof(tagBITMAPFILEHEADER));
        newfp.write((char*)&bi, sizeof(tagBITMAPINFOHEADER));
        newfp.write((char*)&rgb, sizeof(tagRGBQUAD) * 256);
        vector<int> unbitset;//用来存储每一个解压后的每一位
        unsigned char* dataline = new unsigned char[bi.biHeight * bi.biWidth];//创建一个蛇形数组
        unsigned char** datamap = new unsigned char* [bi.biHeight * bi.biWidth];//创建一个二维矩阵用来保存像素信息。
        for (int i = 0; i < bi.biHeight; i++)
        {
            datamap[i] = new unsigned char[bi.biWidth];
        }
        unsigned int temp;
        while (!ufp.eof())
        {
            ufp.read((char*)&temp, 1);
            for (int j = 7; j>=0;j--)
            {
                unbitset.push_back((temp >> j) & 1);
            }
        }
        int index = 0;//记录当前读unbitset的位置
        bool ending = false;//将要结束，索引到补位了
        unsigned int length=0;
        unsigned int maxbit=0;
        int N = 0;
        int endindex = 0;//记录停止读压缩文件的索引位置
        int n=1;
        while (index<unbitset.size())
        {
            if (ending == true) break;//index 到补0位的时候 退出
            int j = index; //j表是一段的起始序号
            length = 0;
            maxbit = 0;
            for (int k = j; k < j + 8; k++) //解该段的长度
            {
                if (unbitset[k] == 0)//如果该位为0
                {
                    length &= ~(1 << (j+7-k));//将temp的7-count位置0
                }
                else
                {
                    length |= (1 << (j+7- k));//将temp的7-count位置1
                }
            }
            length += 1;//最后的长度还要加1

            //解该段的段内位数
            for (int i = 4; i>=0; i--)
            {
                maxbit &= ~(1 << 7 - i);//将maxbit的7~3位置0
            }
            for (int k = j+8; k < j+11; k++)
            {
                if (unbitset[k] == 0)
                {
                    maxbit &= ~(1 << (j+10-k));//置0
                }
                else
                {
                    maxbit |= (1 << (j + 10 - k));//置1
                }
            }
            maxbit += 1;//最后段内位数还要加1
            n++;
            int count = 0;
            unsigned int temp1=0;
            int number = length * maxbit;//后面还有number位是该段的元素所占用的位
            bool tianchong = false;
            for (int k = j+11;k<j+11+number;k++)
            {
                if (tianchong == false)
                {
                    for (int i = 7 - maxbit; i >= 0; i--)
                    {
                        temp1 &= ~(1 << 7 - i);//将maxbit的7~(maxbit-1)位置0
                    }
                    tianchong = true;
                }

                if (count < maxbit)
                {
                    if (unbitset[k] == 0)
                    {
                        temp1 &= ~(1 << (maxbit- count-1));
                        count++;
                    }
                    else
                    {
                        temp1 |= (1 << (maxbit - count - 1));//置1
                        count++;
                    }

                }
                if(count==maxbit)//当count 等于 maxbit时 说明一个temp1 已经解完
                {
                    // newfp.write((char*)&temp1, 1);
                    dataline[N++] = temp1;//将数据写入蛇形数组
                    //每写入一个文件就N加1
                    if (N == bi.biWidth * bi.biHeight)
                    {
                        ending = true;
                        break;
                    }
                    count = 0;
                    temp1 = 0;
                    tianchong = false;
                }
            }
            //当该段的全部数据读完时，index 跳到下一个
            index += 11 + number;

        }
        //将蛇形数组的信息写入二维像素矩阵
        int k = 0;
        for (int i = 0; i < bi.biHeight; i++)
        {
            if (i % 2 == 0)//偶数行正读
            {
                for (int j = 0; j < bi.biWidth; j++)
                {
                    datamap[i][j] = dataline[k++];
                }
            }
            else//奇数行逆读
            {
                for (int j = bi.biWidth - 1; j >= 0; j--)
                {
                    datamap[i][j] = dataline[k++];
                }
            }
        }
        //将二维像素矩阵的信息写入位图
        for (int i = 0; i < bi.biHeight; i++)
        {
            for (int j = 0; j < bi.biWidth; j++)
            {
                newfp.write((char*)&datamap[i][j], 1);
            }
        }
        return true;
    }
    //dataline 为蛇形数组，s数组记录前i个元素的最小位数，b数组记录第i个元素的位数，l数组第i个元素所在段向前的元素个数
    void dp(int n, unsigned int dataline[], unsigned int s[], unsigned int l[], unsigned int b[])
    {
        int Lmax = 256, header = 11;
        s[0] = 0;
        for (int i = 1; i <= n; i++)
        {

            b[i] = lenth(dataline[i - 1]);//计算像素点p需要的存储位数
            unsigned int bmax = b[i];
            s[i] = s[i - 1] + bmax;
            l[i] = 1;//初始自成一段
            for (int j = 2; j <= i && j <= Lmax; j++) {
                if (bmax < b[i - j + 1])
                    bmax = b[i - j + 1];
                if (s[i] > s[i - j] + j * bmax) {
                    s[i] = s[i - j] + j * bmax;
                    l[i] = j;//从[i-j+1,i]合成一段
                }
            }
            s[i] += header;
        }
    }
    void Traceback(int n, int& m, unsigned int s[], unsigned int l[])
    {
        if (n == 0)
            return;
        Traceback(n - l[n], m, s, l);
        s[m++] = n - l[n]; //重新为s[]数组赋值，用来存储分段位置
    }
    void Output(unsigned int dataline[], unsigned int s[], unsigned int l[], unsigned int b[], int n)
    {
        int m = 0;
        Traceback(n, m, s, l);
        s[m] = n;
        for (int j = 1; j <= m; j++) {
            l[j] = l[s[j]];
            int max = -1;
            for (int i = s[j - 1] + 1; i <= s[j]; i++)
            {
                if (lenth(dataline[i - 1]) > max)
                {
                    max = lenth(dataline[i - 1]);
                }
            }
            b[j] = max;
        }
    }
    int lenth(int i)//log(i+1)向上取整
    {
        int k = 1;
        i = i / 2;
        while (i > 0) {
            k++;
            i = i / 2;
        }
        return k;
    }
};
