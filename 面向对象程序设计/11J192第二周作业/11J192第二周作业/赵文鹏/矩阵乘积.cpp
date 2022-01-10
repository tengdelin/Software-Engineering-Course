#include<iostream>
using namespace std;
template<typename T>class CMatrix {
public:
	CMatrix();
	void print();
	CMatrix product(const CMatrix& c);
	CMatrix(const CMatrix& c);
	CMatrix operator*(const CMatrix& c);
private:
	T a[4][4];
};
//构造函数
template< typename T>CMatrix<T>::CMatrix() {
	cout << "手动输入选择1，初始化为0矩阵选择0" << endl;
	int n;
	cin >> n;
	if(n==1){
		cout << "请依次输入该矩阵的元素(从左到右从上到下)" << endl;
		int i, j;
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 4; j++) {
				cin >> a[i][j];
			}
		}
	}
	if (n == 0) {
		cout << "该矩阵的元素全部初始化为0" << endl;
		int i, j;
		for (i = 0; i < 4; i++) {
			for (j = 0; j < 4; j++) {
				 a[i][j]=0;
			}
		}
	}
	
};

//打印数组
template< typename T>void CMatrix<T>::print() {
	int i, j;
	for (i = 0; i < 4; i++) {
		for (j = 0; j < 4; j++) {
			cout<<"  "<<a[i][j];
		}
		cout << endl;
	}
}
//乘积函数
template<typename T>
CMatrix<T> CMatrix<T>::product(const CMatrix& c)
{
	cout << "过渡矩阵，请初始化为0矩阵" << endl;
	CMatrix<T> tem;
	int i, j;
	for (i = 0; i < 4; i++) {
		for (j = 0; j < 4; j++) {
			tem.a[i][j] = a[i][j] * c.a[j][i];
		}
	}
	return tem;
};
//复制构造函数
template< typename T>CMatrix<T>::CMatrix(const CMatrix& c) {
	int i, j;
	for (i = 0; i < 4; i++) {
		for (j = 0; j < 4; j++) {
			a[i][j] =  c.a[i][j];
		}
	}
}

//运算符重载
template<typename T>CMatrix<T> CMatrix<T>::operator*(const CMatrix& c) {
	cout << "过渡矩阵，请初始化为0矩阵" << endl;
	CMatrix<T> tem;
	int i, j;
	for (i = 0; i < 4; i++) {
		for (j = 0; j < 4; j++) {
			tem.a[i][j] = a[i][j] * c.a[j][i];
		}
	}
	return tem;
};
int main() {
	CMatrix<int> A,B,C;
	cout << "您输入的第一个矩阵为" << endl;
	A.print();
	cout << "您输入的第二个矩阵为" << endl;
	B.print();
	// C=A.product(B);
	 C = A * B;//运算符重载过了
	 cout << "这两个矩阵的乘积为" << endl;
	 C.print();
	 return 0;
}


