#include  <iostream>
#include  <string>
using namespace std;
class String
{
public:
	String(const char* str = NULL);//构造函数
	String(const String& data);
	~String();
	String& operator =(const String& data);
	bool operator ==(const String& data);//判断相等
	int getLength(); //返回长度
private:
	char* Data;
};

String::String(const char* str)
{
	if (str == NULL) {
		Data = new char[1];
		*Data = '\0';
	}
	else {
		int length = strlen(str);
		Data = new char[length + 1];
	}
}
String::~String()
{
	if (Data)
	{
		delete[] Data;
		Data = 0;
	}
}
String::String(const String& data)
{
	if (!data.Data)
	{
		Data = 0;
	}
	Data = new char[strlen(data.Data) + 1];
}
String& String::operator=(const String& data)
{
	if (this != &data)
	{
		delete[] Data;
		if (!data.Data)
		{
			Data = 0;
		}
		else {
			Data = new char[strlen(data.Data) + 1];
		}
	}
	return *this;
}
int String::getLength()
{
	return strlen(Data);

}
int main()
{
	String str1 = "Hello";
	int n = str1.getLength();
	cout << n << endl;
	String str2 = "World!";
	cout << str2.getLength() << endl;
	String str3(str1);
	cout << str3.getLength() << endl;
	return 0;
}