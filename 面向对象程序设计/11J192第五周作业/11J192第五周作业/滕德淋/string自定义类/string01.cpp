


#include<iostream>
using namespace std;
#include"string01.h"
//#include<iostream>
//using namespace std;

//构造函数
MyString::MyString(const char* val) :strLength(strlen(val)), p_str(strLength > 0 ? new char[strLength] : nullptr)
{
	strncpy(p_str, val, strLength);
}


//复制构造函数
MyString::MyString(const MyString& rhs) :strLength(rhs.strLength), p_str(strLength > 0 ? new char[strLength] : nullptr)
{
	strncpy(p_str, rhs.p_str, strLength);//复制数据
}



//取长度
int MyString::strlen(const char* ptr)
{
	int len = 0;
	while (ptr && *ptr++ != '\0')
		++len;
	return len;
}


//复制数据
void MyString::strncpy(char* dest, const char* src, int n)
{
	for (int i = 0; i < n; ++i)
		dest[i] = src[i];
}


//左移运算符重载
ostream& operator<<(ostream& os, const MyString& s)
{
	for (int i = 0; i < s.strLength; ++i)
		os << s.p_str[i];
	return os;
}


//右移运算符重载
istream& operator>> (istream& in, MyString& str)
{
	char tmp[100];// 临时字符串
	if (in >> tmp)
	{
		delete[] str.p_str;
		str.strLength = strlen(tmp);
		str.p_str = new char[str.strLength + 1];
		strcpy(str.p_str, tmp);
	}
	return in;
}


// + 运算符重载
MyString operator+(const MyString& s1, const MyString& s2)
{
	MyString res;
	res.strLength = s1.strLength + s2.strLength;
	res.p_str = new char[res.strLength];
	MyString::strncpy(res.p_str, s1.p_str, s1.strLength);
	MyString::strncpy(res.p_str + s1.strLength, s2.p_str, s2.strLength);
	return res; //返回局部对象 res
}


//赋值运算符重载
MyString& MyString::operator=(const MyString& rhs)
{
	if (this != &rhs) { //此判断不能缺少
		delete[] p_str; //释放原来的内存
		strLength = rhs.strLength;
		p_str = new char[strLength];//重新分配内存
		strncpy(p_str, rhs.p_str, strLength);
		//复制数据
	}
	return *this;
}


//加
MyString& MyString::append(const MyString& other)
{
	*this = *this + other;
	return *this;
}


//删除
MyString& MyString::erase(size_t pos, size_t n)
{
	char* p_old = p_str;
	strLength -= n;
	p_str = new char[strLength + 1];
	for (size_t i = 0; i < pos; i++)
	{
		p_str[i] = p_old[i];
	}
	for (size_t i = pos; i < strLength; i++)
	{
		p_str[i] = p_old[i + n];
	}
	*(p_str + strLength) = '\0';
	return *this;
}


//插入
MyString& MyString::insert(size_t pos, const MyString& other)
{

	char* p_old = p_str;
	strLength += other.strLength;
	p_str = new char[strLength + 1];
	for (size_t i = 0; i < pos; i++)
	{
		*(p_str + i) = *(p_old + i);
	}
	for (size_t i = pos; i < other.strLength + pos; i++)
	{
		*(p_str + i) = other.p_str[i - pos];
	}
	for (size_t i = other.strLength + pos; i < strLength; i++)
	{
		*(p_str + i) = p_old[i - other.strLength];
	}
	*(p_str + strLength) = '\0';
	return *this;
}


//交换
void MyString::swap(MyString& lhs, MyString& rhs)
{
	lhs.strLength ^= rhs.strLength;
	rhs.strLength ^= lhs.strLength;
	lhs.strLength ^= rhs.strLength;
	char* p_tmp = rhs.p_str;
	rhs.p_str = lhs.p_str;
	lhs.p_str = p_tmp;
}

//重新赋值
MyString& MyString::assign(MyString& other, size_t pos, size_t n)
{
	if (strLength < pos + n)
	{
		char* p_old = p_str;
		strLength = pos + n;
		p_str = new char[strLength + 1];
		for (size_t i = 0; i < pos; i++)
		{
			*(p_str + i) = *(p_old + i);
		}
		delete[] p_old;
	}
	for (size_t i = pos; i < pos + n; i++)
	{
		*(p_str + i) = other.p_str[i];
	}
	*(p_str + pos + n) = '\0';
	return *this;
}

//取代
MyString& MyString::replace_all(const char oldc, const char newc)
{
	if (NULL == oldc)
	{
		return *(this);
	}
	for (size_t i = 0; i < strLength; i++)
	{
		if (p_str[i] == oldc)
		{
			p_str[i] = newc;
		}
	}
	return *(this);
}
//测试函数
void test01()
{
	//+，<<,>>运算符重载测试
	cout << "1、+，<<,>>运算符重载测试:" << endl;
	MyString mystr1 = "我喜欢学习";
	MyString mystr2 = "C++和高等数学";
	MyString mystr3;
	cout << "mystr1:  " << mystr1 << endl;
	cout << "mystr2:  " << mystr2 << endl;
	mystr3 = mystr1 + mystr2;
	cout << "mystr3:  " << mystr3 << endl;
	cout << "请输入mystr3： ";
	cin >> mystr3;
	cout << "mystr3:  " << mystr3 << endl;
	cout<< endl << endl << endl;

	//swap测试
	cout << "2、swap测试: " << endl;
	swap(mystr1, mystr2);
	cout << "mystr1:  " << mystr1 << endl;
	cout << "mystr2:  " << mystr2 << endl;
	cout << endl << endl << endl;


	//append测试
	cout << "3、appoud测试: " << endl;
	mystr1.append(mystr2);
	cout << "mystr1:  " << mystr1 << endl;
	cout << "mystr2:  " << mystr2 << endl;
	cout << endl << endl << endl;

	//删除测试
	cout << "4、删除测试: " << endl;
	mystr1.erase(0, 3);//从第0位开始，删3位
	cout << "mystr1:  " << mystr1 << endl;
	cout << "mystr2:  " << mystr2 << endl;
	cout << endl << endl << endl;

	//插入测试
	cout << "5、插入测试:" << endl;
	mystr1.insert(2, mystr3);
	cout << "mystr1:  " << mystr1 << endl;
	cout << "mystr2:  " << mystr2 << endl;
	cout << "mystr3:  " << mystr3 << endl;
	cout << endl << endl << endl;

	//取代测试
	cout << "6、取代测试:" << endl;
	MyString mystr4 = "aaaaa";
	cout << "mystr4:  " << mystr4 << endl;
	mystr4.replace_all('a', 'J');
	cout << "mystr4:  " << mystr4 << endl;
	cout << endl << endl << endl;


	//赋予新的值
	cout << "7、赋予新的值测试:" << endl;
	MyString mystr5 = "hello world,你好，C++";
	mystr1.assign(mystr5, 0,3);
	cout << "mystr5:  " << mystr5 << endl;
	cout << "mystr1:  " << mystr1 << endl;

}



