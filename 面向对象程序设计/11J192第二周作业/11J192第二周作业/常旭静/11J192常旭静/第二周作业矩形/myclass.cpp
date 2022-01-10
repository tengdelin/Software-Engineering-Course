#include"myclass.h"
#include"math.h"
CPoint::CPoint(double a, double b) {
	x = a;
	y = b;
}//为成员数据赋值
double CPoint::miniusx(const CPoint& p, const CPoint& q) {
	double wide = fabs(p.x - q.x);
	return wide;
}//miniusx函数的实现
double CPoint::miniusy(const CPoint& p, const CPoint& q) {
	double length = fabs(q.y- p.y);
	return length;
}//miniusy函数的实现

CRectangle::CRectangle(CPoint& a1, CPoint& a2) {
	P1 = a1;
	P2 = a2;
}//含参构造函数的实现
double CRectangle::area() {
	double wide = CPoint::miniusx(P1, P2);
	double length = CPoint::miniusy(P1, P2);
	double area = wide * length;
	return area;
}//计算矩形面积
double CRectangle::cir() {
	double wide = CPoint::miniusx(P1, P2);
	double length = CPoint::miniusy(P1, P2);
	double cir = (wide + length) * 2;
	return cir;
}//计算矩形周长


