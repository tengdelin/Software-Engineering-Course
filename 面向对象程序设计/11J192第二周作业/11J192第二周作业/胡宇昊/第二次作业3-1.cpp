// ConsoleApplication2.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//


#include "pch.h"
#include<iostream>
using namespace std;
void cin_shuzu(int* m, int* n);
class shuzu {
private:
	int  c[16] = { 0 };
public:
	shuzu(int *A, int *B) {//用来给类中的私有成员赋值
		int i(0), j(0), k(0),j1(0),i1(0);
		for (; k < 16; k++) {
			if (k % 4 == 0 && k != 0){
				i1++,j1=0;
			}
			for (i = i1, j = j1; j < 16; i++, j += 4) {
				c[k] += A[i] * B[j];
			}
			j1++;
		}
	}
	~shuzu() {}
	void cout_c() {
		int a = 0;
		cout << "A*B={" << endl;
		for (; a < 16; a++) {
			if (a % 4 == 0 && a != 0)
				cout << endl;
			cout << c[a] << " ";
		}
		cout << "}" << endl;
	}
};
int main() {//主函数
	int A[16] = { 0 }, B[16] = { 0 };
	cin_shuzu(A, B);
	shuzu abc(A,B);
	abc.cout_c();
	return 0;
}
void cin_shuzu(int* m, int* n) {//输入数组
	int i = 0;
	cout << "请依次输入A数组的各值" << endl;
	for (; i < 16; i++) {
		cin >> m[i];
	}
	cout << "请依次输入B数组的各值" << endl;
	for (i = 0; i < 16; i++) {
		cin >> n[i];
	}
}

