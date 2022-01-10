#include"Complex.h"
complex::complex(int real, int image)
{
	m_real = real;
	m_image = image;
}
//加运算符重载
complex complex::operator+(complex& c)
{
	complex temp;
	temp.m_real = m_real + c.m_real;
	temp.m_image = m_image + c.m_image;
	return temp;
}
//减运算符重载
complex complex::operator-(complex& c)
{
	complex temp;
	temp.m_real = m_real - c.m_real;
	temp.m_image = m_image - c.m_image;
	return temp;
}
//乘运算符重载
complex complex::operator*(complex& c)
{
	complex temp;
	temp.m_real = m_real * c.m_real - m_image * c.m_image;
	temp.m_image = m_image * c.m_real + m_real * c.m_image;
	return temp;
}
//输出运算符重载
ostream& operator<<(ostream& os, const complex& c)
{
	if (c.m_image > 0)
		os << c.m_real << '+' << c.m_image << 'i';
	if (c.m_image < 0)
		os << c.m_real << c.m_image << 'i';
	if (c.m_image == 0)
		os << c.m_real;
	return os;
}
