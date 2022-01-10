#include "mainwindow.h"
#include "abstract_paging.h"
#include "clock_paging.h"
#include "fifo_paging.h"
#include "opt_paging.h"
#include "lru_paging.h"
#include "ui_mainwindow.h"
#include <QMessageBox>
#include <memory>
#include <QDebug>

MainWindow::MainWindow(QWidget *parent)
    : QMainWindow(parent), ui(new Ui::MainWindow) {
    ui->setupUi(this);
}

MainWindow::~MainWindow() { delete ui; }

void MainWindow::on_startButton_clicked()
{
    ui->statusBar->showMessage("");//显示按键
    unique_ptr<AbstractPaging> paging;
    if (ui->clockButton->isChecked())//时钟算法
    {
        paging = unique_ptr<AbstractPaging>(new ClockPaging(ui->frameCountSpin->value()));
    }
    else if (ui->fifoButton->isChecked())//按照地址先排
    {
        paging = unique_ptr<AbstractPaging>(new FifoPaging(ui->frameCountSpin->value()));
    }
    else if (ui->optbutton->isChecked())//最优算法
    {
        paging = unique_ptr<AbstractPaging>(new OptPaging(ui->frameCountSpin->value()));
    }
    else if (ui->lruButton->isChecked())//最近最久
    {
        paging = unique_ptr<AbstractPaging>(new LruPaging(ui->frameCountSpin->value()));
    }
    else
    {
        QMessageBox::critical(this, "error","请选择页面置换算法");
    }
    //将进程顺序信息写入字符串链表
    QStringList stringList = ui->referLine->text().split(QRegExp("[.,;\\s]+"));
    ui->resultWidget->clear();
    double theNum=stringList.length();
    int count=-1;
    for (QString string : stringList)
    {
        count++;
        bool isOk = true;
        int page = string.toInt(&isOk);
        if (isOk == false)//如果转换成int失败
        {
            QMessageBox::critical(this, "error","读取进程出错");
            ui->resultWidget->clear();
            return;
        }
        //记录插入内存之前中断数
        int pageFaultCountBefore = paging->getPageFaultCount();
        //插入内存
        if(ui->optbutton->isChecked())
        {
            paging->refer(page);
            //paging->refer1(page,stringList,count);
        }
        else
        {
            paging->refer(page);

        }
        //获取插入内存之后的中断数
        int pageFaultCountAfter = paging->getPageFaultCount();

        //准备显示
        QString resultLine = QString::number(page) + ":   ";
        const list<int> list = paging->getList();//获取当前内存中的进程
        for (auto page : list)
        {
            resultLine += QString::number(page) + ", ";
        }
        resultLine.chop(2);//删掉最后的：", "
        if (pageFaultCountBefore != pageFaultCountAfter)//说明有新的缺页中断，所以在后面后面输出提示
        {
            resultLine += " [缺页中断]";
        }
        ui->resultWidget->addItem(resultLine);//显示在窗口中

    };
    //ui->statusBar->showMessage("缺页中断数: " + QString::number(paging->getPageFaultCount()));//状态栏中提示有几个中断
    ui->statusBar->showMessage("缺页中断率: " + QString::number(paging->getPageFaultCount()/theNum*100)+"%");//状态栏中提示有几个中断
}

void MainWindow::on_infoButton_clicked() {
    QMessageBox::information(this, "查看",
                             "题目二：模拟存储器管理的设计与实现\n"
                             "作者：小滕\n");
}
