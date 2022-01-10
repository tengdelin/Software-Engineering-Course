#include <string>
#include <iostream>
using namespace std;


typedef int DataType;

class Node
{
public:
	DataType data;
	Node* next;
};

class LinkList
{
public:
	LinkList();//构造函数
	~LinkList();//析构函数
	int MYCreateLinkList(int size);//创造单向链表
	int MYCLEAR();
	int MYTravalLinkList();
	int MYInsertLinklList(Node* data, int n);//插入
	int MYDeleteLinklist(int n);//删除

	int GetLen();
	bool IsEmply();

	Node* head;//写成内部
	int size;
};

LinkList::LinkList()//构造函数
{
	head = new Node;
	head->data = 0;
	head->next = NULL;
	size = 0;
}

LinkList::~LinkList()//析构函数
{
	delete head;
}

int LinkList::MYCreateLinkList(int n)//创建一个单向列表
{
	if (n < 0) {
		printf("error\n");
		return -1;
	}
	Node* ptemp = NULL;
	Node* pnew = NULL;

	this->size = n;
	ptemp = this->head;//指向链表头部
	for (int i = 0; i < n; i++)//保证每一个链表中的Node指向下一个节点
	{
		pnew = new Node;
		pnew->next = NULL;
		cout << "输入第" << i + 1 << "个节点值" << endl;
		cin >> pnew->data;
		ptemp->next = pnew;
		ptemp = pnew;
	}
	cout << "创建完成" << endl;
	return 0;
}

int LinkList::MYCLEAR()
{
	Node* ptemp;
	if (this->head == NULL) {
		cout << "链表原本就为空" << endl;
		return -1;
	}
	while (this->head)//开始销毁链表
	{
		ptemp = head->next;
		free(head);
		head = ptemp;
	}
	cout << "销毁链表完成" << endl;
	return 0;
}

int LinkList::MYTravalLinkList()//遍历链表并输出
{
	Node* ptemp = this->head->next;
	if (this->head == NULL) {
		cout << "链表为空" << endl;
		return -1;
	}
	while (ptemp)
	{
		cout << ptemp->data << "->";
		ptemp = ptemp->next;
	}
	cout << "NULL" << endl;
	return 0;
}

int LinkList::MYInsertLinklList(Node* data, int n)//链表插入
{
	Node* ptemp;
	if (this->head == NULL) {
		cout << "链表为空" << endl;
		return -1;
	}
	if (data == NULL) {
		cout << "插入节点为空" << endl;
		return -1;
	}
	//头插
	if (n < 2) {
		Node* pnew = new Node;
		pnew->data = data->data;
		pnew->next = this->head->next;
		this->head->next = pnew;
		this->size++;
		return 0;
	}
	//尾插
	if (n > this->size) {
		ptemp = this->head;
		while (ptemp->next != NULL) {
			ptemp = ptemp->next;
		}
		Node* pnew = new Node;
		pnew->data = data->data;
		pnew->next = NULL;
		ptemp->next = pnew;
		this->size++;
		return 0;
	}
	//中间插
	else {
		ptemp = this->head;
		for (int i = 1; i < n; i++) {
			ptemp = ptemp->next;
		}
		Node* pnew = new Node;
		pnew->data = data->data;
		pnew->next = ptemp->next;
		ptemp->next = pnew;
		this->size++;
		return 0;
	}
}

int LinkList::MYDeleteLinklist(int n)//删除链表
{
	Node* ptemp;
	Node* ptemp2;
	if (n > this->size) {
		cout << "n太大" << endl;
		return -1;
	}
	//删头节点
	if (n < 2) {
		ptemp = this->head->next;
		this->head->next = ptemp->next;
		free(ptemp);
		this->size--;
		return 0;
	}
	//尾部删除
	if (n == this->size) {
		ptemp = this->head;
		for (int i = 1; i < this->size; i++) {
			ptemp = ptemp->next;
		}
		ptemp2 = ptemp->next;
		ptemp->next = NULL;
		free(ptemp2);
		this->size--;
		return 0;
	}
	//中间删除
	else
	{
		ptemp = this->head;
		for (int i = 1; i < n; i++) {
			ptemp = ptemp->next;
		}
		ptemp2 = ptemp->next;
		ptemp->next = ptemp2->next;
		free(ptemp2);
		this->size--;
		return 0;
	}
}

int LinkList::GetLen()//得到具体长度
{
	return this->size;
}

bool LinkList::IsEmply()//检测是否为空
{
	if (this->head == NULL) {
		return true;
	}
	else {
		return false;
	}
}

void main(void)
{
	LinkList list;
	LinkList* plist = &list;
	plist->MYCreateLinkList(5);
	plist->MYTravalLinkList();
	Node temp;
	temp.data = 100;
	temp.next = NULL;
	plist->MYInsertLinklList(&temp, 0);
	plist->MYTravalLinkList();
	plist->MYInsertLinklList(&temp, plist->GetLen() + 1);
	plist->MYTravalLinkList();
	plist->MYInsertLinklList(&temp, 5);

	plist->MYTravalLinkList();
	plist->MYDeleteLinklist(0);
	plist->MYTravalLinkList();
	plist->MYDeleteLinklist(list.GetLen());
	plist->MYTravalLinkList();
	plist->MYDeleteLinklist(2);
	plist->MYTravalLinkList();


	plist->MYCLEAR();
	system("pause");
}

