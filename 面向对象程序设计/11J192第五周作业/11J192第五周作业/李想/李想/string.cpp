#include"string.h"//字符串类
mystr::mystr(const char* val) :
	m_length(strlen(val)), m_buff(m_length > 0 ? new char[m_length]: nullptr) {
	strncpy(m_buff, val, m_length);
}//默认构造函数
int mystr::strlen(const char* ptr) {
	int len = 0;
	while (ptr&&*ptr++ != '/0') {
		++len;
	}
	return len;
}//获取c风格字符串长度
void mystr::strncpy(char* dest, const char* src, int n) {
	for (int i = 0; i < n; ++i) {
		dest[i] = src[i];
	}
}//复制src指向的数组中前n个字符到dest指向的数组中
ostream& operator<<(ostream& os, const mystr& s) {
	for (int i = 0; i < s.m_length; ++i) {
		os << s.m_buff[i];
		return os;
	}
}//运算符<<重载
mystr operator+ (const mystr&s1, const mystr&s2) {
	mystr res;
	res.m_length = s1.m_length + s2.m_length;
	res.m_buff = new char[res.m_length];
	mystr::strncpy(res.m_buff, s1.m_buff, s1.m_length);
	mystr::strncpy(res.m_buff + s1.m_length, s2.m_buff, s2.m_length);
	return res;
}//运算符+重载
mystr::mystr(const mystr& rhs) :
	m_length(rhs.m_length),m_buff(m_length>0?new char[m_length]:nullptr){
	strncpy(m_buff, rhs.m_buff, rhs.m_length);
}//复制构造函数
mystr& mystr::operator=(const mystr& rhs) {
	if (this != &rhs) {
		delete[]m_buff;
		m_length = rhs.m_length;
		m_buff = new char[m_length];//重新分配内存
		strncpy(m_buff, rhs.m_buff, m_length);
	}
	return *this;
}//等号的重载
mystr::mystr(mystr&& rhs):m_length(rhs.m_length), m_buff(m_length > 0 ? new char[m_length] : nullptr) {
	strncpy(m_buff, rhs.m_buff, m_length);
}
mystr& mystr:: operator=(mystr&& rhs) {
	if (this != &rhs) {
		delete[]m_buff;
		m_length = rhs.m_length;
		m_buff = rhs.m_buff;
		rhs.m_buff = nullptr;
		rhs.m_length = 0;
	}
	return *this;
}//移动赋值运算符
void mystr::swap(mystr&s1, mystr&s2) {
	mystr s3;
	s3 = s1;
	s1 = s2;
	s2 = s3;
}//交换两个字符串的内容
mystr mystr:: max(const mystr&s1, const mystr&s2) {
	if (s1.m_length > s2.m_length) {
		return s1;
	}
	else return s2;
}//比较两个字符串的长度，返回较大的
mystr mystr::insert( mystr&s1, const mystr&s2, int pos) {
	mystr a,b,c;
	a.m_length = s1.m_length + s2.m_length;
	a.m_buff = new char[a.m_length];
	b.m_length = pos - 1;
	b.m_buff = new char[b.m_length];
	strncpy(b.m_buff, s1.m_buff, pos - 1);
	c = s1;
	c.m_length = s1.m_length - (pos - 1);
	c.m_buff = c.m_buff + pos - 1;
	a = b + s2 + c;
	return a;
}//插入字符

int main() {
	mystr a=  "lx";
	mystr b = "lc";
	mystr c = a + b;
	cout << c;
	swap(a, b);
	cout << a << b << endl;
	return 0;
}
