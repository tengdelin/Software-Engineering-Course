#include <iostream>
using namespace std;
template< typename T>void sort(T* a, int n)
{
	T t;
	for(int i = 0;i < n - 1;i++)
		for (int j = 0;j < n - i - 1; j++)
		{
			t = a[j];
			a[j] = a[j + 1];
			a[j + 1] = t;
		}
}
template<typename T>void Print(T* a, int n)
{
	for (int i = 0;i < n;i++)
		cout << a[i] << " ";
	cout << endl;
}
int main()
{
	int I[5] = { 8,7,6,5,4 };
	double D[6] = { 1.2,1.3,1.4,2,2.4,0.4 };
	sort<int>(I, 8);
	sort<double>(D, 7);
	Print(I, 8);
	Print(D, 7);
	return 0;
}