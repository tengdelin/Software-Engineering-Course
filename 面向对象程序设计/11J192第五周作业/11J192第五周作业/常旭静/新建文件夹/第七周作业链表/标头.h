#pragma once
#include <ostream>
using namespace std;

template<typename T> class SList; 
template<typename T>
class Node {
	friend class SList<T>;
	T m_data; //数据域
	Node* m_next = nullptr; //指向下一个结点的指针
public:
	Node(const T& val) :m_data(val) { }
	const T& data() const { return m_data; }
	T& data() { return m_data; }
	Node* next() { return m_next; }
	Node(const Node& rhs) = delete;//搬运 教材上解释时控制拷贝，但在这个程序中给好像并没有使用到
	Node& operator =(const Node& rhs) = delete;//搬运
};
template<typename T> ostream& operator<<(ostream&, const SList<T>&);//搬运
template<typename T>
class SList {
	friend ostream& operator<< <T>(ostream&, const SList<T>&);//搬运
	Node<T>* m_head = nullptr, * m_tail = nullptr;
public:
	SList() = default; // 使用默认构造函数
	~SList();
	void clear();//移除全部节点
	void push_back(const T& val);//插入节点
	Node<T>* insert(Node<T>* pos, const T& val);//插入节点
	void erase(const T& val);//删除节点
	Node<T>* find(const T& val);//确定索要插入的位置
	SList(const SList&) = delete;//搬运
	SList& operator=(const SList&) = delete;//搬运
};

template<typename T>
inline void SList<T>::push_back(const T& val)
{
		Node<T>* node = new Node<T>(val); //新建node储存数据，创建新节点
		if (m_head == nullptr)
			m_head = m_tail = node;//只有一个元素时头尾相等
		else {
			m_tail->m_next = node;
			m_tail = node;//尾节点的确定
		}
}

template<typename T>
inline Node<T>* SList<T>::insert(Node<T>* pos, const T& val)
{
	Node<T>* node = new Node<T>(val); 
	node->m_next = pos->m_next; //保证新建节点与后一节点相连
	pos->m_next = node; //前一节点指向新建节点
	if (pos == m_tail) 
		m_tail = node; //尾节点确立
	return node;
}

template<typename T>
inline Node<T>* SList<T>::find(const T& val)
{
	Node<T>* p = m_head;
	while (p != nullptr && p->m_data != val) 
		p = p->m_next;//遍历链表，找到目标数据
	return p;//返回目标数据的地址
}

template<typename T>
void SList<T>::erase(const T& val) {
	Node<T>* p = m_head, * q = p;
	while (p != nullptr && p->m_data != val) {//遍历，寻找目标数据
		q = p; 
		p = p->m_next; 
	} 
	if (p) 
		q->m_next = p->m_next;//前一节点指向该节点的后一节点
	if (p == m_tail)
		m_tail = q;//当p时最后一个节点时，由前一个节点接替p的位置
	if (p == m_head)
		m_head = nullptr;//p为头时，p删除，头就变成了空，下一节点无需再改变
	delete p;
}

template<typename T>
inline SList<T>::~SList()
{
		clear();
}//教材上写定义好了clear函数以后在析构函数中就直接可以调用了，所以我在这里调用了clear函数

template<typename T>
void SList<T>::clear() {
	Node<T>* p = nullptr;
	while (m_head != nullptr) {
		p = m_head; //逐个删除节点
		m_head = m_head->m_next; 
		delete p;
		m_tail = nullptr;
	}
}
template<typename T>
ostream& operator<< (ostream& os, const SList<T>& list) {//搬运教材，因为在CString中对"<<"的重载就失败了，所以我这里
	Node<T>* p = list.m_head;//搬运了教材
	while (p != nullptr) {
		os << p->data() << " ";
		p = p->next();
	}
	return os;
}