#include<iostream>
using namespace std;
class mystr {
public:
	mystr();//默认构造函数
	mystr(const char* ptr1);//构造函数
	mystr(const mystr& ptr2);//拷贝构造函数
	mystr( mystr&& ptr4);//移动构造函数
	friend ostream& operator<<(ostream& os, const mystr& ptr2);//输出重载
	mystr &operator=(const mystr& ptr3);//拷贝复制
	mystr& operator=(mystr&& ptr5);//移动拷贝复制
	void mystrpushback(const char* str4);//尾部插入
	void myswap(mystr&ptr6);//交换
	void myinsert(int n,const char* ptr8);//插入
	void myerase(int n, int k);//删除
	void myclear();//移除全部字符串
	void myresize(int k);//重置大小
	
	~mystr();//析构函数

private:
	char* mstr;//指针
	int mlenth;//字符串长度
	static int mystrlen(const char*str1);//获得字符串长度
	static void mystrcpy(char* str2, const char* str3, int n);//两个字符串之间的拷贝
	 
};
mystr::mystr() :mlenth(0), mstr(nullptr) {};
int mystr::mystrlen(const char* str1) {
	int len = 0;
	if (str1) {//如果非空指针就开始计算
		while (str1 && *str1++ != '\0') {//
			len++;
		}
		return len;
	}
	else
		return len;//否贼长度为0

}
void mystr::mystrcpy(char* str2, const char* str3, int n) {//拷贝，按for循环来拷贝
	for (int i = 0; i < n; i++) {
		str2[i] = str3[i];}
}
mystr::mystr(const char* ptr1)://构造函数
	mlenth(0),mstr(nullptr)
{
	mlenth = mystrlen(ptr1);//取得传入的字符串长度
	if (mlenth) {//创建一个动态数组然后赋值
		mstr = new char[mlenth];
		mystrcpy(mstr, ptr1, mlenth);
	}
	else
		mstr = nullptr;//如果传的是一个空指针，那么就仍然是空指针

}
//不知道为什么移动构造函数有警告
mystr::mystr(const mystr& ptr2)://拷贝构造函数
	mlenth(ptr2.mlenth)
{
	if (mlenth) {//取原字符串的长度，然后初始化
		mstr = new char[mlenth];
		mystrcpy(mstr, ptr2.mstr, mlenth);
	}
	else
		mstr = nullptr;//如果是一个空字符串，那么指向空指针

}
mystr::mystr( mystr&& ptr4):
   mlenth(ptr4.mlenth),mstr(ptr4.mstr)//移动构造函数，移交相应的地址
{
	ptr4.mlenth = 0;
	ptr4.mstr = nullptr;
}
mystr::~mystr() {//防止字符串移除时再度释放内存
	if (mlenth != 0)
	{  delete[]mstr;
		mlenth = 0;
	}
}

ostream& operator<<(ostream& os, const mystr& ptr2) {//运算符重载
	for (int i = 0; i < ptr2.mlenth; i++) {
		os << ptr2.mstr[i];//逐个丢给os
	}
	return os;
}
mystr& mystr::operator=(const mystr& ptr3) {//拷贝复制函数
	if (this == &ptr3) {//防止自我赋值
		return *this;
	}
	delete[]mstr;
	mlenth = ptr3.mlenth;
	mstr = new char[mlenth];
	mystrcpy(mstr, ptr3.mstr, mlenth);
}
mystr& mystr::operator=(mystr&& ptr5) {//移动拷贝构造函数
	if (this == &ptr5) {
		return *this;
	}
	delete[]mstr;
	mlenth = ptr5.mlenth;
	mstr = ptr5.mstr;
	ptr5.mlenth = 0;
	ptr5.mstr = nullptr;
}
void mystr::mystrpushback(const char* str4) {//尾插
	int strlen = mystrlen(str4);//取得传进来的字符长度
	int pastmlenth = mlenth;//取得原字符串的长度
	mlenth = strlen + pastmlenth;//字符串插入后的长度
	char* newmstr = nullptr;
	newmstr = new char[mlenth];//创建动态数组
	int j = 0;//后续循环时要用到的一个变量
	mystrcpy(newmstr, mstr, pastmlenth);
	for (int i = pastmlenth; i < mlenth; i++) {//从原字符串尾部开始进行插入
		
		newmstr[i] = str4[j];
		j=j+1;
	}
	delete[]mstr;//删除原字符串的动态数组，然后再创建一个动态数组赋值
	mstr = new char[mlenth];
	mystrcpy(mstr, newmstr, mlenth);
	delete[]newmstr;}
void mystr::myswap(mystr& ptr6) {
	char* mid = nullptr;//创建一个动态数组C
	int midlen = mlenth;
	mid = new char[mlenth];
	mystrcpy(mid, mstr, mlenth);//把原字符串赋给C
	delete[]mstr;
	mlenth = ptr6.mlenth;
	mstr = new char[mlenth];
	mystrcpy(mstr, ptr6.mstr, mlenth);//把传进来的字符串赋给现在的字符串
	delete[]ptr6.mstr;//把C字符串赋给传进来的字符串
	ptr6.mlenth = midlen;
	ptr6.mstr = new char[midlen];
	mystrcpy(ptr6.mstr, mid, midlen);
	delete[]mid;
	mid = nullptr;

}
void mystr::myinsert(int n, const char* ptr8)//n代表插在第几个之后 
{
	int ptrlen = mystrlen(ptr8);//取得插入字符串长度
	int midlen = n + ptrlen;//中间体字符串长度
	int j = 0;//用于循环
	int k = n;//第几个字符后开始插入
	int newlen = mlenth + ptrlen;//新的字符串长度
	char* midstr = nullptr;
	midstr = new char[newlen];
	for (int i = 0; i < n; i++) {//插入字符前的字符串
		midstr[i] = mstr[i];
	}
	for (int i = n; i < midlen; i++) {//插入的字符串
		midstr[i] = ptr8[j];
		j++;
	}
	for (int i = midlen; i < newlen; i++) {//插入完后原字符串的尾部字符
		midstr[i] = mstr[k];
		k++;
	}
	delete[]mstr;
	mlenth = newlen;
	mstr = new char[mlenth];
	mystrcpy(mstr, midstr, mlenth);//重新赋值
	delete[]midstr;
};
void mystr::myerase(int n, int k)//这里n代表删去从第几个字符起，k代表长度
{
	if (n > mlenth || n < 0)
	{
		cout << "输入错误" << endl;
		return;
	}
	int start = n-1;
	int midlen = mlenth - start ;
	if (k > midlen || k < 0) {
		cout << "删去字节长度有误" << endl;
		return;
	}
	int newlen = mlenth - k;//删去后字符串长度
	char* newstr = nullptr;
	newstr = new char[newlen];
	for (int i = 0; i < start; i++) {//删除位置之前的字符串
		newstr[i] = mstr[i];
	}
	int endstart = n + k - 1;
	for (int i = endstart; i < mlenth; i++) {//删除完以后剩余的字符串
		newstr[start] = mstr[i];//不知道为什么这里有警告，希望老师指点问题出在哪里
		start++;
	}
	mlenth = mystrlen(newstr);//重新赋值
	delete[]mstr;
	mstr = new char[mlenth];
	mystrcpy(mstr, newstr, mlenth);



	

}
void mystr::myclear() {//移除字符串
	delete[]mstr;
	mlenth = 0;
	mstr = nullptr;
}
void mystr::myresize(int k) {//重置大小
	if (k >0) {
		char* newstr = nullptr;
		newstr = new char[k];
		mystrcpy(newstr, mstr, mlenth);
		delete[]mstr;
		mstr = nullptr;
		mlenth = k;
		mstr = new char[mlenth];
		mystrcpy(mstr, newstr, mlenth);


	}
	if (k == 0) {
		mlenth = 0;
		delete[]mstr;
		mstr = nullptr;
	}
	if (k < 0) {
		cout << "输出有误" << endl;
		return;
	}
	
}
int main() {
	mystr a1("hello,C++");
	mystr a2(a1);
	cout << "测试复制构造函数" << endl;
	cout << a2 << endl;
	mystr a3("i love C++");
	cout << a3 << endl;
	cout << "测试连续插入单个相同字符串" << endl;
	a1.mystrpushback("iiiii");
	cout << a1 << endl;
	cout << "测试尾部插入不同的字符串" << endl;
	a3.mystrpushback("I love Miss.liang");
	cout << a3 << endl;
	a3.myswap(a1);
	cout << "交换后a1" << endl;
	cout << a1 << endl;
	cout << "交换后a3" << endl;
	cout << a3 << endl;
	mystr a5("love forever");
	cout << "插入前" << endl;
	cout << a5 << endl;
	cout << "插入后" << endl;
	a5.myinsert(4, " you ");
	cout << a5 << endl;
	cout << "删除从2位开始总计2个字符串长度" << endl;
	a5.myerase(2, 2);
	cout << a5 << endl;
	return 0;
	

}
