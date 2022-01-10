#include<iostream>
using namespace std;
class matrix {
	double arr[4][4];   //定义一个4*4的数组
public:
	matrix();
	matrix(double arr2[4][4]);
	~matrix();
	void setmatrix();    //存入矩阵中的各个元素
	void showmatrix();   //显示矩阵中的各个元素
	matrix operator*(const matrix& a);     //实现矩阵的乘法运算
	friend ostream& operator<<(ostream& os, const matrix& m);    //实现矩阵的输出
};
matrix::matrix(){}
matrix::matrix(double arr2[4][4]){}
matrix::~matrix()
{
	delete[]arr;
}
void matrix::setmatrix()
{
	for (int i = 0; i < 4; i++){
		for (int j = 0; j < 4; j++){
			cout << "请输入第" << i + 1 << "行" << "第" << j + 1 << "列的元素" << "\t";
			cin >> arr[i][j];
			cout << endl;
		}
	}
}
void matrix::setmatrix() {
	for (int i = 0; i < 4; i++)
	{
		for (int j = 0; j < 4; j++) {
			cout << arr[i][j] << " ";
			cout << endl;
		}
	}

}
matrix matrix::operator *(const matrix& a)
{
	matrix c;
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			c.arr[i][j] = (arr[i][j] * a.arr[1][j]) + (arr[i][2] * a.arr[2][j]) + (arr[i][3] * a.arr[3][j]) + (arr[i][4] * a.arr[4][j]);
		}
	}
}
ostream& operator<<(ostream& os, const matrix& m)
{
	for (int i = 0; i < 4; i++)
	{
		for (int j = 0; j < 4; j++)
		{
			os << *(m.arr + i * 4 + j) << "\t";
		}
		os << endl;
	}
	return os;
}
int main() {

}