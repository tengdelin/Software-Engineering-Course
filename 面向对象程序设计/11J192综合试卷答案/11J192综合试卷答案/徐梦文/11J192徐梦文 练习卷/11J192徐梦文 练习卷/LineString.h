#pragma once
#include <iostream>
using namespace std;
class Point {
public:
	double x, y;
};
class LineString { //由多个点组成的线串类，由 n 个点组成的折线包含 n-1 个线段
public:
	LineString (Point *pnts,int num);//构造函数,通过传入点数组来构造
	LineString (const LineString &another); // 复制构造函数
    ~LineString (); // 析构函数
	LineString& operator =(const LineString& rhs); // 赋值函数
	Point& operator[](int index);//返回线串中第 index 个点的引用
private:
	Point  *m_data; // 用于保存组成线串的点
	int    m_num;// 线串中点的数量 
}; 

LineString::LineString(Point* pnts, int num): m_data(pnts) {
	m_num = num;
}
LineString::LineString(const LineString& another) {
	m_data = another.m_data;
	m_num = another.m_num;
}
LineString & LineString:: operator =(const LineString& rhs) {
	return LineString(rhs.m_data,rhs.m_num);
}
Point & LineString::operator[](int index) {
	Point temp;
	LineString templ(&temp,index);
	return temp;
}