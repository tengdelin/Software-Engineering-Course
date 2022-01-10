// ConsoleApplication6.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
#include<string.h>
using namespace std;
class Czifu
{//定义私有成员
	int len;
	char* str_p;
private://定义静态私有成员
	static int strlen(const char* ptr);
	static void strncpy(char* dest, const char* src, int n);
public:
	Czifu(const char* a) {//构造函数
		len = strlen(a);
		if (len > 0) {
			str_p = new char[len];
			strncpy(str_p, a, len);
		}
		else
			cout << "please put again!" << endl;
	}
	Czifu(const Czifu& a) {//拷贝构造
		len = a.len;
		if (len > 0)
			str_p = new char[len];
		strncpy(str_p, a.str_p, len);
	}
	void C_cout() {//输出字符串内容
		for (int i = 0; i < len; i++)
			cout << str_p[i];
		cout << endl;
	}
	~Czifu() {//析构函数
		delete[] str_p;
	};
	void replace() {//交换两字符的位置
		cout << "该对象的字符串中共有 " << len << " 个字符" << endl;
		cout << "该字符串为：";
		C_cout();
		cout << "请输入要交换的两个字符的位置0--" << len -1<< endl;
		int a, b;
		cin >> a >> b;
		char temp;
		temp = str_p[a];
		str_p[a] = str_p[b];
		str_p[b] = temp;
	}
	void erase() {//删除字符
		cout << "该字符串为：";
		C_cout();
		cout << "请输入要删除字符的位置0--" << len - 1 << endl;
		int i;
		cin >> i;
		len--;
		for (; i < len-1; i++) {
			str_p[i] = str_p[i + 1];
		}
		cout << "删除后的字符串为：";
		C_cout();
	}
	void insert() {//插入字符
		cout << "请输入要插入字符的位置:" << endl;
		int i = 0,j;
		for (; i < len; i++) {
			cout << i << str_p[i];
		}
		cout << i << endl;
		cin >> j;
		len++;
		char* p = new char[len];
		for (i = 0; i < len - 1; i++)
			p[i] = str_p[i];
		delete[] str_p;
		str_p = new char[len];
		for (i = 0; i < len - 1; i++)
			str_p[i] = p[i];
		delete[] p;
		char k;
		cout << "请输入要插入的字符：" << endl;
		cin >> k;
		for (i = len - 1; i > j; i--) {
			str_p[i] = str_p[i - 1];
		}
		str_p[j] = k;
	}
};
int Czifu::strlen(const char* ptr) {
	int len = 0;
	while (ptr&&* ptr++ != '\0')
		++len;
	return len;
}
void Czifu::strncpy(char* dest, const char* src, int n) {
	for (int i = 0; i < n; ++i)
		dest[i] = src[i];
}
int main(){
    Czifu a1("abcd");
	Czifu a2("efgh");
	Czifu a3(a1);
	a1.replace();
	a1.erase();
	a1.insert();
	a1.C_cout(), a2.C_cout(),a3.C_cout();
    return 0;
}
