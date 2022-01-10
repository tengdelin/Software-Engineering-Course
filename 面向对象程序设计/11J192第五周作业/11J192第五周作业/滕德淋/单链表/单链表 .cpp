#include<iostream>
using namespace std;

//创建节点
struct student
{
	char name[20];
	int age;
	student* next;
};

int length(student*head)
{
	int counnt = 0;
	student* p = head->next;
	while (p != 0)
	{
		counnt++;
		p = p->next;
	}
	return counnt;
}

//创建链表
student* creatlist(int n)
{
	student* head = new student;//头节点，不存数据
	student* ptr = head;//创建前ptr指向头节点
	for (int i = 0; i < n; i++)
	{
		student* p = new student;//新创建一个节点
		cout << "请输入第" << i + 1 << "个同学信息： ";
		cin >> p->name >> p->age;

		ptr->next = p;//上一个节点的指针域指向当前节点
		ptr = p;//将当前节点给上一个节点
		p->next = nullptr;//将后一个节点的指针域赋值为空指针
	}
	return head;
}


//打印链表
void display(student *head)
{
	student* p = head->next;
	while (p != NULL)
	{
		cout << "姓名： " << p->name << " 年龄： " << p->age << endl;
		p = p->next;//这个节点的指针域赋值给这个节点（下一个节点给上一个节点）
	}
}


//插入节点
void setlist(student *head,int index)
{
	if (head == nullptr || index > length(head))
	{
		cout << "请输入正确的大小" << endl;
	}
	student* ptr = head;//指向头节点
	for (int i = 0; i < index; i++)
	{
		ptr = ptr->next;
	}
	student* newnode = new student;
	cout << "请输入新的节点信息： " << endl;
	cin >> newnode->name >> newnode->age;
	newnode->next = ptr->next;
	ptr->next = newnode;
}


//删除节点
void deletenode(student *head,int index)
{
	if (head == NULL || index > length(head) - 1)
	{
		cout << "请输入正确的大小" << endl;
	}
	student* ptr = head;
	for (int i = 0; i < index; i++)
	{
		ptr = ptr->next;
	}
	student* p = ptr->next;//p就是要删除的节点
	ptr->next = ptr->next->next;
}


int main()
{
	int n = 5;
	student* head = creatlist(n);
	
	setlist(head, 2);
	int t;
	while (1)
	{
		if (length(head) == NULL)
		{
			cout << "链表已经为空，不能再删除" << endl;
			break;
		}
		cout << "请输入您要删除的节点： ";
		cin >> t;
		deletenode(head, t);
		display(head);
	}
	system("pause");
	return 0;
}