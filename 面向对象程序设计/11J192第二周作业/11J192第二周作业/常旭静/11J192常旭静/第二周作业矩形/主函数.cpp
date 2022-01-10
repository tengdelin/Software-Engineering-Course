#include<iostream>
using namespace std;
#include"myclass.h"
int main() {
	double a, b, c, d;//定义变量来储存坐标
	cout << "请输入矩形的坐上坐标和右下坐标：" << endl;
	cin >> a >> b >> c >> d;
	CPoint P1(a, b);
	CPoint P2(c, d);//定义两个点对象，分别为矩形的左上坐标和右下坐标
	CRectangle R1(P1, P2);
	double area = R1.area();//调用area函数计算矩形面积
	double cir = R1.cir();//调用cir函数计算矩形周长
	cout << "矩形面积为：" << area << endl;
	cout << "矩形周长为：" << cir;//输出周长和面积
	return 0;
}