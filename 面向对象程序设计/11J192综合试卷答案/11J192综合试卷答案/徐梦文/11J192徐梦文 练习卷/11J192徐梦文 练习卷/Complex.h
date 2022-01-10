#pragma once
#include <iostream>
using namespace std;

class Complex {
public:
	Complex(double x=0.0, double y=0.0);//构造函数
	Complex operator+(Complex& c) { //+运算符重载
		Complex com;
		com.a = this->a + c.a;
		com.b = this->b + c.b;
		return com;
	}
	Complex operator-(Complex& c) { //-运算符重载
		Complex com;
		com.a = a - c.a;
		com.b = b - c.b;
		return com;
	}
	Complex operator*(Complex & c) { //乘法*运算符重载
			Complex com;
			com.a = a * c.a;
			com.b = b * c.b;
			return com;
		}
	Complex operator/(Complex& c){ //除法/运算符重载
		Complex com;
		com.a = a / c.a;
		com.b = b / c.b;
		return com;
	}
	friend ostream& operator<<(ostream& out,const Complex& c);//输出运算符重载
private:
	double a;
	double b;
};
Complex::Complex(double x, double y):a(x),b(y) {

}

ostream& operator<<(ostream& out, const Complex& c) {
	if(c.b>0)
	    out << c.a << "+" << c.b << 'i';
	if (c.b < 0)
		cout << c.a << "-" << c.b << 'i';
	if (c.b == 0)
		cout << c.a;
	return out;
}