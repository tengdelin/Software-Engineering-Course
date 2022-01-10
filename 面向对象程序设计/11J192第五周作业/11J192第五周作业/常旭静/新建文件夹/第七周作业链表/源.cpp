#include<iostream>
#include"标头.h"
using namespace std;
void text() {
	SList<int> l;
	int val;
	cout << "请输入链表数据：";//我使用的测试数据是1 2 3
	while (cin >> val) {//ctrl+Z结束输入
		l.push_back(val);
	}//这里参考了教材
	cout << l << endl;
	Node<int>* pos = l.find(3);
	l.insert(pos, 4);
	cout << l << endl;
	l.erase(4);
	cout << l << endl;
}
int main() {
	text();
		return 0;
	}
	
