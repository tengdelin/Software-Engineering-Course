#include <iostream>
using namespace std;
#include "mycomplex.h"

//有参构造函数
CComplex::CComplex(double r, double i)
{
	m_real = r;
	m_image = i;
}

//拷贝构造函数
CComplex::CComplex(const CComplex& c)
{
	m_real = c.m_real;
	m_image = c.m_image;
}

//加法运算
CComplex CComplex::add(const CComplex& c) const
{
	CComplex rtn;
	rtn.m_real = m_real + c.m_real;
	rtn.m_image = m_image + c.m_image;
	return rtn;
}
//加法运算 运算符重载
CComplex CComplex::operator+(const CComplex& c) const
{
	CComplex rtn;
	rtn.m_real = m_real + c.m_real;
	rtn.m_image = m_image + c.m_image;
	return rtn;
}

//减法运算
CComplex CComplex::sub(const CComplex& c) const
{
	CComplex rtn;
	rtn.m_real = m_real - c.m_real;
	rtn.m_image = m_image - c.m_image;
	return rtn;
}
//减法运算 运算符重载
CComplex CComplex::operator-(const CComplex& c) const
{
	CComplex rtn;
	rtn.m_real = m_real - c.m_real;
	rtn.m_image = m_image - c.m_image;
	return rtn;
}

//乘法运算
CComplex CComplex::mul(const CComplex& c) const
{
	CComplex rtn;
	rtn.m_real = m_real * c.m_real-m_image * c.m_image;
	rtn.m_image = m_image * c.m_real + c.m_image * m_real;
	return rtn;
}
//乘法运算 运算符重载
CComplex CComplex::operator*(const CComplex& c) const
{
	CComplex rtn;
	rtn.m_real = m_real * c.m_real - m_image * c.m_image;
	rtn.m_image = m_image * c.m_real + c.m_image * m_real;
	return rtn;
}

//除法运算
CComplex CComplex::div(const CComplex& c) const
{
	CComplex rtn;
	rtn.m_real = (m_real * c.m_real + m_image * c.m_image) / (c.m_real * c.m_real+c.m_image * c.m_image);
	rtn.m_image = (m_image * c.m_real - c.m_image * m_real) / (c.m_real * c.m_real + c.m_image * c.m_image);
	return rtn;
}
//除法运算 运算符重载
CComplex CComplex::operator/(const CComplex& c) const
{
	CComplex rtn;
	rtn.m_real = (m_real * c.m_real + m_image * c.m_image) / (c.m_real * c.m_real + c.m_image * c.m_image);
	rtn.m_image = (m_image * c.m_real - c.m_image * m_real) / (c.m_real * c.m_real + c.m_image * c.m_image);
	return rtn;
}

//输出实部
double CComplex::getreal() {
	return m_real;
}
//输出虚部
double CComplex::getimage() {
	return m_image;
}

//打印出复数的内容：
void CComplex::print()
{
	//1+2i;1-3i;
	if (m_image > 0)
	{
		cout << "复数" << m_real << "+" << m_image << "i" << endl;
	}
	else if (m_image == 0)
	{
		cout << "实数" << m_real << endl;
	}
	else
	{
		cout << "复数" << m_real << "-" << fabs(m_image) << "i" << endl;
	}
}


