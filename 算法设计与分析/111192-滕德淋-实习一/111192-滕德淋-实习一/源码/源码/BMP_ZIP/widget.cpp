#include "widget.h"
#include "ui_widget.h"
#include "BMP.h"
Widget::Widget(QWidget *parent)
    : QWidget(parent)
    , ui(new Ui::Widget)
{
    ui->setupUi(this);
}

Widget::~Widget()
{
    delete ui;
}



void Widget::on_pushButton_clicked()
{
    QString OpenFile, OpenFilePath;
    QImage image;
    //打开文件夹中的图片文件
    OpenFile = QFileDialog::getOpenFileName(this,
                                            "Please choose an image file",
                                            "",
                                            "Image Files(*.jpg *.png *.bmp *.pgm *.pbm);;All(*.*)");
    if( OpenFile != "" )
    {
        if( image.load(OpenFile) )
        {
            ui->label->setPixmap(QPixmap::fromImage(image));
        }
    }

    //显示所示图片的路径
    QFileInfo OpenFileInfo;
    OpenFileInfo = QFileInfo(OpenFile);
    OpenFilePath = OpenFileInfo.filePath();
    filename1=OpenFilePath;
    ui->lineEdit->setText(OpenFilePath);
}

void Widget::on_pushButton_2_clicked()
{
    ui->progressBar->setValue(0);
    CCompressImage mybmp;
    string filename=filename1.toStdString();
    if (filename==""){
        QMessageBox::information(0 , "失败" , "请选择需要压缩的图片！", QMessageBox::Ok | QMessageBox::Default ,QMessageBox::Cancel | QMessageBox::Escape ,  0 );
    }else{
        bool readflag=mybmp.ReadBitmap(filename);
        if(readflag){
            for(int i=0;i<=50;i++)
            {
                ui->progressBar->setValue(i);

                for(int j=0;j<10000000;j++){}
            }
            bool zipflag=mybmp.Compress();
            if(zipflag){
                for(int i=50;i<=100;i++)
                {
                    ui->progressBar->setValue(i);
                    for(int j=0;j<10000000;j++){}
                }
                QMessageBox::information(0 , "成功" , "压缩成功！", QMessageBox::Ok | QMessageBox::Default ,QMessageBox::Cancel | QMessageBox::Escape ,  0 );
            }
        }
    }
}

void Widget::on_pushButton_3_clicked()
{
    ui->progressBar->setValue(0);
    CCompressImage   mybmp;
    string filename=filename1.toStdString();
    if (filename==""){
        QMessageBox::information(0 , "失败" , "请选择需要解压的图片！", QMessageBox::Ok | QMessageBox::Default ,QMessageBox::Cancel | QMessageBox::Escape ,  0 );
    }else{
        bool unzipflag=mybmp.UnCompress(filename);
        if(unzipflag){
            for(int i=0;i<=100;i++)
            {
                ui->progressBar->setValue(i);
                for(int j=0;j<10000000;j++){}
            }
            QMessageBox::information(0 , "成功" , "解压成功！", QMessageBox::Ok | QMessageBox::Default ,QMessageBox::Cancel | QMessageBox::Escape ,  0 );
        }
    }
}
