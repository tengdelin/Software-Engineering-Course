// C++单链表.cpp : 此文件包含 "main" 函数。程序执行将在此处开始并结束。
//

#include <iostream>
using namespace std;
struct node
{ 
    int date;//日期
    int xingqi;//星期几
    struct node* next;
};
struct node* creatlist(int x) {//创建链表
    struct node* head = new struct node;//头节点
    struct node* previous = head;//
    for (int i = 0; i < x; i++) {//创造新结点
        struct node* S = new struct node;
        cout << "请输入第" << i + 1 << "个日期和星期几" << endl;
        cin >> S->date;
        cin >> S->xingqi;
        previous->next = S;
        previous = S;
        S->next = NULL;//最后一个节点指向空
    }
    return head;
}
void show(struct node* head2) {//显示测试结果
    struct node* S1 = head2->next;
    while (S1 != NULL) {
        cout << S1->date << " " << S1->xingqi << endl;
        S1 = S1->next;
    }
}

int main()//在主函数中测试
{
    int x1 = 3;
    struct node*head1=creatlist(x1);
    show(head1);
    return 0;
}

// 运行程序: Ctrl + F5 或调试 >“开始执行(不调试)”菜单
// 调试程序: F5 或调试 >“开始调试”菜单

// 入门使用技巧: 
//   1. 使用解决方案资源管理器窗口添加/管理文件
//   2. 使用团队资源管理器窗口连接到源代码管理
//   3. 使用输出窗口查看生成输出和其他消息
//   4. 使用错误列表窗口查看错误
//   5. 转到“项目”>“添加新项”以创建新的代码文件，或转到“项目”>“添加现有项”以将现有代码文件添加到项目
//   6. 将来，若要再次打开此项目，请转到“文件”>“打开”>“项目”并选择 .sln 文件
