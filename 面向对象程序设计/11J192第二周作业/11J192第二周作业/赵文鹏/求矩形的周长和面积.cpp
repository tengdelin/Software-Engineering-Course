#include<iostream>
using namespace std;
class CPoint {
public:
	int x, y;
	//默认构造函数
	CPoint() {
		x = 0; y = 0;
	};
	//打印函数
	void print() {
		cout << "(" << x << "," <<y<< ")" << endl;
	};
	//有参构造函数
	CPoint(int a, int b) {
		x = a;
		y = b;
	};
	//求横坐标
	void printx() {
		cout<<"这个点的横坐标为"<<x<<endl;
	};
	//求纵坐标
	void printy() {
		cout<<"这个点的纵坐标为"<<y<<endl;
	};
};
class CRetangle {
	CPoint p1, p2;
public:
	//无参构造函数
	CRetangle() {
		p1.x = 0;
		p1.y = 0;
		p2.x = 0;
		p2.y = 0;
	};
	//有参构造函数
	CRetangle(CPoint P1, CPoint P2) {
		p1 = P1;
		p2 = P2;
	};
	//求周长的函数
	int perimeter() {
		cout << (p2.x - p1.x + p1.y - p2.y) * 2 << endl;
		return (p2.x - p1.x + p1.y - p2.y) * 2;
	};
	//求面积的函数
	int area() {
		cout << (p2.x - p1.x) * (p1.y - p2.y)<<endl;
		return (p2.x - p1.x) * (p1.y - p2.y);
	};
};
int main() {
	cout << "请按照顺序输入该矩形左上角点的横坐标纵坐标 再输入右下角的点的横坐标纵坐标" << endl;
	int a, b,c,d;
	cin >>a>>b>>c>>d;
	CPoint A(a, b),B(c,d);
	CRetangle C(A, B);
	cout << "该矩阵的左上角的点为"; A.print();
	cout << "该矩阵的右上角的点为";  B.print();
	cout << "该矩阵的周长为"; C.perimeter();
	cout << "该矩阵的面积为";  C.area();
	
	return 0;
}