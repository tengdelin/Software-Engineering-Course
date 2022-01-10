#include<iostream>
#include<stdlib.h>
using namespace std;
template<typename T,int n>
class Show {
public:
	Show();
	~Show();
	int Search(T);
	void NumberGiven(int i,const T& num);
private:
	T* a;
	int len;
};
template<typename T, int n>Show<T, n>::Show() {
	len = n;
	a = new T[len];
}
template<typename T, int n>Show<T, n>::~Show() {
	delete[]a;
}
template<typename T, int n>int Show<T, n>::Search(T k) {
	for (int i = 0; i < len; i++) {
		if (a[i] == k) {
			cout << "find it\n";
			break;
		}
		else {
			cout << "no results\n";
		}
	}
	return 0;
}
template<typename T, int n>void Show<T, n>::NumberGiven(int i,const T &num) {
	a[i] = num;
}
int main() {
	Show<string, 10> Test1;
	for (int i = 0; i < 10; i++) {
		Test1.NumberGiven(i,"a");
	}
	Show<int, 6> Test2;
	for (int i = 0; i < 6; i++) {
		Test2.NumberGiven(i,20);
	}
	Test1.Search("a");
	Test2.Search(20);
	return 0;
}
