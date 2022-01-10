#pragma once
#include <iostream> 
using namespace std;

class Complex
{
private:
	double m_real;	//复数的实部
	double m_image;	//复数的虚部
public:
	Complex()
	{
		m_real = 0; m_image = 0;
	}
	// 构造函数
	Complex(double r, double i);
	//运算符重载的
	Complex operator+(const Complex& c) const;//加法
	Complex operator-(const Complex& c) const;//减法
	Complex operator*(const Complex& c) const;//乘法
	friend ostream& operator<<(ostream& os, const Complex& c);//输出
};
Complex::Complex(double r, double i)
{
	m_real = r;
	m_image = i;
}
Complex Complex::operator+(const Complex& c) const
{
	Complex rtn;
	rtn.m_real = m_real + c.m_real;
	rtn.m_image = m_image + c.m_image;
	return rtn;
}
Complex Complex::operator-(const Complex& c) const
{
	Complex rtn;
	rtn.m_real = m_real - c.m_real;
	rtn.m_image = m_image - c.m_image;
	return rtn;
}
Complex Complex::operator*(const Complex& c) const
{
	Complex rtn;
	rtn.m_real = m_real * c.m_real - m_image * c.m_image;
	rtn.m_image = m_image * c.m_real + c.m_image * m_real;
	return rtn;
}
ostream& operator<<(ostream& os, const Complex& c)
{
	os << "(" << c.m_real << "," << c.m_image << ")";
	return os;
}
