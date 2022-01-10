//实现一个字符串类，功能与string相同。
#include<iostream>
using namespace std;
#include<string>
class CMystr {
private:
	//私有成员变量
	int m_length;//字符串数组的长度
	char* m_buff;//指向动态数组
	//私有静态成员函数
	static int strlen(const char* ptr);//获取字符串长度
	static void strncpy(char* dest, const char* src, int n);
	
public:
	//默认构造函数
	CMystr(const char* val = nullptr);
	//运算符重载
	CMystr& operator=(const CMystr& rhs);
	//复制构造函数
	CMystr(const CMystr&);
	//析构函数
	~CMystr() { delete[] m_buff;
	
	}//析构函数将动态数组释放
	//字符串长度函数
	int size() { return m_length; }
	//展示字符串
	void show() {
		for (int i = 0; i < m_length; i++)
			cout << m_buff[i];
		return ;
	}
	//添加字符函数
	CMystr& append(const CMystr&);
	//插入函数
	CMystr& insert(int l, const CMystr&);
	//
	CMystr& assign( CMystr&,int l1,int l2);
	// erase 删除  
	CMystr& erase(int l1, int l2);
	//辅助函数声明d
	friend void Swap(CMystr& c1, CMystr& c2);//相互交换字符串
	friend ostream& operator<<(ostream&, const CMystr&);//打印字符串
	friend CMystr operator+(const CMystr&, const CMystr&);//重载字符串相加的运算
};

