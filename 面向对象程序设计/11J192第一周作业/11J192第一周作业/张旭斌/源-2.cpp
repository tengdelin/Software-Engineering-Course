#include<iostream>
#include<string>
using namespace std;
template<typename T, int n>class Cclass {
	int size;
	T* a;
public:
	Cclass();//构造函数
	~Cclass();//析构函数
	int search(T);
	void set_a(int i,T& j)//给数组元素赋值
};
template<typename T, int n>Cclass<T, n>::Cclass() {
	a = new T[size];//数组大小不知道，new一个
}
template<typename T, int n>Cclass<T, n>::~Cclass() {
	delete[]a;//用完后，手动删内存
}
template<typename T, int n>int Cclass<T, n>::search(T k) {
	for (int i = 0; i < size; i++) {
		if (a[i] == k) {
			return i;//如果有就返回这个值
		}
		return 0;//没有的话，就返回0.在主函数就用if语句，不执行  cout
	}
}
template<typename T, int n>void Cclass<T, n>::set_a(int i, T& j) {
	a[i] = j;
}