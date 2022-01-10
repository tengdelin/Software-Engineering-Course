#include <iostream>//引入头文件
using namespace std;

class Cssr//定义一个类
{
public://函数
	void set_Cssr(int temp1[4][4], int temp2[4][4]);
	int runA(int l1[4][4],int l2[4][4],int l3[4][4]);
	int Fz(int b1[4][4], int b2[4][4]);
	
//private://数据
	int l1[4][4] = { 0 };
	int l2[4][4] = { 0 };
	int l3[4][4];
};

void Cssr::set_Cssr(int temp1[4][4], int temp2[4][4]) {//输入
	Fz(l1,temp1);
	Fz(l2,temp2);
};
int Cssr::runA(int l1[4][4], int l2[4][4], int l3[4][4]) {//计算矩阵
	for (int a = 0; a < 4; a++)
	{for (int b = 0; b < 4; b++) 
	{
			l3[a][b] = l1[a][0] * l2[0][b] + l1[a][1] * l2[1][b] + l1[a][2] * l2[2][b] + l1[a][3] * l2[3][b];
		}
	}
	return 0;
};
int Cssr::Fz(int b1[4][4],int b2[4][4]) {//传递
	for (int a=0; a < 4; a++) {
		for (int b = 0; b < 4; b++)
		{
			b1[a][b] = b2[a][b];
		}
	}
	return 0;
}

int main() {//主函数
	Cssr my;
	int m1[4][4] = { 0 };
	int m2[4][4] = { 0 };
	int m3[4][4] = { 0 };
	for (int i = 0; i < 4; i++)//输入第一个矩阵
	{
		for (int j = 0; j < 4; j++) { cin >> m1[i][j]; }
	}
	for (int i = 0; i < 4; i++)//输入矩阵
	{
		for (int j = 0; j < 4; j++) { cin >> m2[i][j]; }
	}
	my.set_Cssr(m1, m2);
	my.runA(m1, m2,m3);
	for (int i = 0; i < 4; i++) {//输出结果
		for (int j = 0; j < 4; j++)
		{
			cout << m3[i][j]<<" ";
		}cout << endl;
	}
	return 0;
}