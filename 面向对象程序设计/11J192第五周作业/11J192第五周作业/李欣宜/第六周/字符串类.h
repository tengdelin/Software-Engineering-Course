#pragma once
using namespace std;

class MyStr {
	int m_length;
	char* m_buff;
public:
	MyStr(const char* val = nullptr);//默认构造函数
	MyStr(const MyStr& rhs);//复制构造函数
	MyStr(MyStr&& rhs);//移动构造函数
	~MyStr() { delete[]m_buff; }//析构函数
	MyStr& operator=(const MyStr& rhs);//复制构造函数的运算符重载
	MyStr& operator=(MyStr&& rhs);//移动构造函数的运算符重载
	static void swap(MyStr& rhs, MyStr& rhs2);//交换两个字符串的内容
	static void eras(MyStr& rhs, int n);//删除数组中的第n个元素
	friend MyStr operator+(const MyStr&, const MyStr&);//+运算符重载
	void print(MyStr& rhs);//输出函数
private:
	static int strlen(const char* val);//获取const字符串长度
	static int strlen(char* val);//获取字符串长度
	static void strncpy(char* val2, const char* val, int n);//将val指向的数组中前n个字符复制到val2指向的数组中
	static void strncpy(char* val2, int n, char* val,int m);//将val指向的数组中前m个字符复制到val2指向的数组中(从第n个位置开始)
};

//获取const字符串长度
int MyStr::strlen(const char* val) {
	int len = 0;
	while (val && *val++ != '\0')
		len++;
	return len;
}
//获取字符串长度
int MyStr::strlen(char* val) {
	int len = 0;
	while (val && *val++ != '\0')
		len++;
	return len;
}
//复制字符
void MyStr::strncpy(char* val2, const char* val, int n) {
	for (int i = 0; i < n; ++i)
		val2[i] = val[i];
}
void MyStr::strncpy(char* val2, int n, char* val, int m) {
	for (int i = 0, j = n; i < m; i++, j++)
		val2[j]=val[i];
}
//运算符重载
MyStr& MyStr::operator=(const MyStr& rhs) {
	if (this != &rhs) {
		delete[]m_buff;
		m_length = rhs.m_length;
		m_buff = new char[m_length];
		strncpy(m_buff, rhs.m_buff, m_length);
	}
	return *this;
}
MyStr& MyStr::operator=(MyStr&& rhs) {
	if (this != &rhs) {
		delete[]m_buff;
		m_length = rhs.m_length;
		m_buff = rhs.m_buff;
		rhs.m_buff = nullptr;
		rhs.m_length = 0;
	}
	return *this;
}
MyStr operator+(const MyStr& s1, const MyStr& s2) {
	MyStr res;
	res.m_length = s1.m_length + s2.m_length;
	res.m_buff = new char[res.m_length];
	MyStr::strncpy(res.m_buff, s1.m_buff, s1.m_length);
	MyStr::strncpy(res.m_buff, s1.m_length, s2.m_buff, s2.m_length);
	return res;
}

//构造函数：
//默认构造函数
MyStr::MyStr(const char* val) :m_length(strlen(val)), m_buff(m_length > 0 ? new char[m_length] : nullptr) {
	strncpy(m_buff, val, m_length);
}
//复制构造函数
MyStr::MyStr(const MyStr& rhs) : m_length(rhs.m_length), m_buff(m_length > 0 ? new char[m_length] : nullptr) {
	strncpy(m_buff, rhs.m_buff, m_length);
}
//移动构造函数
MyStr::MyStr(MyStr&& rhs) : m_length(rhs.m_length), m_buff(rhs.m_buff) {
	rhs.m_buff = nullptr;
	rhs.m_length = 0;
}

//打印函数
void MyStr::print(MyStr& rhs) {
	for (int i = 0; i < strlen(rhs.m_buff); i++)
		cout << rhs.m_buff[i];
}
//交换两个字符串的内容
void MyStr::swap(MyStr& rhs, MyStr& rhs2) {
	char* val3 = rhs.m_buff;
	int len = rhs2.m_length;
	for (int i = 0; i < len; i++)
		rhs.m_buff[i] = rhs2.m_buff[i];
	rhs2.m_buff = val3;
}
//删除val指向的数组中的第n个元素
void MyStr::eras(MyStr& rhs, int n) {
	char* val2=0;
	int len = rhs.m_length;
	for (int i = 0; i < n - 1; i++)
		val2[i] = rhs.m_buff[i];
	for (int i = n - 1; i < len - 1; i++)
		val2[i] = rhs.m_buff[i + 1];
	rhs.m_buff = val2;
}

//测试函数
void test() {
	MyStr mystr1 = "I am a boy";
	MyStr mystr2 = "I am a girl";
	MyStr mystr3 = mystr1;
	MyStr mystr4 = mystr1 + mystr2;
	mystr1.print(mystr1);//测试默认构造函数
	mystr3.print(mystr3);//测试复制构造函数
	mystr4.print(mystr4);//测试移动构造函数
	mystr3.eras(mystr3, 1); mystr3.print(mystr3);//测试删除函数
	mystr1.swap(mystr1, mystr2); mystr1.print(mystr1);//测试交换函数
}
