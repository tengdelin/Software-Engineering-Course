#include<iostream>
#include<cmath>
using namespace std;
class point {
public:
	point(int a = 0, int b = 0) ://构造函数初始化
		x(a),y(b){ }
	friend class rectangle;
	int X() { return x;}//返回x；
	int Y() { return y; }//返回y；
private:
	int x;//坐标x
	int y;//坐标y
};
class rectangle {
public:
	rectangle() :
		length(1), width(1) {};//若没有传入的点，将其初始化；
	rectangle(const point& A, const point& B) {//传入两点，并将其初始化
		int mid1 = A.y - B.y;
		int mid2 = A.x - B.x;
		length = abs(mid1);
		width = abs(mid2);
	}
	const int Sarea() {
		area = length * width;//计算面积
		return area;
	}
	const int CR() {
		C = (length + width) * 2;//计算周长
		return C;
	}
private:
	int length;//长
	int width;//宽
	int area;//面积
	int C;//周长

};
int main() {
	point A(1, 5);
	point B(2, 3);
	rectangle D(A, B);
	int b = D.Sarea();
	int a = D.CR();
	cout<<"周长"<<a << " " <<"面积"<< b << endl;
}