#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)
{
    ui->setupUi(this);
}

MainWindow::~MainWindow()
{
    delete ui;
}

void MainWindow::on_pushButton_clicked()
{
    QFile file("1.txt");
    file.open(QIODevice::WriteOnly | QIODevice::Text);
    QTextStream out(&file);
    QString a;
    //A
    if(ui->costA->text()!=NULL&&ui->arrivedA->text()!=NULL)
    {

        file.write("A ");

        a=ui->arrivedA->text();
        file.write(a.toUtf8()+" ");

        a=ui->costA->text();
        file.write(a.toUtf8());
        if(ui->arrivedB->text()!=NULL){
            out<<endl;
        }

        emit sendsignal("输入成功！");

    }
    //B
    if(ui->costB->text()!=NULL&&ui->arrivedB->text()!=NULL)
    {


        file.write("B ");

        a=ui->arrivedB->text();
        file.write(a.toUtf8()+" ");

        a=ui->costB->text();
        file.write(a.toUtf8());
        if(ui->arrivedC->text()!=NULL){
             out<<endl;
        }
    }
    //C
    if(ui->costC->text()!=NULL&&ui->arrivedC->text()!=NULL)
    {

        file.write("C ");

        a=ui->arrivedC->text();
        file.write(a.toUtf8()+" ");

        a=ui->costC->text();
        file.write(a.toUtf8());
        if(ui->arrivedD->text()!=NULL){
            out<<endl;
        }
    }
    //D
    if(ui->costD->text()!=NULL&&ui->arrivedD->text()!=NULL)
    {

        file.write("D ");

        a=ui->arrivedD->text();
        file.write(a.toUtf8()+" ");

        a=ui->costD->text();
        file.write(a.toUtf8());
        if(ui->arrivedE->text()!=NULL){
             out<<endl;
        }
    }
    //E
    if(ui->costE->text()!=NULL&&ui->arrivedE->text()!=NULL)
    {

        file.write("E ");

        a=ui->arrivedE->text();
        file.write(a.toUtf8()+" ");

        a=ui->costE->text();
        file.write(a.toUtf8());
        if(ui->arrivedF->text()!=NULL){
             out<<endl;
        }
    }
    //F
    if(ui->costF->text()!=NULL&&ui->arrivedF->text()!=NULL)
    {

        file.write("F ");

        a=ui->arrivedF->text();
        file.write(a.toUtf8()+" ");

        a=ui->costF->text();
        file.write(a.toUtf8());
        if(ui->arrivedG->text()!=NULL){
             out<<endl;
        }
    }
    //G
    if(ui->costG->text()!=NULL&&ui->arrivedG->text()!=NULL)
    {

        file.write("G ");

        a=ui->arrivedG->text();
        file.write(a.toUtf8()+" ");

        a=ui->costG->text();
        file.write(a.toUtf8());
        if(ui->arrivedH->text()!=NULL){
             out<<endl;
        }
    }
    //H
    if(ui->costH->text()!=NULL&&ui->arrivedH->text()!=NULL)
    {

        file.write("H ");

        a=ui->arrivedH->text();
        file.write(a.toUtf8()+" ");

        a=ui->costH->text();
        file.write(a.toUtf8());
        if(ui->arrivedI->text()!=NULL){
             out<<endl;
        }
    }
    //I
    if(ui->costI->text()!=NULL&&ui->arrivedI->text()!=NULL)
    {

        file.write("I ");

        a=ui->arrivedI->text();
        file.write(a.toUtf8()+" ");

        a=ui->costI->text();
        file.write(a.toUtf8());
        if(ui->arrivedJ->text()!=NULL){
             out<<endl;
        }

    }
    //J
    if(ui->costJ->text()!=NULL&&ui->arrivedJ->text()!=NULL)
    {

        file.write("J ");

        a=ui->arrivedJ->text();
        file.write(a.toUtf8()+" ");

        a=ui->costJ->text();
        file.write(a.toUtf8());
    }
    this->close();
}

void MainWindow::on_pushButton_2_clicked()
{
    emit sendsignal("取消成功！");
    this->close();
}
