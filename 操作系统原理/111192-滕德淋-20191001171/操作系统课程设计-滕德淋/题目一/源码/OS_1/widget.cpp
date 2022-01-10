#include "widget.h"
#include "ui_widget.h"
using namespace std;
const int INF = 0x3f3f3f3f;

//窗口初始化
Widget::Widget(QWidget *parent)
    : QWidget(parent)
    , ui(new Ui::Widget)
{
    ui->setupUi(this);

    tool=new MainWindow;
    connect(tool,SIGNAL(sendsignal(QString)),this,SLOT(reshow(QString)));
}

Widget::~Widget()
{
    delete ui;
}
//节点
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

//全局变量
int N = 0;//进程数
pcb* pcb_head = new pcb;//头
bool gzr=true;//输出控制
int cpu0 = 0;//时钟1
int cpu1 = 0;//时钟2
double sum_turn = 0;//周转时间
double ave_turn_wei = 0;//平均带权周转时间

void pre_work(){
    N=1;
    cpu0 = 0;
    cpu1 = 0;
    sum_turn = 0;
    ave_turn_wei = 0;
    ifstream iflie;
    iflie.open("1.txt");
    //初始化链表头
    pcb_head->next = NULL;
    pcb* t = new pcb;
    t->next = pcb_head->next;
    iflie >>t->name >> t->arrive >> t->cost;
    t->rate = 1;//初始化
    pcb_head = t;

    while(!iflie.eof())
    {
        N++;
        pcb* temp = new pcb;
        iflie >>temp->name>> temp->arrive >> temp->cost;
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


void fun5() {
    pre_work();
    qDebug() << "进程   到达时间   运行时间" << endl;
    pcb* pp = new pcb;
    pp = pcb_head;

    while (pp != NULL)
    {
        // qDebug() << pp->name << setw(10) << pp->arrive << setw(10) << pp->cost << endl;
        pp = pp->next;
    }
    qDebug() << endl;
}
void Widget::on_pushButton_clicked()
{
    gzr=true;
    pre_work();
    ui->textBrowser->setText("初始化成功！");
    //    //初始化链表
    //    pre_work();
    //    //显示文件
    //    QFile f("test.txt");
    //    if(!f.open(QIODevice::ReadOnly | QIODevice::Text))
    //    {
    //        QMessageBox::about(this,"init","自动初始化失败!");
    //        return ;
    //    }
    //    QTextStream txtInput(&f);
    //    QString lineStr;
    //    ui->textBrowser->setText("name arrived cost \n"+f.readAll());
    //    f.close();

    //
    //    pcb* pp = new pcb;
    //    pp = pcb_head;

    //    while (pp != NULL)
    //    {
    //        ui->textEdit->setText(QString::fromStdString(pp->name));
    //        ui->textEdit->setText((QString)pp->arrive);
    //        ui->textEdit->setText((QString)pp->cost);
    //        pp = pp->next;
    //    }
}

//先来先到算法
void Widget::on_pushButton_2_clicked()
{
    //初始化链表
    pre_work();
    if(gzr){
        ui->textBrowser->clear();
        ui->textBrowser->insertPlainText("进程            结束时间            周转时间              带权周转时间");
        ui->textBrowser->insertPlainText("\n");
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
            //out1(q);
            //qDebug()<<QString::fromStdString( p->name)<< p->end<< p->turn << p->tune_weight << endl;
            if(gzr){
                ui->textBrowser->insertPlainText(QString::fromStdString(q->name)+"\t\t");
                ui->textBrowser->insertPlainText(QString::number(q->end)+"\t\t");
                ui->textBrowser->insertPlainText(QString::number(q->turn)+"\t\t");
                ui->textBrowser->insertPlainText(QString::number(q->tune_weight));
                ui->textBrowser->insertPlainText("\n");
            }
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
            if(gzr){
                ui->textBrowser->insertPlainText(QString::fromStdString(q->name)+"\t\t");
                ui->textBrowser->insertPlainText(QString::number(q->end)+"\t\t");
                ui->textBrowser->insertPlainText(QString::number(q->turn)+"\t\t");
                ui->textBrowser->insertPlainText(QString::number(q->tune_weight));
                ui->textBrowser->insertPlainText("\n");
            }
        }
    }
    //out_put();
    //qDebug() << "平均周转： " << sum_turn / N;
    ui->textBrowser->insertPlainText( "平均周转： "+QString::number(sum_turn / N)+"\n");
    //qDebug() << "平均带权周转： " << ave_turn_wei / N << endl;
    ui->textBrowser->insertPlainText( "平均带权周转： "+QString::number(ave_turn_wei / N)+"\n");
}

//短进程优先算法
void Widget::on_pushButton_3_clicked()
{
    //初始化链表
    pre_work();
    if(gzr){
        ui->textBrowser->clear();
        ui->textBrowser->insertPlainText("进程            结束时间            周转时间              带权周转时间");
        ui->textBrowser->insertPlainText("\n");
    }
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
            if(gzr){
                ui->textBrowser->insertPlainText(QString::fromStdString(q->name)+"\t\t");
                ui->textBrowser->insertPlainText(QString::number(q->end)+"\t\t");
                ui->textBrowser->insertPlainText(QString::number(q->turn)+"\t\t");
                ui->textBrowser->insertPlainText(QString::number(q->tune_weight));
                ui->textBrowser->insertPlainText("\n");
            }
        }
        else {
            if (i == 1 || flag == false)cpu1 = q->arrive;
            cpu1 += q->cost;
            q->end = cpu1;
            q->turn = q->end - q->arrive;      sum_turn += q->turn;
            q->tune_weight = q->turn / (q->cost * 1.0);   ave_turn_wei += q->tune_weight;
            q->cost = 0;
            if(gzr){
                ui->textBrowser->insertPlainText(QString::fromStdString(q->name)+"\t\t");
                ui->textBrowser->insertPlainText(QString::number(q->end)+"\t\t");
                ui->textBrowser->insertPlainText(QString::number(q->turn)+"\t\t");
                ui->textBrowser->insertPlainText(QString::number(q->tune_weight));
                ui->textBrowser->insertPlainText("\n");
            }

        }
    }
    //qDebug() << "平均周转： " << sum_turn / N;
    ui->textBrowser->insertPlainText( "平均周转： "+QString::number(sum_turn / N)+"\n");
    //qDebug() << "平均带权周转： " << ave_turn_wei / N << endl;
    ui->textBrowser->insertPlainText( "平均带权周转： "+QString::number(ave_turn_wei / N)+"\n");
}

//高响应比算法
void Widget::on_pushButton_4_clicked()
{
    //初始化链表
    pre_work();
    if(gzr){
        ui->textBrowser->clear();
        ui->textBrowser->insertPlainText("进程            结束时间            周转时间              带权周转时间");
        ui->textBrowser->insertPlainText("\n");
    }
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
            if(gzr){
                ui->textBrowser->insertPlainText(QString::fromStdString(q->name)+"\t\t");
                ui->textBrowser->insertPlainText(QString::number(q->end)+"\t\t");
                ui->textBrowser->insertPlainText(QString::number(q->turn)+"\t\t");
                ui->textBrowser->insertPlainText(QString::number(q->tune_weight));
                ui->textBrowser->insertPlainText("\n");
            }
        }
        else {
            if (i == 1 || flag == false)cpu1 = q->arrive;
            cpu1 += q->cost;
            q->end = cpu1;
            q->turn = q->end - q->arrive;      sum_turn += q->turn;
            q->tune_weight = q->turn / (q->cost * 1.0);   ave_turn_wei += q->tune_weight;
            q->cost = 0;
            if(gzr){
                ui->textBrowser->insertPlainText(QString::fromStdString(q->name)+"\t\t");
                ui->textBrowser->insertPlainText(QString::number(q->end)+"\t\t");
                ui->textBrowser->insertPlainText(QString::number(q->turn)+"\t\t");
                ui->textBrowser->insertPlainText(QString::number(q->tune_weight));
                ui->textBrowser->insertPlainText("\n");
            }

        }
    }
    ui->textBrowser->insertPlainText( "平均周转： "+QString::number(sum_turn / N)+"\n");
    ui->textBrowser->insertPlainText( "平均带权周转： "+QString::number(ave_turn_wei / N)+"\n");
}

void Widget::on_pushButton_6_clicked()
{
    gzr=false;
    ui->textBrowser->clear();
    this->on_pushButton_2_clicked();
    this->on_pushButton_3_clicked();
    this->on_pushButton_4_clicked();

}

void Widget::on_pushButton_7_clicked()
{
    ui->textBrowser->clear();
    pre_work();
    ui->textBrowser->insertPlainText( "进程   到达时间   运行时间\n");
    pcb* pp = new pcb;
    pp = pcb_head;

    while (pp != NULL)
    {
        ui->textBrowser->insertPlainText(QString::fromStdString(pp->name)+"\t");
        ui->textBrowser->insertPlainText(QString::number(pp->arrive)+"\t");
        ui->textBrowser->insertPlainText(QString::number(pp->cost));
        ui->textBrowser->insertPlainText("\n");
        pp = pp->next;
    }
    ui->textBrowser->insertPlainText("\n");
}

void Widget::on_pushButton_5_clicked()
{
    tool->show();
    this->hide();
}

void Widget::reshow(QString num)
{
    this->show();
    ui->textBrowser->setText(num);
}
