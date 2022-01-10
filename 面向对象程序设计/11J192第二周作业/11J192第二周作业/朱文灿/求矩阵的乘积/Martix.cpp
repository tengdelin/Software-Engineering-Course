#include<iostream>
#include <fstream>
using namespace std;
#include"CMartrix.h"
int main() {
	CMartrix4<double> m1, m2;
	m1.FileInput(m1,m2);
	m1.PrintMartrix();
	m2.PrintMartrix();
	CMartrix4<double> m3;
	m3 = m1 * m2;
	m3.PrintMartrix();
	return 0;
}