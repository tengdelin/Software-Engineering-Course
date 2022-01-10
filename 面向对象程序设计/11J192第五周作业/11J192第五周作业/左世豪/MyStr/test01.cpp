#include<iostream>
using namespace std;
#include "MyStr.h"

int main() {

    MyStr d("abcd");
    MyStr f = "1234";
    MyStr g = d + f;
    cout << g << endl;
    g.insert('s', 1);
    cout << g << endl;
    //g.replace('X', 1);
    //cout << g << endl;
    //g.clear();
    //cout << g << endl;
    d.swap(d,f);
    cout << d << endl;
   
	return 0;
}