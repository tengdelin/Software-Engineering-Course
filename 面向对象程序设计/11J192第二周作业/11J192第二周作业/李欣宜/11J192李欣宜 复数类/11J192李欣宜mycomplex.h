//类的定义(mycomplex.h)
#pragma once
class CComplex
{
private:
	double m_real;		//复数的实部
	double m_image;	//复数的虚部
public:
	// double m_test;
	// 默认构造函数,内联函数
	CComplex()
	{
		m_real = 0; m_image = 0;
	}
	// 构造函数
	CComplex(double r, double i);
	//拷贝构造函数
	CComplex(const CComplex& c);

	//以下为运算函数
	CComplex add(const CComplex& c) const;//加法运算
	CComplex sub(const CComplex& c) const;//减法运算 
	CComplex mul(const CComplex& c) const;//乘法运算 
	CComplex div(const CComplex& c) const;//除法运算 

	//以下为运算符重载的函数
	CComplex operator+(const CComplex& c) const;//加法运算
	CComplex operator-(const CComplex& c) const;//减法运算
	CComplex operator*(const CComplex& c) const;//乘法运算
	CComplex operator/(const CComplex& c) const;//除法运算

	//获取实部
	double getreal();
	//获取虚部
	double getimage();

	//输出复数的内容
	void print();
};

int main(){
	CComplex c1(1, 1);//定义两个对象
	CComplex c2(2, 2);
	cout << c1.getreal()<<endl;//测试获取实部函数
	cout << c1.getimage()<<endl;//测试获取虚部函数
	//测试运算
	CComplex c;
	c = c1.add(c2);//测试加法运算
	c.print();
	c = c1.sub(c2);//测试减法运算
	c.print();
	c = c1.mul(c2);//测试乘法运算
	c.print();
	c = c1.div(c2);//测试除法运算
	c.print();
	//测试运算符重载
	c = c1 + c2;//加法运算符
	c.print();
	c = c1 - c2;//减法运算符
	c.print();
	c = c1 * c2;//乘法运算符
	c.print();
	c = c1 / c2;//除法运算符
	c.print();
	return 0;
}