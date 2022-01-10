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

class Clinklist
{
public:
	Clinklist() {
		head = new Node;
		head->data = 0;
		head->next = NULL;
		size = 0;
	};
	~Clinklist() {
		delete head;
	};
	int MyCreate(int size)//创建单向列表
	{
		if (n < 0) {
			printf("error\n");
			return -1;
		}
		Node* ptemp = NULL;
		Node* pnew = NULL;
		this->size = n;
		ptemp = this->head;//指向头部
		for (int i = 0; i < n; i++)
		{
			pnew = new Node;
			pnew->next = NULL;
			cout << "输入第" << i + 1 << "个节点值" << endl;
			cin >> pnew->data;
			ptemp->next = pnew;
			ptemp = pnew;
		}
		cout << "创建成功" << endl;
		return 0;
	}
	int MyClear() {
		Node* ptemp;
		if (this->head == NULL) {
			cout << "链表为空" << endl;
			return -1;
		}
		while (this->head)//销毁链表
		{
			ptemp = head->next;
			free(head);
			head = ptemp;
		}
		cout << "销毁成功" << endl;
		return 0;
	}
	int MyTraval(){//输出
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
	int MyInsert(Node* data, int n){//链表插入
		Node* ptemp;
		if (this->head == NULL) {
			cout << "链表为空" << endl;
			return -1;
		}
		if (data == NULL) {
			cout << "插入节点为空" << endl;
			return -1;
		}
		if (n < 2) {//头插
			Node* pnew = new Node;
			pnew->data = data->data;
			pnew->next = this->head->next;
			this->head->next = pnew;
			this->size++;
			return 0;
		}
		if (n > this->size) {//尾部
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
		else {//中间
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
	int MyDelete(int n){//删除链表
		Node* ptemp;
		Node* ptemp2;
		if (n > this->size) {
			cout << "n数值过大" << endl;
			return -1;
		}
		if (n < 2) {//删头节点
			ptemp = this->head->next;
			this->head->next = ptemp->next;
			free(ptemp);
			this->size--;
			return 0;
		}
		if (n == this->size) {//尾部
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
		else{//中间
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
	int GetLen(){//得到长度
		return this->size;
	}
	bool IfEmply(){//检测是否为空
		if (this->head == NULL) 
			return true;
		return false;
	}
	Node* head;//写成内部
	int size;
};
void main(void)
{
	Clinklist list;
	Clinklist* plist = &list;
	plist->MyCreate(5);
	plist->MyTraval();
	Node temp;
	temp.data = 100;
	temp.next = NULL;
	plist->MyInsert(&temp, 0);
	plist->MyTraval();
	plist->MyInsert(&temp, plist->GetLen() + 1);
	plist->MyTraval();
	plist->MyInsert(&temp, 5);

	plist->MyTraval();
	plist->MyDelete(0);
	plist->MyTraval();
	plist->MyDelete(list.GetLen());
	plist->MyTraval();
	plist->MyDelete(2);
	plist->MyTraval();

	plist->MyClear();
	system("pause");
}

