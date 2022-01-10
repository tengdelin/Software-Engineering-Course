#include<iostream>
using namespace std;
#include"2Class.h"
int main() {
	cout << "输入左上角点";
 	CPoint P1;
	P1.CinDots();
	cout << "输入右下角点";
	CPoint P2;
	P2.CinDots();
	CRectangle R1(P1, P2);
	cout<<"面积为"<<R1.Area()<<endl;
	cout<<"周长为"<<R1.Cir();
	return 0;
}