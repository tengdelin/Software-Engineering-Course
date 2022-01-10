#include<iostream>
using namespace std;
int irray = 4;
class matrix {
public:
	matrix() {//默认构造函数
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				mat[i][j] = 0;
			}
		}
	}
	matrix(const int  a[][4], const int iarr) {//输入一个矩阵并初始化
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				mat[i][j] = a[i][j];
			}
		}
	}
	friend matrix operator *(const matrix& a, const matrix&  b);//重载*
	void print();
private:
	int mat[4][4];//定义一个4*4矩阵
};
void matrix::print() {//输出这个矩阵
	for (int i=0; i < 4; i++) {
		for (int j=0; j < 4; j++) {
			cout << mat[i][j] << " ";

		}
		cout << " " << endl;
	}
	
}
matrix operator *(const matrix& a, const matrix& b) {
	matrix c;
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			c.mat[i][j] = a.mat[i][0] * b.mat[0][j] + a.mat[i][1] * b.mat[1][j] + a.mat[i][2] * b.mat[2][j] + a.mat[i][3] * b.mat[3][j];//因为是4*4矩阵，直接代公式
		}
	}
	return c;
}
int main() {
	int A[4][4] = { {1,2,3,4},{5,6,7,8,},{2,3,4,5},{4,5,6,7} };
	int B[4][4] = { {2,2,2,2},{2,2,2,2},{2,2,2,2},{2,2,2,2} };
	matrix a(A, irray);
	matrix b(B, irray);
	matrix c;
	c = a * b;
	a.print();
	c.print();
	
	
}