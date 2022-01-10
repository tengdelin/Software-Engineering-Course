#include <iostream>
using namespace std;
class CM
{
public:
	int CA();//建立矩阵A
	int CB();//建立矩阵B
	int CSum();
private:
	int a[4][4];
	int b[4][4];
};
int CM::CA()
{
	int a[4][4];
	for (int i = 0; i < 4; i++)
	{
		for (int j = 0; j < 4; j++)
			a[i][j] = 1 + rand() % 9;
	}
	return 0;
}
int CM::CB()
{
	int b[4][4];
	for (int i = 0; i < 4; i++)
	{
		for (int j = 0; j < 4; j++)
			b[i][j] = 1 + rand() % 9;
	}
	return 0;
}
int CM::CSum()
{
	int sum;
	for (int i = 0; i < 4; i++)
	{
		for (int j = 0; j < 4; j++)
		{
			sum = a[i][j] + b[i][j];
		}
	}
	cout << "乘积为：" << sum;
	return 0;
}
int main()
{

	CM put;
	put.CA();
	put.CB();
	put.CSum();
	return 0;
}

