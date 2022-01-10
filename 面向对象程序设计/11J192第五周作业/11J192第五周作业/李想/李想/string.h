#pragma once
#include<iostream>
using namespace std;
class mystr {
	int m_length;//字符数组的长度
	char* m_buff;//指向动态字符数组
private:
	static int strlen(const char* ptr);//获取c风格字符串长度
	static void strncpy(char* dest, const char* src, int n);//复制src指向的数组中前n个字符到dest指向的数组中
public:
	mystr(const char* val = nullptr);//默认构造函数
	~mystr() { delete[]m_buff; }//析构函数
	int size() { return m_length; };
	friend ostream& operator<< (ostream&, const mystr&);//运算符<<重载
	friend mystr operator + (const mystr&, const mystr&);//运算符+重载
	mystr(const mystr& rhs);//复制构造函数
	mystr& operator=(const mystr& rhs);//等号的重载
	mystr(mystr&& rhs);//移动构造函数
	mystr& operator=(mystr&& rhs);//移动赋值运算符
	void swap(mystr&, mystr&);//交换两个字符串的内容
	mystr max(const mystr&, const mystr&);//比较两个字符串的长度，返回较大的
	mystr insert(mystr&, const mystr&, int pos);//插入字符
};