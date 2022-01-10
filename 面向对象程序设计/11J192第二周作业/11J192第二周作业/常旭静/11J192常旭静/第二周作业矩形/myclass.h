#pragma once
//类的定义(myclass.h)
class CPoint {//定义一个点类
public:
	CPoint(){};//默认构造函数
	CPoint(double a, double b) ;//含参构造函数
	~CPoint() {};//析构函数
	static double  miniusx(const CPoint& p, const CPoint& q);//得到矩形的宽
	static double  miniusy(const CPoint& p, const CPoint& q);//得到矩形的长
private:
	double x, y;//成员数据为横纵坐标
};
class CRectangle {
public:
	CRectangle(CPoint&a1, CPoint&a2);//含参构造函数
	double area();//计算矩形面积
	double cir();//计算矩形周长
private:
	CPoint P1;
	CPoint P2;//成员数为矩形左上角和右下角坐标
};