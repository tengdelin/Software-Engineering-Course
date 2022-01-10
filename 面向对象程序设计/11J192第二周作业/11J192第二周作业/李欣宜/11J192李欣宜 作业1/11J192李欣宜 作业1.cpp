#include <iostream>
#include<fstream>
using namespace std;

class calculate {
private:
    int arr1[5][5];
	int arr2[5][5];
	int arr3[5][5];//储存结果
public:
	calculate();
    ~calculate(){}
   void multiply();//矩阵乘法函数
};
calculate::calculate() {
	ifstream f1;
	f1.open("‪D://1.txt");//从文件读取数据‬
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++)
			f1 >> arr1[i][j];
		f1.close();
	}
	ifstream f2;
	f2.open("‪D://2.txt");//从文件读取数据‬
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++)
			f2 >> arr2[i][j];
		f2.close();
	}
}
void calculate::multiply() {
	for (int i = 0; i < 5; i++)//计算
	{
		for (int j = 0; j < 5; j++)
		{
			arr3[i][j] = 0;//初始化arr3
			for (int k = 0; k < 5; k++)
				arr3[i][j] += arr1[i][k] * arr2[k][j];
		}
	}
	for (int i = 0; i < 3; i++)//输出
	{
		for (int j = 0; j < 3; j++)
			cout<<arr3[i][j]<<endl;
	}
}

int main()
{
	calculate A;
	A.multiply();//调用矩阵乘法函数
	return 0;
}