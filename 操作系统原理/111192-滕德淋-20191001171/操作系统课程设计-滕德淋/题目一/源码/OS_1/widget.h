#ifndef WIDGET_H
#define WIDGET_H

#include <QWidget>
#include<QMessageBox>
#include<fstream>
#include <iomanip>
#include<QString>
#include<QDebug>
#include<QFile>
#include<mainWindow.h>
QT_BEGIN_NAMESPACE
namespace Ui { class Widget; }
QT_END_NAMESPACE



class Widget : public QWidget
{
    Q_OBJECT

public:
    Widget(QWidget *parent = nullptr);
    ~Widget();

private slots:
    void on_pushButton_clicked();

    void on_pushButton_2_clicked();


    void on_pushButton_3_clicked();

    void on_pushButton_4_clicked();

    void on_pushButton_6_clicked();

    void on_pushButton_7_clicked();

    void on_pushButton_5_clicked();

    void reshow(QString);
signals:
    void sendsignal(QString);
private:
    Ui::Widget *ui;
private:
    MainWindow*tool;
};
#endif // WIDGET_H
