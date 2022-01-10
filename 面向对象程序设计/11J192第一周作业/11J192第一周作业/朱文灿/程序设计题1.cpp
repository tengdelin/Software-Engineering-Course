#include<iostream>
using namespace std;
template<typename T>
void sort(int n,T *a) {
    for (int i = 1; i < n; ++i) {
        int value = a[i];
        int j = 0;
        for (j = i - 1; j >= 0; j--) {
            if (a[j] > value) {
                a[j + 1] = a[j];
            }
            else {
                break;
            }
        }
        a[j + 1] = value; 
    }
}
int main() {
	char greeting[] = "hellomyarray";
	sort(13,greeting);
	for (int i = 0; i < 13; i++) {
		cout << greeting[i];//aaehllmorryy
	}
}