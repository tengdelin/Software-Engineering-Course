//1．设计一个函数模板，其中包括数据成员T a[n]以及对其进行排序的成员函数sort()，模板参数T可实例化成字符串。
//2．设计一个类模板，其中包括数据成员T a[n]以及在其中进行查找数据元素的函数int search(T)模板参数 T可实例化成字符串。

#ifdef A
#include<iostream>
using namespace std;
#include<vector>
template<typename T,int n>
void paixu(T (&a)[n])//排序函数模板
{
	for (int i = 0; i < n-1; ++i)
	{
		for (int j = n-1; j > i; --j)
		{
			if (a[j] > a[j - 1])
				swap(a[j], a[j - 1]);
		}
	}
}
inline void swap(int& x, int& y)//交换左右值函数
{
	int z(x);
	x = y;
	y = z;
}

int print(int *s)//输出函数，可写为输出模板
{
	for (int i = 0; i <10; i++)
	{
		cout << s[i]<<" ";
	}
	cout << endl;
	return 1;
}
int main()
{
	int s[10] = { 6,5,4,12,3,99,15,21,44,999};
	string s1[3] = { "C++","I love You","forever" };
	paixu(s);
	print(s);
	paixu(s1);
	for (int i = 0; i < 3; i++)
	{
		cout  << s1[i] << " ";
	}
	return 0;
}
#endif A
#ifdef B
#include<iostream>
using namespace std;
template<class T,int n>
class fraction
{
	T a[n];
public:
	void search(T(&a)[n], string b);
	fraction(){}
	~fraction(){}
};
template<class T, int n>void fraction<T, n>::search(T(&a)[n], string b)//类模板的成员函数的定义
{
	for (int i = 0; i < n; i++)
	{
		if (a[i] == b)
		{
			cout << b<<"在数组中的第" << i+1 << "位" << endl;
		}
		else
		{
			cout << b << "不在数组中的第" <<i+1<<"位"<< endl;
		}
	}
}
int main()
{
	string a;
		//int a;
	cout << "请输入要查找的数字：";
	cin >> a;
	//int hex[5] = { 1,2,3,4,5 };
	string hex[5] = { "hello","wrold","c++","cug","mydream" };
	fraction<string,5> arr;//类模板的实例化
	arr.search(hex,a);
	return 0;
}
#endif B
