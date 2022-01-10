#include<iostream>
#include<string>
using namespace std;
template<typename T>void Sort(T* a, int n) {
	int i, j;
	T t;
	for (i = 0; i < n - 1; i++)
		for (j = 0; j < n - 1; j++)
			if (a[j] > a[j + 1])
			{
				t = a[j];
				a[j] = a[j + 1];
				a[j + 1] = t;
			}
}
	template<typename T>void Print(T * a, int n) {
		int i;
		for (i = 0; i < n; i++) {
			cout << a[i] << ",";
		}
	}
int main() {
	string Str[5] = { "apple","banana","orange","strawberry","pear" };
	int Int[6] = { 11,32,95,47,30 };
	Sort<string>(Str, 5);
	Sort<int>(Int, 6);
	Print(Str, 5);
	Print(Int, 6);
	return 0;
}