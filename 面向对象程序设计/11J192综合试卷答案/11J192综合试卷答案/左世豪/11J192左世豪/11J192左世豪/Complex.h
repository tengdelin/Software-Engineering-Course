#pragma once
#include <iostream>
using namespace std;
class Complex {
	double real;
	double virl;
public:
	Complex(double a, double b);
	Complex(Complex& num);

	friend ostream& operator<<(ostream&, const Complex&);
	friend Complex operator+(const Complex& num1, const Complex& num2);
	friend Complex operator-(const Complex& num1, const Complex& num2);
	friend Complex operator*(const Complex& num1, const Complex& num2);
};