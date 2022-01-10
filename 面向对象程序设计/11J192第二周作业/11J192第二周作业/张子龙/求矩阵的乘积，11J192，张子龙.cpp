#include<iostream>
using namespace std;
class Cproduct {
public:int arr1[4][4];
	  int arr2[4][4];
	  Cproduct(int arr3[4][4],int arr4[4][4] ) {
		  for (int i = 0; i < 4; ++i) {
			  for (int j = 0; j < 4; ++j) {
				  arr1[i][j] = arr3[i][j];
				  arr2[i][j] = arr4[i][j];
			  }
		  }
	  }
	  void Fraction() {
		  int arr5[4][4];
		  int C = 0;
		  for (int i = 0; i < 4; ++i) {
			  for (int j = 0; j < 4; ++j) {
				  arr5[i][j] = arr1[i][j] * arr2[j][i];
				  C += arr5[i][j];
			  }
		  }
		  cout << C << endl;
	  }
	  ~Cproduct(){}
};
int main() {
	int arr3[4][4] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
	int arr4[4][4] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
	Cproduct a(arr3,arr4);
	a.Fraction();
	return 0;
}
