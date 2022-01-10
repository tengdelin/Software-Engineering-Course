#pragma once
#include<iostream>
using namespace std;
class MyString
{
public:
	size_t strLength; // 字符数组的长度
	char* p_str; // 指向动态字符数组
private:
	// 私有静态成员函数
	static int strlen(const char* ptr);
	static void strncpy(char* dest, const char* src, int n);
public:
	MyString(const char* val = nullptr); // 默认构造函数
	MyString(const MyString& rhs);//复制构造函数
	~MyString() { delete p_str; }     //析构函数
	int size() { return strLength; }



	// 辅助函数声明
	MyString& append(const MyString&);
	MyString& erase(size_t, size_t);
	MyString& insert(size_t, const MyString&);
	void swap(MyString& lhs, MyString& rhs);
	MyString& assign(MyString&, size_t, size_t);
	MyString& replace_all(const char oldc, const char newc = NULL);




	//运算符重载
	MyString& operator=(const MyString& str);
	friend ostream& operator<<(ostream&, const MyString&);
	friend istream& operator>> (istream&, MyString&);
	friend MyString operator+(const MyString&, const MyString&);
};
void test01();