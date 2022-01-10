#pragma once
struct node {
	int data;
	node* next;
	node(int n) :data(n), next(nullptr) {};//初始化
};
class linklist {
public:
	linklist();//构造函数
	void inserthead(int data);//在头部插入节点
	void insert(int data, int pos);//插入节点
	void remove(int data);//删除节点
	int getlength();//得到链表长度
	int find(int data);//查找节点位置
	void print();//打印链表
	~linklist();//析构函数
private:
	node* head;//头节点
	int length;//长度
};