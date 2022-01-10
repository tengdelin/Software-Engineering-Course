// ConsoleApplication2.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include "pch.h"
#include <iostream>
#include<string>
using namespace std;
template<class T>
void sort(T*a, int n) {//用来排序的函数模板
	int i, j;
	T b;
	for (i = 0; i < n - 1; i++) {
		for (j = i+1; j < n ; j++) {
			if (a[i] < a[j]) {
				b = a[i];
				a[i] = a[j];
				a[j] = b;
			}
		}
	}
}
template<class t>//用来输出的函数模板
void cout(t*a, int n) {
	int i = 0;
	for (; i < n; i++) {
		cout << a[i] << " ";
	}
}
int main() {
	string name[8] = { "a1","b2","c3","d4","e5","f6","g7","h8" };
	double grade[8] = { 98,87,97,65,54,43,32,65 };
	sort<string>(name, 8);//模板实例化为string类型的模板函数
	sort<double>(grade, 8);//模板实例化为double类型的模板函数
	cout<string>(name, 8);//输出
	cout<double>(grade, 8);
	return 0;
}
