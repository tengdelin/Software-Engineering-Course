#include "pch.h"
#include<iostream>
using namespace std;
class dot {//二维平面点的类
private:
	int x, y;//x为横坐标，y为纵坐标
public:
	friend class rectrangle;//声明友元
	dot(int x1,int y1):x(x1),y(y1){}//给x，y赋值
	~dot(){}//析构函数
	dot() {//输出点的坐标
		cout << "点的横坐标为：" << x << endl;
		cout << "点的纵坐标为：" << y << endl;
	}
};
class rectrangle {
private:
	int s, c;//s代表面积，c代表周长
public:
	rectrangle():s(0),c(0){}
	~rectrangle() {};
	void count_s(dot a, dot b) {//计算面积，a为左上角点，b为右上角点
		s = (a.y - b.y)*(b.x - a.x);
		cout << "以点(" << a.x << "," << a.y << ")为左上角点，" << endl;
		cout << "以点(" << b.x << "," << b.y << ")为右下角点的矩形的面积为:" << s << endl;;
	}
	void count_c(dot a, dot b) {//计算矩形周长
		c = 2 * (a.y - b.y + b.x - a.x);
		cout << "以点(" << a.x << "," << a.y << ")为左上角点，" << endl;
		cout << "以点(" << b.x << "," << b.y << ")为右下角点的矩形的周长为:" << c << endl;;
	}
};
int main() {
	int x1, y1, x2, y2;
	cout << "请输入矩形的左上角点的坐标:" << endl;
	cin >> x1 >> y1;
	cout << "请输入矩形的右下角点的坐标:" << endl;
	cin >> x2 >> y2;
	dot a(x1, y1);
	dot b(x2, y2);
	rectrangle juxing;
	juxing.count_c(a, b);
	juxing.count_s(a, b);
	return 0;
}
