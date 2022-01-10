#pragma once
//定义一个支持矩阵运算的类(matrix.h)
class matrix {
public:
    matrix();//默认构造函数；
	matrix(int);//自定义构造函数，n表示文件对应的选项
	void print();//输出当前对象中A中的元素
	matrix operator*(const matrix& a)const;//乘法运算符重载，用于矩阵的计算
private:
	int A[4][4];//成员数据为2维数组，用于盛放矩阵的值
};
