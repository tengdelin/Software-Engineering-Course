#pragma once
#include<iostream>
using namespace std;
class MyStr 
{
	int m_length; // 字符数组的长度
	char* m_buff; // 指向动态字符数组
private:
	// 私有静态成员函数
	static int strlen(const char* ptr);//获取c风格字符串长度
	//将src指向的数组中前n个字符复制到dest指向的数组中
	static void strncpy(char* dest, const char* src, int n);

public:
	MyStr(const char* val = nullptr); // 默认构造函数
	MyStr(const MyStr& rhs);
	MyStr(MyStr&& rhs);
	~MyStr() { delete[] m_buff; }
	int size() { return m_length; }
	void insert(char text[],int index,char s);   //插入字符
	void erase(char text[], int del);   //删除字符
	void clear(char text[]);   //清除字符
	void replace(char text[],char rep,char s);  //替代字符
	// 辅助函数声明
	friend ostream& operator<<(ostream&, const MyStr&); //打印字符串
	friend MyStr operator+(const MyStr&, const MyStr&);  //字符串相加
	MyStr& operator=(const MyStr&);
};