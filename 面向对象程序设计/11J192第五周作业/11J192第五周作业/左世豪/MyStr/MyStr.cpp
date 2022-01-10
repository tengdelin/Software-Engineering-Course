#include "MyStr.h"
#include<iostream>
using namespace std;

MyStr:: MyStr(const char* val ) {
	m_length = strlen(val);
	m_buff = new char[m_length];
	for (int i = 0; i < m_length;i++)
		m_buff[i] = val[i];
}

MyStr::MyStr(const MyStr& s) {
	m_length = s.m_length;
	m_buff = new char[m_length];
	for (int i = 0; i < m_length; i++)
		m_buff[i] = s.m_buff[i];
}

int MyStr::strlen(const char* ptr)
{
	int len = 0;//函数先构造一个存放长度的变量
	while (ptr&&* ptr++ != '\0')
		++len;
	return len;

}

void MyStr::strncpy(char* dest, const char* src, int n)
{
	for (int i = 0; i < n; i++)
		dest[i] = src[i];
}

ostream& operator<<(ostream&os, const MyStr&s)
{
	for (int i = 0; i < s.m_length; ++i)
		os << s.m_buff[i];
	return os;
}

MyStr operator+(const MyStr&s1, const MyStr&s2)
{
	MyStr res;
	res.m_length = s1.m_length + s2.m_length;
	res.m_buff = new char[res.m_length];
	MyStr::strncpy(res.m_buff, s1.m_buff, s1.m_length);
	MyStr::strncpy(res.m_buff + s1.m_length, s2.m_buff, s2.m_length);
	return res; //返回局部对象 res
}

MyStr& MyStr::operator=(const MyStr& rhs)
{
	if (this != &rhs) { 
		delete[] m_buff; //释放原来的内存
		m_length = rhs.m_length;
		m_buff = new char[m_length];//重新分配内存
		strncpy(m_buff, rhs.m_buff, m_length);
		//复制数据
	}
	return *this;

}

void MyStr::resize(int length)
{
	int temp = m_length;
	m_length = length;
	for (int i = temp-1; i < m_length; i++)
		m_buff[i] = 0;
}


void MyStr::swap(MyStr&s1, MyStr&s2)
{
	MyStr temp = s1;
	s1 = s2;
	s2 = temp;
}

void MyStr::operator+=(const MyStr&s)
{
	MyStr temp = m_buff;
	m_length =m_length + s.m_length;
	m_buff = new char[m_length];
	MyStr::strncpy(m_buff, s.m_buff, temp.m_length);
}

void MyStr::insert(char s, int n)
{
	MyStr temp=*this;
	temp.m_length = m_length + 1;
	temp.m_buff = new char[m_length + 1];
	for (int i = 0; i < n; i++) {
		temp.m_buff[i] = m_buff[i];
	}
	temp.m_buff[n] = s;
	for (int i = n + 1; i < m_length + 1; i++)
		temp.m_buff[i] = m_buff[i - 1];
	m_length = m_length + 1;
	m_buff = new char[m_length + 1];
	*this = temp;
}

void MyStr::erase(int n)
{
	m_buff[n - 1] = 0;
	MyStr temp;
	temp.m_length = m_length - 1;
	temp.m_buff = new char[temp.m_length];
	for (int i = 0; i < m_length; i++) {
		for (int j = 0; j< temp.m_length&&m_buff[i] != 0;j++) {
			temp.m_buff[j]= m_buff[i];
		}
	}
	delete[] m_buff;
	m_length = m_length - 1;
	m_buff = temp.m_buff;
}

void MyStr::clear()
{
	delete[] m_buff;
	m_buff = nullptr;
	m_length = 0;
}

void MyStr::replace(char x,int n)
{
	m_buff[n - 1] = x;
}