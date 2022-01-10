#include<iostream>
using namespace std;

template<typename T,int n>
class A {
	T* M;
	int S;
public:
	A();
	~A();
	bool search(T x);
	void setM(int m, const T& v);

};
template<typename T, int n>A<T, n>::A() {
	S = n > 1 ? n : 1;
	M = new T[S];
}
template<typename T, int n>A<T, n>::~A() {
	delete[]M;
}
template<typename T, int n>bool A<T, n>::search(T x) {
	int i = 0;
	for (i = 0; i < S; i++)
		if (M[i] == x)
			return 1;
	return 0;
}
template<typename T, int n>void A<T, n>::setM(int m,const T&v) {
	M[m] = v;
}
int main() {
	A<int, 5>arr;
	int X=5;
	for (int i = 0; i < 5; i++) {
		arr.setM(i, X );
	}
	if (arr.search(5)) {
		cout << "在数组中";
	}
	else cout << "不在";
	return 0;
}