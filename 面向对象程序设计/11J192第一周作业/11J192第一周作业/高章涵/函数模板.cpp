#include<iostream>
#include<string>
using namespace std;

template<typename T,int n>
void F(T(&a)[n]) {
	int i, j;
	T t;
	for(i = 0; i < n; i++) {
		for (j = 0; j < n - i - 1; j++) {
			if (a[j] > a[j + 1]) {
				t = a[j];
				a[j] = a[j + 1];
				a[j + 1] = t;
			}
		}
	}
}

int main() {
	int a[6]={ 1,6,2,5,3,7 };
	F(a);
	for (int i = 0; i < 6; i++) {
		cout << a[i] << " ";
	}
	cout << endl;
	string o[] = { "cpp","apple","big" };
	F(o);
	for (int i = 0; i < 3; i++) {
		cout << o[i] << ",";
	}
	return 0;
}