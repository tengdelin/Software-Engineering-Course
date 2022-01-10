#pragma once
using namespace std;
 ostream& operator<<(ostream& os, CString& str);

class  CString {
	//friend ostream& operator<<(ostream& os, CString& str);
public:
	CString();//默认构造函数

	CString(CString&& str);//移动构造函数
	~CString();//析构函数
	CString(CString& str);//复制构造函数
	int getlen(CString& str );//取得字符串长度
	void Swap(CString& str);//交换两个字符串内容
	void erase();//除去目标字符
	void replace();//替换字符
	void insert();//插入字符
	void resize();//改变字符数量
	void assign();//赋新值
	void clear();//移除字符
	void print();
	void strcpy(char *a, char* b,int j);
	
private:
	int m_len;//字符串长度
	char* m_buff;//动态数组
};