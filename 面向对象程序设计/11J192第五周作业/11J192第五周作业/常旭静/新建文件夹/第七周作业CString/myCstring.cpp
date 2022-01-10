#include "myCstring.h"
#include<iostream>
#include"stdio.h"
using namespace std;
CString::CString() {//构造函数
	cout << "请输入字符串的长度：";
	cin >> m_len;
	m_buff = new char[m_len];
	cout << "请输入数组中的字符：" << endl;
	for (int i = 0;i < m_len;i++) {
		cin >> m_buff[i];
	}

}


CString::CString(CString&& str) :m_len(str.m_len), m_buff(str.m_buff)
{
}

CString::~CString()//析构函数
{
		delete[]m_buff;
}

CString::CString(CString& str)
{
	int len = getlen(str);//取得字符串长度
	m_buff = new char[len];//开辟内存空间
	for (int i = 0;i < len;i++)
		m_buff[i] = str.m_buff[i];//赋值
}

int CString::getlen(CString& str)
{
	return str.m_len;
}

void CString::Swap(CString& str)//交换两个字符串
{
	int len = getlen(str);
	if (len != m_len) {
		cout << "数据大小不一致，不可交换";//数据大小不一致会导致数据溢出，故不允许交换
	}
	else {
		for (int i = 0;i < len;i++) {//逐个字符交换
			char t = 0;
			t = str.m_buff[i];
			str.m_buff[i] = m_buff[i];
			m_buff[i] = t;
		}
	}
}

void CString::erase()//删除单个字符
{
	char a;//记录所要删除的字符
	cout << "请输入您想要删除的字符：" << endl;
	cin >> a;
	for(int i=0;i<m_len;i++){//寻找目标字符，将其赋值为0；
		if (m_buff[i] != a) {
			continue;
		}
		else {
			m_buff[i] = 0;
		}
	}
	int c = 0;//用于记录0的个数
	for (int i = 0;i < m_len;i++) {
		if (m_buff[i] == 0) {
			int a = i;//记录i的初值
			int j = m_len - i;//记录交换次数
			c++;//记录0的个数
			for (int b = 0;b < j;b++) {
				m_buff[i] = m_buff[i + 1];//将后一位的值赋给前一位
				i++;
			}
			i = a;//重新从i处进行循环
		}
		else continue;
		m_len = m_len - c;//将0所占据的位置消除，只输出剩余的有效字符
	}

}

void CString::replace()//替换目标字符
{
	char a;
	char b;
	cout << "请输入您想要替换的字符" << endl;
	cin >> a;
	cout << "请输入您用于替换的字符：" << endl;
	cin >> b;
	for (int i = 0;i < m_len;i++) {//遍历数组元素
		if (m_buff[i] == a) {
			m_buff[i] = b;
		}
		else continue;
	}
}

void CString::insert()//插入字符
{
	int num;
	cout << "请输入要插入的字符在新数组中的位置：" << endl;
	cin >> num;
	cout << "请输入所要插入的字符：";
	char a;
	cin >> a;
	char* tem = new char(m_len);
	strcpy(tem, m_buff,m_len);
	delete[]m_buff;
	m_len++;
	m_buff = new char(m_len);
	for (int i = 0;i < m_len;i++) {
		if (i ==num - 1) {
			m_buff[num - 1] = a;

		}
		else if (i < num - 1)
			m_buff[i] = tem[i];
		else if (i > num - 1)
			m_buff [i]= tem[i - 1];
	}
	
}

void CString::assign()//赋新值
{
	int newlen;
	cout << "请输入您所想要设置的字符串长度：";
	cin >> newlen;
		delete[]m_buff;
	m_len = newlen;
	m_buff = new char[m_len];
	cout << "请输入重置后的数组：";
	for (int i = 0;i < m_len;i++) {
		cin >> m_buff[i];
	}
	cout << "重置后的数组为：" << endl;
	print();
}

void CString::clear()
{
	m_buff = nullptr;
}

void CString::resize()//改变长度
{
	cout << "当前数组长度为：" << m_len;
	cout << "请输入改变后的数组长度：";
	int a;
	cin >> a;
	char* tem=nullptr;
	if (a > m_len) {
		 tem = new char[m_len];//tem临时对象用于储存m_buff的值
		 int b = m_len;
	strcpy(tem, m_buff,m_len);
		delete[]m_buff;//清空m_buff
		m_len = a;
		m_buff = new char[m_len];//新建m_buff
		strcpy(m_buff, tem,b);
		for (int i = b;i < m_len;i++) {
			m_buff[i] = '0';//把多余的位置赋值成‘0’
		}
	}
	if (a < m_len) {
		char* tem = new char[m_len];
		strcpy(tem, m_buff,m_len);
		delete[]m_buff;
		m_buff = new char[m_len];
		for (int i = 0;i < a;i++) {
			m_buff[i] = tem[i];//直接砍掉最后一个数
		}
	}
	delete[]tem;//删除tem临时对象
}

void CString::print()
{
	for (int i = 0;i < m_len;i++) {
		if (i == m_len - 1) {
			cout << m_buff[i] << endl;
		}
		else {
			cout << m_buff[i] << "  ";
		}
		
	}
}

void CString::strcpy(char* a, char* b,int j)
{
	
	

	for (int i = 0;i < j;i++) {
		a[i] = b[i];
	}//进行数组间的复制操作
}

ostream& operator<<(ostream& os, const CString& str)
{
	for (int i = 0; i < str.m_len; ++i)
		os << str.m_buff[i];
	return os;
	// TODO: 在此处插入 return 语句
}
