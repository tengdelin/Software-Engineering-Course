#include<iostream>
#include<string>
using namespace std;
template<typename T, int n>
void sort1(T(&a)[n]) {
	for (int i = 0; i < n - 1; i++) {
		int min = i;
		T mid;
		for (int j = i + 1; j < n; j++) {
			if (a[j] < a[i]) 
				min = j;
			}
		mid = a[i];
		a[i] = a[min];
		a[min] = mid;
		
}
	

}


int main() {
	int arr[5] = { 1,5,3,9,7 };
	sort1(arr);
	for (int i = 0; i < 5; i++) {
		cout << arr[i] << endl;
	}
	string ac[2] = { "ii","io" };

	sort1(ac);
	for (int i = 0; i < 2; i++) {
		cout << ac[i] << endl;
	}
}
