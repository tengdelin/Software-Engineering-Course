#include<iostream>
using namespace std;
typedef int DataType;
#define Node ElemType
#define ERROR NULL
class Node{
public:
	int data;     //数据域
	Node* next;  //指针域
};
class LinkList{//单链表类
public:
	LinkList();					  //初始化一个单链表;构造函数
	~LinkList();                  //销毁一个单链表;析构函数
	void CreateLinkList(int n);   //创建一个单链表
	void CoutLinkList();        //遍历线性表——即打印链表
	int GetLength();              //获取线性表长度
	ElemType* Find(DataType data); //查找节点
	void InsertElemAtEnd(DataType data);            //在尾部插入指定的元素
	void InsertElemAtIndex(DataType data, int n);    //在指定位置插入指定元素
	void DeleteAll();             //删除所有数据
private:
	ElemType* head;              //头结点
};
//初始化单链表
LinkList::LinkList(){
	head = new ElemType;
	head->data = 0;               //将头结点的数据域定义为0
	head->next = NULL;            //头结点的下一个定义为NULL
}
//销毁单链表
LinkList::~LinkList(){
	delete head;                 //删除头结点
}
//创建一个单链表
void LinkList::CreateLinkList(int n){
	ElemType* pnew, * ptemp;
	ptemp = head;
	if (n < 0) {       //当输入的值有误时
		cout << "输入的节点个数有误" << endl;
		exit(EXIT_FAILURE);
	}
	for (int i = 0; i < n; i++) {        //将值一个一个插入单链表中
		pnew = new ElemType;
		cout << "请输入第" << i + 1 << "个值: ";
		cin >> pnew->data;
		pnew->next = NULL;          
		ptemp->next = pnew;         
		ptemp = pnew;               
	}
}
//遍历单链表
void LinkList::CoutLinkList(){
	if (head == NULL || head->next == NULL) {
		cout << "链表为空表" << endl;
	}
	ElemType* p = head;                 //另指针指向头结点
	while (p->next != NULL){        //当指针的下一个地址不为空时，循环输出p的数据域
		p = p->next;               //p指向p的下一个地址
		cout << p->data << " ";
	}
}
//获取单链表的长度
int LinkList::GetLength(){
	int count = 0;                  //定义count计数
	ElemType* p = head->next;           //定义p指向头结点
	while (p != NULL) {               //当指针的下一个地址不为空时，count+1
		count++;
		p = p->next;                //p指向p的下一个地址
	}
	return count;                   //返回count的数据
}
//查找节点
ElemType* LinkList::Find(DataType data){
	ElemType* p = head;
	if (p == NULL) {                           //当为空表时，报异常
		cout << "此链表为空链表" << endl;
		return ERROR;
	}
	else
	{
		while (p->next != NULL) {              //循环每一个节点
			if (p->data == data) {
				return p;                     //返回指针域
			}
			p = p->next;
		}
		if (p->data == data){
			return p;
		}
		return NULL;                           //未查询到结果
	}
}
//在尾部插入指定的元素
void LinkList::InsertElemAtEnd(DataType data){
	ElemType* newNode = new ElemType;    //定义一个Node结点指针newNode
	newNode->next = NULL;         //定义newNode的数据域和指针域
	newNode->data = data;
	ElemType* p = head;              //定义指针p指向头结点
	if (head == NULL) {           //当头结点为空时，设置newNode为头结点
		head = newNode;
	}
	else                          //循环知道最后一个节点，将newNode放置在最后
	{
		while (p->next != NULL){
			p = p->next;
		}
		p->next = newNode;
	}
}
//在指定位置插入指定元素
void LinkList::InsertElemAtIndex(DataType data, int n){
	if (n<1 || n>GetLength())                   //输入有误报异常
		cout << "输入的值错误" << endl;
	else
	{
		ElemType* ptemp = new ElemType;        //创建一个新的节点
		ptemp->data = data;                     //定义数据域
		ElemType* p = head;                    //创建一个指针指向头结点
		int i = 1;
		while (n > i){                           //遍历到指定的位置
			p = p->next;
			i++;
		}
		ptemp->next = p->next;                 //将新节点插入到指定位置
		p->next = ptemp;
	}
}
//删除所有数据
void LinkList::DeleteAll(){
	ElemType* p = head->next;
	ElemType* ptemp = new ElemType;
	while (p != NULL){                    //在头结点的下一个节点逐个删除节点
		ptemp = p;
		p = p->next;
		head->next = p;
		ptemp->next = NULL;
		delete ptemp;
	}
	head->next = NULL;                
}
//测试函数
int main(){
	LinkList l;
	int i;
	cout << "1.创建单链表\n";
	cout << "2.遍历单链表\n";
	cout << "3.获取单链表的长度\n";
	cout << "4.获取节点\n";
	cout << "5.在尾部插入指定元素\n";
	cout << "6.在指定位置插入指定元素\n";
	cout << "7.删除所有元素" << endl;
	cout << "0.退出" << endl;
	do{
		cout << "请输入你想要得功能: ";
		cin >> i;
		switch (i)
		{
		case 1:
			int n;
			cout << "请输入单链表的长度: ";
			cin >> n;
			l.CreateLinkList(n);
			break;
		case 2://打印链表
			l.CoutLinkList();
			break;
		case 3:
			cout << "该单链表的长度为" << l.GetLength() << endl;
			break;
		case 4:
			DataType data;
			cout << "请输入要获取节点的值: ";
			cin >> data;
			cout << "该节点的值为" << l.Find(data)->data << endl;
			break;
		case 5:
			DataType endData;
			cout << "请输入要在尾部插入的值: ";
			cin >> endData;
			l.InsertElemAtEnd(endData);
			break;
		case 6:
			DataType pointData;
			int index;
			cout << "请输入要插入的数据: ";
			cin >> pointData;
			cout << "请输入要插入数据的位置: ";
			cin >> index;
			l.InsertElemAtIndex(pointData, index);
			break;
		case 7:
			l.DeleteAll();
			break;
		default:
			break;
		}
	} while (i != 0);
	system("pause");
	return 0;
}