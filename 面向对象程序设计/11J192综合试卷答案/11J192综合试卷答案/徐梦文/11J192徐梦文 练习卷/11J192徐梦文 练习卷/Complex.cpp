#include "Complex.h" 
#include <iostream> 
using namespace std; 
void main(){
	Complex c1(2.0, 3.0);
	Complex c2(1.0, 2.0);
	cout << c1+c2 << endl;
	cout << c1-c2 << endl;
	cout << c1*c2 << endl;
} 