#include<iostream>
#include "myCstring.h"
using namespace std;

int main() {
	/*CString str;
	CString  str1(5);
	CString str2(str1);*/
	CString  str3;
	CString str4;
	str3.Swap(str4);
	str3.print();
	str4.print();
	str3.erase();
	str3.print();
	str3.replace();
	str3.print();
	str3.resize();
	str3.print();
	str3.insert();
	str3.print();
	return 0;
}