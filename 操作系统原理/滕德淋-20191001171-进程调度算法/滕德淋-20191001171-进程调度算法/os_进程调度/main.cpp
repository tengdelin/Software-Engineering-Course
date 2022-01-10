
/*
 先来先服务
 短作业优先
 响应比高算法：响应比 =（等待时间+要求服务时间）/ 要求服务时间
*/
#include<iostream>
#include<fstream>
#include <iomanip>
using namespace std;
const int N = 10;//10个任务
const int INF = 0x3f3f3f3f;

struct pcb
{
	int arrive;  //到达时间
	double rate;   //响应比
	string name; //名称
	int cost;    //运行时间
	int end;    //结束时间
	int turn;      //周转时间
	double tune_weight;
	pcb* next;
};

pcb* pcb_head = new pcb;//头
bool gzr;//输出控制
int cpu0 = 0;  //时钟1
int cpu1 = 0;  //时钟2
double sum_turn = 0;     //周转时间
double ave_turn_wei = 0;    //平均带权周转时间

void pre_work(){
	cpu0 = 0;
	cpu1 = 0;
	sum_turn = 0;
	ave_turn_wei = 0;
	ifstream iflie;
	iflie.open("test.txt");
	//初始化链表头
	pcb_head->next = NULL;
	pcb* t = new pcb;
	t->next = pcb_head->next;
	iflie >> t->name >> t->arrive >> t->cost;
	t->rate = 1;//初始化
	pcb_head = t;

	for (int i = 0; i < 9; i++) 
	{
		pcb* temp = new pcb;
		iflie >> temp->name >> temp->arrive >> temp->cost;
		pcb* p = pcb_head;
		temp->rate = INF;
		while (p->next != NULL)
		{
			p = p->next;
		}
		temp->next = p->next;
		p->next = temp;
	}
	iflie.close();
}


void out_put() {
	cout << "平均周转：     " << sum_turn / N;
	cout << "      平均带权周转： " << ave_turn_wei / N << endl;
}


void out1(pcb* p) {
	if (gzr == 0)
		return;
	cout << p->name << setw(15) << p->end << setw(15) << p->turn << setw(15) << p->tune_weight << endl;
}


//FIFS
void fun1() {
	cout << "先来先服务算法：" << endl;
	pre_work();
	if (gzr) {
		cout << "进程       结束时间      周转时间        带权周转时间 " << endl;
	}
	bool flag;
	for (int i = 0; i < N; i++) {
		pcb* p = new pcb;
		pcb* q = new pcb;
		p = pcb_head;
		flag = false;
		q->arrive = INF;
		q->next = NULL;
		//执行
		while (p != NULL) {
			if (p->cost != 0 && p->arrive <= q->arrive && (p->arrive <= cpu0 || p->arrive <= cpu1))
			{
				q = p;
				flag = true;
			}
			p = p->next;
		}
		if (flag == false) {
			p = pcb_head;
			while (p != NULL)
			{
				if (p->cost != 0 && p->arrive < q->arrive)q = p;
				p = p->next;
			}
		}
		if (cpu0 <= cpu1)
		{
			//q是最先到的进程
			if (i == 0) cpu0 = q->arrive;
			if (!flag) cpu0 = q->arrive;
			cpu0 += q->cost;
			q->end = cpu0;
			q->turn = q->end - q->arrive;      
			sum_turn += q->turn;
			q->tune_weight = q->turn / (q->cost * 1.0);   
			ave_turn_wei += q->tune_weight;
			q->cost = 0;
			out1(q);
		}
		else {
			if (i == 1 || flag == false)cpu1 = q->arrive;
			cpu1 += q->cost;
			q->end = cpu1;
			q->turn = q->end - q->arrive;      
			sum_turn += q->turn;
			q->tune_weight = q->turn / (q->cost * 1.0);   
			ave_turn_wei += q->tune_weight;
			q->cost = 0;
			out1(q);
		}
	}
	out_put();
}
//短作业优先
void fun2() {
	cout << "短进程优先算法：" << endl;
	pre_work();
	if (gzr)cout << "进程       结束时间      周转时间        带权周转时间 " << endl;
	bool flag;
	for (int i = 0; i < N; i++) {
		pcb* p = new pcb;
		pcb* q = new pcb;
		p = pcb_head;
		flag = false;
		q->cost = INF;
		q->next = NULL;
		q->arrive = INF;
		while (p != NULL)
		{
			if (cpu0 <= cpu1 && p->arrive <= cpu0)
			{
				if (p->cost != 0 && p->cost <= q->cost)
				{
					q = p;
					flag = true;
				}
			}
			if (cpu0 > cpu1 && p->arrive <= cpu1)
			{
				if (p->cost != 0 && p->cost <= q->cost)
				{
					q = p;
					flag = true;
				}
			}
			p = p->next;
		}
		if (flag == false) {
			p = pcb_head;
			while (p != NULL)
			{
				if (p->cost != 0 && p->arrive < q->arrive)q = p;
				p = p->next;
			}
		}
		if (cpu0 <= cpu1)
		{
			if (i == 0 || !flag) cpu0 = q->arrive;
			cpu0 += q->cost;
			q->end = cpu0;
			q->turn = q->end - q->arrive;      sum_turn += q->turn;
			q->tune_weight = q->turn / (q->cost * 1.0);   ave_turn_wei += q->tune_weight;
			q->cost = 0;
			out1(q);
		}
		else {
			if (i == 1 || flag == false)cpu1 = q->arrive;
			cpu1 += q->cost;
			q->end = cpu1;
			q->turn = q->end - q->arrive;      sum_turn += q->turn;
			q->tune_weight = q->turn / (q->cost * 1.0);   ave_turn_wei += q->tune_weight;
			q->cost = 0;
			out1(q);

		}
	}
	out_put();
}
//响应比高者优先
void fun3() {
	pre_work();
	cout << "响应比优先算法：" << endl;
	if (gzr)cout << "进程       结束时间      周转时间        带权周转时间 " << endl;
	//是否输出多余信息
	bool flag;
	for (int i = 0; i < N; i++) {
		pcb* p = new pcb;
		pcb* q = new pcb;
		p = pcb_head;
		flag = false;
		q->rate = -INF;
		q->next = NULL;
		q->arrive = INF;
		//选择是那个CPU计算响应比
		if (cpu0 <= cpu1 && p->arrive <= cpu0) {
			pcb* t = pcb_head;
			while (t != NULL) {
				//计算剩余响应比
				if (t->cost != 0)t->rate = (cpu0 - t->arrive) / (t->cost * 1.0) + 1;
				t = t->next;
			}

		}
		else if (cpu0 > cpu1 && p->arrive <= cpu1)
		{
			pcb* t = pcb_head;
			while (t != NULL)
			{
				if (t->cost != 0)t->rate = (cpu1 - t->arrive) / (t->cost * 1.0) + 1;
				t = t->next;
			}
		}
		if (p->arrive <= cpu1 || p->arrive <= cpu0)
			while (p != NULL)
			{
				if (p->cost != 0 && p->rate >= q->rate) {
					q = p;
					flag = true;
				}
				p = p->next;
			}
		if (flag == false) {
			p = pcb_head;
			while (p != NULL)
			{
				if (p->cost != 0 && p->arrive < q->arrive)q = p;
				else if (p->cost != 0 && p->arrive == q->arrive) {//考虑相等
					if (p->cost < q->cost)q = p;
				}
				p = p->next;
			}
		}
		if (cpu0 <= cpu1)
		{
			if (i == 0 || !flag) cpu0 = q->arrive;
			cpu0 += q->cost;
			q->end = cpu0;
			q->turn = q->end - q->arrive;      sum_turn += q->turn;
			q->tune_weight = q->turn / (q->cost * 1.0);   ave_turn_wei += q->tune_weight;
			q->cost = 0;
			out1(q);
		}
		else {
			if (i == 1 || flag == false)cpu1 = q->arrive;
			cpu1 += q->cost;
			q->end = cpu1;
			q->turn = q->end - q->arrive;      sum_turn += q->turn;
			q->tune_weight = q->turn / (q->cost * 1.0);   ave_turn_wei += q->tune_weight;
			q->cost = 0;
			out1(q);

		}
	}
	out_put();
}




void fun4() {
	gzr = 0;
	fun1();
	fun2();
	fun3();
}
void fun5() {
	pre_work();
	cout << "进程   到达时间   运行时间" << endl;
	pcb* pp = new pcb;
	pp = pcb_head;

	while (pp != NULL)
	{
		cout << pp->name << setw(10) << pp->arrive << setw(10) << pp->cost << endl;
		pp = pp->next;
	}
	cout << endl;
}
int main() {
	while (1) {
		cout << "************选择作业调度算法************** " << endl;
		cout << "            1.FCFS算法               " << endl;
		cout << "            2.SJF算法 " << endl;
		cout << "            3.HRRN算法 " << endl;
		cout << "            4.查看各个算法性能比较表 " << endl;
		cout << "            5.查看各个进程的信息 " << endl;
		char ch;
		cin >> ch;
		cout << endl;
		switch (ch)
		{
		case '1':
			gzr = 1; 
			fun1();
			break;
		case '2':
			gzr = 1; 
			fun2();
			break;
		case '3':
			gzr = 1; 
			fun3();
			break;
		case '4': 
			fun4();
			break;
		case '5':
			fun5();
			break;
		default:
			cout << "输入有误！！" << endl;
			break;
		}
	}
}