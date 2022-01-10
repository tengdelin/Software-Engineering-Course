// ConsoleApplication3.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include "pch.h"
#include <iostream>
using namespace std;
template<class T,int n>
class S {//储存数据
	T a[n];
	T b=1;
public:
	S() {
		int i = 0;
		for (; i < n; i++) {
			b += b;
			a[i] = b;
		}
	};
	~S() {};
	int search(T m) {
		int j = 0;
		for (; j < n; j++) {
			if (a[j] == m)
				return j+1;
		}
		return -1;
	}
};
int main() {
	S<int,10>a;
	S<double, 5>b;
	if (a.search(8) >= 0)
		cout << a.search(8) << endl;
	if (b.search(4) >= 0)
		cout << b.search(4);
	return 0;
}