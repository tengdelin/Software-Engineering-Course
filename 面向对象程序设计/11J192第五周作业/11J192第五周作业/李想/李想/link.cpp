#include<iostream>
#include"link.h"
using namespace std;
linklist::linklist() {
	head = nullptr;
	length = 0;
};//构造函数
linklist::~linklist() {
	node* temp;
	for (int i = 0; i < length; i++) {
		temp = head;
		head = head->next;
		delete temp;
	}
};//析构函数
int linklist::getlength(){
	return length;
}//得到链表长度
void linklist::inserthead(int data) {
	insert(data, 0);
};//在头部插入节点
void linklist::insert(int data, int pos) {
	if (pos < 0)
	{
		cout << "pos must be greater than zero" << endl;
		return;
	}
	int index = 1;
	node* temp = head;
	node* node1 = new node(data);
	if (pos == 0)
	{
		node1->next =temp;
		head = node1;
		length++;
		return;
	}
	while (temp != NULL && index < pos)
	{
		temp = temp->next;
		index++;
	}
	if (temp == NULL)
	{
		cout << "Insert failed" << endl;
		return;
	}
	node1->next = temp->next;
	temp->next = node1;
	length++;
};//插入节点
void linklist::remove(int data) {
	int pos = find(data);
	if (pos == -1) {
		cout << "delete failed!" << endl;
		return;
	}
	if (pos == 1) {
		head = head->next;
		length--;
		return;
	}
	int index = 2;
	node* temp = head;
	while (index < pos) {
		temp = temp->next;
	}
	temp->next = temp->next->next;
	length--;
};//删除节点
int linklist::find(int data) {
	node* temp = head;
	int index = 1;
	while (temp!= NULL) {
		if (temp->data = data) {
			return index;
		}
		temp = temp->next;
		index++;
		return -1;
	}
};//查找节点位置
void linklist::print() {
	if (head == NULL) {
		cout << "the linklist is empty!" << endl;
		return;
	}
	node* temp = head;
	while (temp != NULL) {
		cout << temp->data << endl;
		temp = temp->next;
	}
};//打印链表
int main() {
	linklist head;
	head.inserthead(1);
	head.print();
	head.insert(2, 1);
	head.print();
	head.insert(3, 2);
	head.print();
	return 0;
}