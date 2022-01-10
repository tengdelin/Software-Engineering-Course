#include"矩阵.h"
#include<iostream>
#include<fstream>
using namespace std;
 matrix:: matrix(int n ) {
	 if (n == 1) {
		 ifstream fin;//定义一个文件类型的类
		 fin.open("test.txt", std::ios_base::in); // 打开当前对象的值所在的文件
		 if (!fin.is_open())
			 exit(EXIT_FAILURE);//终止程序
		 else
		 {
			 for (int i = 0;i < 4;i++) {
				 for (int j = 0;j < 4;j++) {
					 fin >> A[i][j];//给当前对象的成员数据赋值
				 }
			 }
			 fin.close();//关闭文件
		 }
	 }
	 else {
		 ifstream fin;
		 fin.open("test2.txt", std::ios_base::in); // ascii file
		 if (!fin.is_open())
			 exit(EXIT_FAILURE);
		 else
		 {
			 for (int i = 0;i < 4;i++) {
				 for (int j = 0;j < 4;j++) {
					 fin >> A[i][j];
				 }
			 }
			 fin.close();
		 }
	 }
}//构造函数初始化成员数据
 matrix::matrix() {
	 for (int i = 0;i < 4;i++) {
		 for (int j = 0;j < 4;j++) {
			 A[i][j] = 0;
		 }
	 }
 }//构造函数使成员数据的初值为0；
 matrix  matrix::operator*(const matrix& a)const {//*运算符重载
	 matrix c;
	 int n = 0;//储存累加所得数据用于给c.A[i][j]赋值
	 int m = 0;//用于计算c.A[j]中j的值
	 for (int b = 0;b < 4;b++) {
			 for (int i = 0;i < 4;i++) {
				 for (int j = 0; j < 4;j++) {
					 n += A[b][j] * a.A[j][i];
				 }
				 c.A[b][i] = n;
				 n = 0;
			 }
	 }
	 return c;
 }
 void matrix::print() {
	 cout << "此次计算结果为：" << endl;
	 for (int i = 0;i < 4;i++) {
		 for (int j = 0;j < 4;j++) {
			 if (j == 3) {
				 cout << A[i][j] << endl;//输出成员数据的值
			 }
			 else cout << A[i][j] << " ";
		 }
	 }
 }