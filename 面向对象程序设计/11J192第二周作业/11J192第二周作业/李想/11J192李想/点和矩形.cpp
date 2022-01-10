#include<iostream>
using namespace std;
class Cpoint {
public:
	int x;
	int y;
	Cpoint(int m, int n) :x(m), y(n) {};
	Cpoint(const Cpoint& c);
	int getx() {
		return x;
	}
	int gety() {
		return y;
	}
};
Cpoint::Cpoint(const Cpoint& c) {
	x = c.x;
	y = c.y;
}
class rectangular {
	Cpoint x1;//左上角的点
	Cpoint x2;//右下角的点
public:
	rectangular(Cpoint p, Cpoint q) :x1(p), x2(q) {};
	void square();
	void length();
}; 
void rectangular::square() {
	int s;
	s = fabs((x1.x - x2.x) * (x1.y - x2.y));
	cout << "矩形面积为：" << s << endl;
}//求面积
void rectangular::length() {
    int l;
    l = 2 * (fabs(x1.x - x2.x) + fabs(x1.y- x2.y));
	cout << "矩形周长为：" << l << endl;
}//求周长
int main() {
	cout << "请输入矩形左上角和右下角的坐标：" << endl;
	int m, n, p, q;
	cin >> m >> n >> p >> q;
	Cpoint a(m,n), b(p,q);
	rectangular w(a,b);
	w.square();
	w.length();
	return 0;
}