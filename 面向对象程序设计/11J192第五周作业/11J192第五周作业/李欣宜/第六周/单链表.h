#pragma once
using namespace std;

template<typename T>//结点
class Node {
	T m_data;
	Node* m_next = nullptr;
public:
	Node(const T&val):m_data(val){}
	const T& data()const { return m_data; }
	T& data() { return m_data; }
	Node* next() { return m_next; }
};
template<typename T>ostream& operator<<(ostream&, const SList <T>&);
template<typename T>//单链表
class SList {
	friend ostream& operator<<<T>(ostream&, const SList<T>&);
	Node<T>* m_head = nullptr, * m_tail = nullptr;
public:
	SList()= default;//默认构造函数
	~SList();
	void clear();//清空单链表
	void push_back(const T &val);//尾插
	Node<T>* insert(Node<T>* pos, const T& val);//在位置pos后插入一个新
	void erase(const T& val);//删除第一个值为Val的元素
	Node<T>* find(const T& val);//返回第一个值为val的元素的地址
};
template<typename T>
ostream& operator<<(ostream& os, const SList<T>& list) {
	Node<T>* p = list.m_head;
	while (p != nullptr) {
		os << p->data() << "";
		p = p->next();
	}
	return os;
}
template<typename T>//析构函数
SList<T>::~SList() {
	clear();
}
template<typename T>//尾插
void SList<T>::push_back(const T& val) {
	Node<T>* node = new Node<T>(val);
	if (m_head == nullptr)
		m_head = m_tail = node;
	else {
		m_tail->m_next = node; m_tail = node;
	}
}
template<typename T>//指定位置插入
Node<T>* SList<T>::insert(Node<T>* pos, const T& val) {
	Node<T>* node = new Node<T>(val);
	node->m_next = pos->m_next;
	pos->m_next = node;
	if (pos == m_tail)
		m_tail = node;
	return node;
}
template<typename T>//删除操作
void SList<T>::erase(const T& val) {
	Node<T>* p = m_head, * q = p;
	while (p != nullptr && p->m_data != val) {
		q = p;
		p = p->m_next;
	}
	if (p)
		q->m_next = p->m_next;
	if (p == m_tail)
		m_tail = q;
	if (p == m_head)
		m_head = nullptr;
	delete p;
}
template<typename T>//清空链表
void SList<T>::clear() {
	Node<T>* p = nullptr;
	while (m_head != nullptr) {
		p = m_head;
		m_head = m_head->m_next;
		delete p;
	}
	m_tail = nullptr;
}


void test() {//测试函数
	SList<int>L;
	int val;
	while (cin >> val) {//测试尾插函数
		L.push_back(val);
	}
	cout << L;//输出链表
	val = 2;
	Node<int>* pos = L.find(val);//测试查找函数
	val = 5;
	L.insert(pos, val);//测试插入函数
	cout << L;//输出链表
	L.erase(val);//测试删除函数
	cout << L;//输出链表
}