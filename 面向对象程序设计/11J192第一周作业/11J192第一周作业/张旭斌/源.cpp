#include<iostream>
#include<string>
using namespace std;
template<typename T>void sort(T*a,int n) {
	int i, j;
	T temp;
	for (i = 0; i < n - 1; i++) {
		for (j = 0; j < n - i - 1; j++) {
			if (a[j] > a[j + 1]) {
				temp = a[j];
				a[j] = a[j + 1];
				a[j + 1]=temp;
			}
		}
	}
}


