#include <iostream>
#include <string>
using namespace std;
class mstring {
public:
	mstring();//无参构造函数
	//mystring(const char* s);//构造函数
	mstring(const mstring& str);//复制构造函数
	mstring(mstring &&rhs);//移动构造函数
    ~mstring();//析构函数

	static int strlen(const char* ptr);//得到字符串长度
	static void strcpy_s( char* dest,const char* src);//赋值函数
   // void insert(const char* s, int n);//插入字符
	void swap(char* a, char* b);//交换两个字符串的内容
	void appened();//添加字符
	friend ostream& operator<<(ostream& out, const mstring& s);//<<运算符重载
	mstring& operator=(const mstring& str);//=运算符重载
	mstring& operator=(const char* s);//=运算符重载

 
	char* p = {};//指向字符串的内存空间
	int size=0;//申请的长度
	int len=0;//字符串长度
};

//无参构造函数
mstring::mstring() {

}

//构造函数
/*mystring::mystring(const char *s) {
	if (s == NULL)
	{
		p = nullptr;
	}
	else {
		p = new char[strlen(s)+1];
		strcpy(p, s);
	}
}*/

//复制构造函数
mstring::mstring(const mstring& str) {
	p = new char[strlen(str.p) + 1];//先创建内存空间
	strcpy_s(p, str.p);//赋值
	len = str.len;
	size = str.size;
}

//移动构造函数
mstring::mstring(mstring&& rhs) :len(strlen(rhs.p)), p(rhs.p) {
	rhs.p = nullptr;
	rhs.len = 0;
}

//析构函数
mstring::~mstring() {
	delete[]p;
	cout << "析构" << endl;
}

//得到字符串长度
int mstring::strlen(const char* ptr) {
	int len = 0;
	while (ptr && *ptr++ != '\0')
		len++;
	return len;
}

//赋值函数
void mstring::strcpy_s(char* dest, const char* src) {
	for (int i = 0; i < strlen(src); i++)
		dest[i] = src[i];
}

//插入字符 ×
/*void mstring::insert(const char* s, int n)//s是插入的字符，n是从第几个字符后插入
{
	size = strlen(p) + strlen(s);//总长度
	this->p = new char[size];//
	for (int i = n - 1, j = 0; i < size; i++, j++) {
		p[i + strlen(s)] = p[i];//把第n个字符后的字符后移
		p[i] = s[j];
	}
}*/

//交换两个字符串的内容
void mstring::swap(char* a, char* b) {
	char* t = {};//中间量t
	strcpy_s(t, a);
	strcpy_s(a, b);
	strcpy_s(b, t);
}

//添加字符
void mstring::appened() {
	char* s = {};
	cout << "请输入添加的字符\n";
	cin >> s;
	size = strlen(p) + strlen(s);
	this->p = new char[size];
	for (int i = strlen(p), j = 0; i < size; i++, j++) {
		p[i] = s[j];
	}
	delete[]s;
}

//  <<运算符重载函数
ostream& operator<<(ostream& out, const mstring& s) {
	out << s.p;//把s.p中内容流出
	return out;
}

//  =运算符重载
mstring& mstring::operator=(const mstring& str) {
	if (this != &str) {
		delete[]p;
		p = new char[strlen(str.p) + 1];
		strcpy_s(p, str.p);
	}
	return *this;
}

mstring& mstring::operator=(const char* s)
{	//1 旧内存释放掉	
	if (p != NULL) {
		delete[] p;
		len = 0;
	}
	//2 根据p分配内存
	if (s == NULL) {
		len = 0;
		p = new char[len + 1];
		strcpy_s(p, "");
	}
	else {
		len = strlen(s);
		p = new char[len + 1];
		strcpy_s(p, s);
	}
	return *this;
}

//test
int main() {
	mstring s1;
	mstring s2;
	s1 = "TEAMWANG";
	cout << s1 << endl;
	int i;
	i = s1.strlen(s1.p);
	cout << i << endl;
	s2 = "jacksonwertyuiop";
	swap(s2, s1);
	cout << s2 << endl;
	cout << s1 << endl;
	return 0;
}