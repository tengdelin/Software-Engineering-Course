#include<iostream>
using namespace std;
class Cpoint {
public:
	int x, y;
	Cpoint(int m, int n) {
		x = m;
		y = n;
	}
	~Cpoint(){}
	friend class Fraction;
};
class Fraction {
public: 
	int area;
	int length;
	Cpoint a(int x1, int y1);
	Cpoint b(int x2, int y2);
	Fraction(Cpoint a, Cpoint b) {
		area = (b.x - a.x) * (a.y - b.y);
		length = 2 * (b.x - a.x) + 2 * (a.y - b.y);
	}
	~Fraction(){}
};
int main() {
	int x1, y1, x2, y2;
	cin >> x1 >> y1 >> x2 >> y2;
	Cpoint a(x1,y1), b(x2,y2);
	Fraction c(a, b);
	cout << "矩形的面积为：" << c.area << endl;
	cout << "矩形的周长为：" << c.length;
	return 0;
}