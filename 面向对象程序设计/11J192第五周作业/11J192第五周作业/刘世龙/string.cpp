#include "string.h"
//默认构造函数
MyStr::MyStr(const char* val) :m_length(strlen(val)), m_buff(m_length > 0 ? new char[m_length] : nullptr)
{
	strncpy(m_buff, val, m_length);
}

//复制构造函数
MyStr::MyStr(const MyStr& rhs) :m_length(rhs.m_length), m_buff(m_length > 0 ? new char[m_length] : nullptr)
{
	strncpy(m_buff, rhs.m_buff, m_length);  //复制数据
}
//移动构造函数
MyStr::MyStr(MyStr&& rhs) : m_length(rhs.m_length), m_buff(rhs.m_buff)
{
	rhs.m_buff = nullptr;    //将临时对象指针成员置为空指针
	rhs.m_length = 0;
}

//strlen与strncpy功能
int MyStr::strlen(const char* ptr)
{
	int len = 0;
	while (ptr && *ptr++ != '\0')
		++len;
	return len;
}
void MyStr::strncpy(char* dest, const char* src, int n)
{
	for (int i = 0; i < n; ++i)
		dest[i] = src[i];
}

//MyStr类辅助函数定义
ostream& operator<<(ostream& os, const MyStr& s)
{
	for (int i = 0; i < s.m_length; ++i)
		os << s.m_buff[i];
	return os;
}

//字符连接
MyStr operator+(const MyStr& s1, const MyStr& s2)
{
	MyStr res;
	res.m_length = s1.m_length + s2.m_length;
	res.m_buff = new char[res.m_length];
	MyStr::strncpy(res.m_buff, s1.m_buff, s1.m_length
		);
	MyStr::strncpy(res.m_buff + s1.m_length, s2.
		m_buff, s2.m_length);
	return res; //返回局部对象 res
}


//赋值
MyStr& MyStr::operator=(const MyStr& rhs)
{
	if (this != &rhs)   //避免自身赋值
	{
		delete[]m_buff;   //释放原来内存
		m_length = rhs.m_length;
		m_buff = new char[m_length];  //从新分配内存
		strncpy(m_buff, rhs.m_buff, m_length);  //复制数据
	}
	return *this;
}

//插入字符
void MyStr::insert( char*text, int index, char s)
{
	int len = strlen(text);
	for (int i = len; i > index; i--)
		text[i] = text[i - 1];
	text[index] = s;
}

//删除字符
void MyStr::erase(char *text, int del)
{
	int len = strlen(text);    //原字符串长度
	int count = 0;
	char* copy = (char*)malloc(len + 1);
	for (int i = 0; i < len; i++)
	{
		char t = text[i];
		if (t != del)
		{
			copy[count] = t;
			count++;
		}

	}
	copy[count] = 0;   //添加结束符
	//strcpy(text, copy);   //拷回原字符串
	//free(copy);   //释放内存
}

//清空字符串
void MyStr::clear(char *text)
{
	int len = strlen(text);
	for (int i = 0; i < len; i++)
		text[i] = '/0';
}

//替换字符
void MyStr::replace(char *text, char rep, char s)
{
	int len = strlen(text);
	for (int i = 0; i < len; i++)
		if (text[i] == rep)
			text[i] = s;
}




