#pragma once
#include<iostream>
using namespace std;

class MyStr {
	int m_length; // 字符数组的长度
	char* m_buff; // 指向动态字符数组
private:
	static int strlen(const char* ptr);//读取字符长度
	static void strncpy(char* dest, const char* src, int n);//表示把src所指向的字符串中以src地址开始的前n个字节复制到dest所指的数组中
public:
	MyStr(const char* val = nullptr);
	MyStr(const MyStr& s);
	~MyStr() { 
		delete[] m_buff; 
	}//析构
	int size() { 
		return m_length; 
	};
	
	// 辅助函数声明
	friend ostream& operator<<(ostream&, const MyStr&);//字符输出
	
	friend MyStr operator+(const MyStr&, const MyStr&);//字符连接
	
	MyStr& operator=(const MyStr& s1);
	
	void swap(MyStr&, MyStr&);//交换字符内容
	
	void operator+=(const MyStr&);//添加字符
	
	void insert(char s, int n);//插入字符到第n个字符中
	
	void erase(int n);//删除第n个字符
	
	void clear();//清除字符
	
	

	void resize(int length);//改变字符数量
	
	void replace(char x, int n);//替换第n个字符
};

