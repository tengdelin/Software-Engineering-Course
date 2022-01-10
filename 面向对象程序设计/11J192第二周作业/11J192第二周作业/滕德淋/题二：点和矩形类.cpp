#include<iostream>
using namespace std;
class point
{
	friend class rectangle;
	int m_x, m_y;
public:
	point(int x, int y);
	~point();
	int print();
};
//point类构造函数定义
point::point(int x,int y):m_x(x),m_y(y){}
//point类析构函数定义
point::~point(){}
//输出点类的横纵坐标函数（point类成员函数）
int point::print()
{
	cout << "(" << m_x << "," << m_y << ")" << endl;
	return m_x;
}


class rectangle
{
	int length, width;
public:
	rectangle(const point& a, const point& b);
	~rectangle();
	float cir();
	float area();
};
//rectangle类构造函数
rectangle::rectangle(const point& a, const point& b)
{
	length = abs(a.m_x - b.m_x);
	width = abs(a.m_y - b.m_y);
}
//rectangle类析构函数
rectangle::~rectangle(){}
//周长函数(rectangle类成员函数）
float rectangle::cir()
{
	return (length + width) * 2;
}
//面积函数（rectangle类成员函数）
float rectangle::area()
{
	return length * width;
}
int main()
{
	int x1, y1, x2, y2;
	cout << "请输入矩形左上角点：" << endl;
	cin >> x1 >> y1;
	cout << "请输入矩形右下角点：" << endl;
	cin >> x2 >> y2;
	point a(x1, y1);
	point b(x2, y2);
	a.print();
	b.print();
	rectangle myrect(a, b);
	cout << "周长：" << myrect.cir();
	cout << "面积：" << myrect.area();
	return 0;
}