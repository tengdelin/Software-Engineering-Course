#include<iostream>
using namespace std;
class Cpoint {
public:
	int x;
	int y;
	Cpoint(int m, int n) {
		x = m;
		y = n;
	}
	~Cpoint() {}
	friend class Cfraction;
};
class Cfraction {
public:
	int s;
	int c;
	Cpoint a(int x1, int y1);
	Cpoint b(int x2, int y2);
	Cfraction(Cpoint a, Cpoint b) {
		s = (b.x - a.x) * (a.y - b.y);
		c = 2 * (b.x - a.x) + 2 * (a.y - b.y);
	}
	~Cfraction(){}
};
int main() {
	int x1, y1, x2, y2;
	cin >> x1 >> y1 >> x2 >> y2;
	Cpoint a(x1, y1);
	Cpoint b(x2, y2);
	Cfraction c(a, b);
	cout << "矩形的面积:" << c.s << endl;
	cout << "矩形的周长：" << c.c << endl;
	return 0;

}

