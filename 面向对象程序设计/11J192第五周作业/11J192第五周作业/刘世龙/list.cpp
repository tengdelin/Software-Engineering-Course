#include <iostream>
using namespace std;
#include"list.h"

//尾部插入一个结点
template<typename T>
void SList<T>::push_back(const T& val)
{
	Node<T>* node = new Node<T>(val);  //创建一个新的结点
	if (m_head == nullptr)
		m_head = m_tail = node;
	else
	{
		m_tail->m_next = node;
		m_tail = node;
	}
}

//指定位置插入
template<typename T>
Node<T>* SList<T>::insert(Node<T>* pos, const T& val)
{
	Node <T>* node = new Node<T>(val);   //创建一个新的结点
	node->m_next = pos->m_next;   //node指针域指向pos的后继结点
	pos->m_next = node;   //将node置为pos的后继结点
	if (pos == m_tail)    //判断pos是否为尾结点、
		m_tail = node;   //修改tail指针
	return node;
}
template<typename T>
Node<T>* SList<T>::find(const T& val)
{
	Node<T>* p = m_head;
	while (p != nullptr && p->m_data != val)   //找到val首次出现的地方
		p = p->m_next;
	return p;
}

//删除操作
template<typename T>
void SList<T>::erase(const T& val)
{
	Node<T>* p = m_head, * q = p;
	while (p != nullptr && p->m_data != val)
	{
		q = p;   //指针q指向p
		p = p->m_next;   //指针p向后移
	}          //指针p指向待删除结点，指针q指向p的先驱

	if (p)   //如果p非空，将结点p从链表移除
		q->m_next = p->m_next;
	if (p == m_tail)   //如果p为表尾元素，修改tail指针
		m_tail = q;
	if (p == m_head)   //如果p为头表元素，修改head指针为空指针
		m_head = nullptr;
	delete p;   //释放p所指向内存
}

//清空链表
template<typename T>
void SList<T>::clear()
{
	Node<T>* p = nullptr;
	while (m_head!=nullptr)
	{
		p = m_head;   //p指向当前表头结点
		m_head = m_head->m_next;   //表头结点后移
		delete p;   //释放p所指向内存
	}
	m_tail = nullptr;   //将尾指针tail置空
}
//析构函数调用clear释放链表内存空间
template<typename T>
SList<T>::~SList()
{
	clear();
}

//输出运算符
template<typename T>
ostream& operator<<(ostream& os, const SList<T>& list)
{
	Node<T>* p = list.m_head;
	while (p!=nullptr)
	{
		os << p->data() << " ";
		p = p->next();
	}
	return os;
}

//测试
int main()
{
	int val ,n,m,s;  //val为输入数据
	cout << "请输入存放数据的个数:";
	cin >> n;   //n为数据个数
	SList<int>list;   //定义一个存放整型元素的链表list int val；
	cout << "请依次输入数据：" << endl;
	for (int i = 0; i < n;i++)//输入n个数据
	{
		cin >> val;
		list.push_back(val);  //依次尾插到链表 list 中
	}
	cout << "打印输出数据： ";
	cout << list << " ";   //打印输出n个数据
	cout <<endl<< "请输入所要查询数据(已输入数据)： ";
	cin >> m;
	Node<int>* pos = list.find(m);  //查找 m 所在的结点指针
	cout << "请输入所要插入新元素： ";
	cin >> s;
	list.insert(pos, s);   //在元素 m 后面插入元素为 s 的新结点
	cout <<"打印输出： "<< list << endl;   
	cout << "删除新元素——" << endl;
	list.erase(s);   //删除元素 s
	cout <<"删除后输出： "<< list << endl;   //打印输出元素 
	cout << "清空数据——" << endl;
	list.clear();
	cout << "清空后输出： "<<list <<endl;
	return 0;
}