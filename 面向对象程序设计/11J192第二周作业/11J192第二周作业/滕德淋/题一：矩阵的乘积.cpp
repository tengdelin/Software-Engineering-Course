#include<iostream>
using namespace std;
class juzhen
{
public:
	juzhen();
	~juzhen();
	double chenji(double a[4][4], double b[4][4], double c[4][4]);
	double print(double c[4][4]);
};
//构造函数
juzhen::juzhen(){}
//析构函数
juzhen::~juzhen(){}
//乘积运算函数
double juzhen::chenji(double a[4][4],double b[4][4], double c[4][4])
{
	for (int i = 0; i < 4; i++)
	{
		int c11(0), c12(0), c13(0), c14(0);
		for (int j = 0; j < 4; j++)
		{
			c11 = a[i][j] * b[j][0] + c11;
			c12 = a[i][j] * b[j][1] + c12;
			c13 = a[i][j] * b[j][2] + c13;
			c14 = a[i][j] * b[j][3] + c14;
		}
		c[i][0] = c11;
		c[i][1] = c12;
		c[i][2] = c13;
		c[i][3] = c14;
	}
	return c[4][4];
}
//输出函数
double juzhen::print(double c[4][4])
{
	for (int i = 0; i < 4; i++)
	{
		for (int j = 0; j < 4; j++)
		{
			cout << c[i][j] << " ";
		}
		cout << endl;
	}
	return c[4][4];
}

int main()
{
	double a[4][4], b[4][4];
	double c[4][4];
	//从文件中复制数据输入矩阵a,b;
	for (int i = 0; i < 4; i++)
	{
		for (int j = 0; j < 4; j++)
		{
			cin >> a[i][j];
		}
	}
	
	for (int i = 0; i < 4; i++)
	{
		for (int j = 0; j < 4; j++)
		{
			cin >> b[i][j];
		}
	}
	juzhen tdl;
	tdl.chenji(a, b, c);
	tdl.print(c);
	return 0;
}
		