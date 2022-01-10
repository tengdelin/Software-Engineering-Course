#include<iostream>
using namespace std;
class CMatrix {
public:
	CMatrix();//构造函数
	~CMatrix();//析构函数
	double show();//显示
	CMatrix operator*(const CMatrix& a) {//运算符重载
		CMatrix c;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				c.arr[i][j] = (arr[i][1] * a.arr[1][j]) + (arr[i][2] * a.arr[2][j]) + (arr[i][3] * a.arr[3][j]) + (arr[i][4] * a.arr[4][j]);
			}
		}
		return c;
	}
private:
	double arr[4][4] = { 0 };
};
CMatrix::CMatrix() {
	cout << "请从第一行从左开始输入矩阵的个元素" << endl;
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			cin >> arr[i][j];
		}
	}
}
double CMatrix::show() {
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			cout << arr[i][j] << '\t';
		}
		cout << endl;
	}
	return 0;
}
int main() {
	CMatrix my_matrix_one;
	CMatrix my_matrix_two;
	CMatrix my_matrix_three;
	cout << "进行矩阵的乘法" << endl;
	my_matrix_three = my_matrix_one * my_matrix_two;
	cout << "显示结果" << endl;
	my_matrix_three.show();
	return 0;
}