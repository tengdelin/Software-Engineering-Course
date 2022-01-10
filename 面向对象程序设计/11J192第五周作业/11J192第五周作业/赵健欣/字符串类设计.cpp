#include <iostream>
#include <string>
#include <fstream>
using namespace std;
char s[12];
char s0[20];
const int max = 5;
const char* path = "‪C:\\Users\\lenovo\\Desktop\\1.txt";
class Cstring {
public:
	char* p;
	int length;
	Cstring(char* s, int n) {                 //构造函数
		p = new char[strlen(s) + 1];
		strcpy(p, s);
		length = n;
	}
	~Cstring() {                              //析构函数
		delete[] p;
	}
	void replace(char* a) {                   //替换字符
		char* temp1, * temp2;
		temp1 = new char[length];
		temp2 = new char[strlen(a) + 1];
		strcpy(temp1, p);
		strcpy(temp2, a);
		p = temp2;
		a = temp1;
		cout << a << endl;
		cout << p << endl;
	}
	void append(char* b) {
		char* a;
		a = new char[strlen(b) + length];
		strcpy(a, p);
		strcat(a, b);
		p = a;
		cout << p << endl;
	}
};
	char write(int n) {
		ofstream out;
		out.open(path);
	}
	char *read(int n) {
		ifstream in;
		in.open(path);
	}

int main() {
	cout << "请输入字符串（数量小于5）：" << endl;
	write(max);
	cout << "您输入的第几个字符串：" << endl;
	int m;
	cin >> m;
	Cstring p(read(m),12);
	cout << p.p << endl;
	cout << "请选择第几个字符串进行交换：" << endl;
	int n;
	cin >> n;
	p.replace(read(n));
}