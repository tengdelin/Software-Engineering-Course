#pragma once

//前向声明
template<typename T>class SList;
//结点类模板
template<typename T>
class Node
{
	friend class SList<T>;   //将SList声明为Node的友元
	T m_data;  //数据域
	Node* m_next = nullptr;  //指向下一个节点的指针
public:
	Node(const Node& rhs) = delete;
	Node& operator=(const Node& rhs) = delete;
	Node(const T&val):m_data(val){}
	const T& data()const { return m_data; }  //const版本
	T& ddata() { return m_data; }  //非const版本
	Node* next() { return m_next; }
};

//前向声明
template<typename T>ostream& operator<<(ostream&, const SList<T>&);
//单链表类模板
template<typename T>
class SList
{
	friend ostream& operator<<<T>(ostream&, const SList<T>&);
	Node<T>* m_head = nullptr, * m_tail = nullptr;
public:
	SList(const SList&) = delete;
	SList& operator=(const SList&) = delete;
	SList() = default;  //使用默认构造函数
	~SList();
	void clear();     //清空链表
	void push_back(const T& val);  //尾部插入一个结点
	Node<T>* insert(Node<T>* pos, const T& val);   //在位置pos后插入一个新结点
	void erase(const T& val);
	Node<T>* find(const T& val);
};