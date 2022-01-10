#include "Complex.h"
#include<iostream>
using namespace std;

Complex::Complex(double a,double b)
{
	real=a;
	virl=b;
}

Complex::Complex(Complex& num)
{
	real = num.real;
	virl = num.virl;
}


Complex operator-(const Complex& num1, const Complex& num2)
{
	Complex end(0, 0);
	end.real = num1.real - num2.real;
	end.virl = num1.virl - num2.virl;
	return end;
}

Complex operator*(const Complex& num1, const Complex& num2)
{
	Complex end(0, 0);
	end.real = (num1.real * num2.real)-(num1.virl*num2.virl);
	end.virl = (num1.virl * num2.real)+(num1.real*num2.virl);
	return end;
}

ostream& operator<<(ostream&os, const Complex&end)
{
	os << end.real << " ," << end.virl << endl;
	return os;
}

Complex operator+(const Complex& num1, const Complex& num2)
{
	Complex end(0, 0);
	end.real = num1.real + num2.real;
	end.virl = num1.virl + num2.virl;
	return end;
}
