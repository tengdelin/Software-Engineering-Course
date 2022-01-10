#include "LineString.h"
#include <iostream>
using namespace std;
int main() {
	Point p1, p2, p3;
	p1.x = 2;
	p1.y = 5;
	p2.x = 1;
	p2.y = 6;
	p3.x = 7;
	p3.y = 8;
	LineString l1(&p1,4);
	LineString l2 = l1;
	Point p4 = l1[3];
	return 0;
}