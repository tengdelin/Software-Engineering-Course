// 字符串类.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
using namespace std;
class myStr {
public:
    myStr( const char* m1) //构造函数
    {
        length = strlen(m1);
        m_ptr = new char[length];
        strncpy(m_ptr, m1, length);//实现字符串的复制的函数
    }
    ~myStr(){//析构函数
        delete[]m_ptr;
    }
    void strncpy(char* v1, const char* v2, int l);
    int strlen(const char* m2);//计算字符串长度的函数
    char Swap(char* x1, char* x2,int n);//交换字符串的函数
    char clear();//清空字符串中的字符
    char replace(char* c1);//实现替换字符
    int length;//用于存放字符串长度
    char* m_ptr;//动态字符数组
};
void myStr::strncpy(char* v1, const char* v2, int l){
    for (int i = 0; i < l; i++) {
        v1[i] = v2[i];
    }
}
int myStr::strlen(const char* m2) {
    int len = 0;
    while (m2 && *m2++ != '\0') {
        ++len;
    }
    return len;
}
char myStr::Swap(char* x1, char* x2, int n) {
    char* x3 = new char[n]();//定义一个用于交换的字符指针
    for (int i = 0; i < n; i++) {
        x3[i] = x1[i];
        x1[i] = x2[i];
        x2[i] = x3[i];
    }
    return 0;
}
char myStr::clear() {//将清空的字符串全设置为0
    for (int i = 0; i < length; i++) {
        m_ptr[i] = '0';
        cout << m_ptr[i];
    }
    return 0;
}
char myStr::replace(char* c1) {
    int x;
    char c2;
    cout << "请输入你想替换的位置和新字符" << endl;
    cin >> x >> c2;
    c1[x] = c2;
    return 0;
}
int main()
{
    myStr L1("shou");
    myStr L2("yuan");
    L1.clear();
    L1.Swap(L1.m_ptr, L2.m_ptr, 6);
    L1.replace(L1.m_ptr);
    return 0;
}

// 运行程序: Ctrl + F5 或调试 >“开始执行(不调试)”菜单
// 调试程序: F5 或调试 >“开始调试”菜单

// 入门使用技巧: 
//   1. 使用解决方案资源管理器窗口添加/管理文件
//   2. 使用团队资源管理器窗口连接到源代码管理
//   3. 使用输出窗口查看生成输出和其他消息
//   4. 使用错误列表窗口查看错误
//   5. 转到“项目”>“添加新项”以创建新的代码文件，或转到“项目”>“添加现有项”以将现有代码文件添加到项目
//   6. 将来，若要再次打开此项目，请转到“文件”>“打开”>“项目”并选择 .sln 文件
