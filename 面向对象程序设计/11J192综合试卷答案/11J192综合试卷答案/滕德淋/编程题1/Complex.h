#pragma once
#include<iostream>
using namespace std;
class complex
{
public:
	int m_real;
	int m_image;
	complex() = default;
	complex(int real, int image);
	//加运算符重载
	complex operator+(complex &c);
	//减运算符重载
	complex operator-(complex& c);
	//乘运算符重载
	complex operator*(complex& c);
	//friend ostream& operator<<(ostream& os, const complex& c);
};
ostream& operator<<(ostream& os, const complex& c);
