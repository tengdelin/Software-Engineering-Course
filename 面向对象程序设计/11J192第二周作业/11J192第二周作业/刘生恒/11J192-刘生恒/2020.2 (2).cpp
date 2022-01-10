#include<iostream>
using namespace std;//头文件

class Cpj;//创建两个类point和Cpj
class Point
{
public://公有
	Point();
	Point(int x, int y); 
	Point(Point& p); 
	void Show();
	friend class Cpj;
private://私有
	int X, Y;
};
Point::Point()//构造函数
{X = 0;
Y = 0;}
Point::Point(int x, int y){//赋值
	X = x;
	Y = y;
}
Point::Point(Point& p){//形成一个对象
	X = p.X;
	Y = p.Y;
}
void Point::Show()
{cout << "X=" << X << ",Y=" << Y << endl;}

class Cpj//代表矩形的类
{
public:
	Cpj();
	Cpj(Point p0, int x, int y);
	int C(Point p0, int x, int y);
	int M(Point p0, int x, int y);
	int Jd(int x);
private:
	int X2, Y2;
};
Cpj::Cpj() {//构造函数
	X2 = 0;
	Y2 = 0;
}
Cpj::Cpj(Point p0, int x, int y) {//重构函数
	X2 = x;
	Y2 = y;
}
int Cpj::C(Point p0, int x, int y) {//计算周长
	int Cc;
	Cc = 2*(Jd(p0.X-x)+Jd(p0.Y-y));
	return Cc;
}
int Cpj::M(Point p0, int x, int y) {//计算面积
	int Mm;
	Mm = (p0.X - x) * (p0.Y - y);
	return Jd(Mm);
}
int Cpj::Jd(int x) {//绝对值函数
	if (x < 0) { x = 0 - x; };
	return x;
}

int main() {//主函数
	int a = 0, b = 0, c = 0, d = 0;
	cout << "输入坐标：";
	cin >> a >> b;
	Point p0(a, b);
	cout << "输入坐标：";
	cin >> c >> d;
	Cpj A;
	cout << "周长为"<<A.C(p0, c, d) << endl;//计算
	cout << "面积为" << A.M(p0, c, d) << endl;
	return 0;
}