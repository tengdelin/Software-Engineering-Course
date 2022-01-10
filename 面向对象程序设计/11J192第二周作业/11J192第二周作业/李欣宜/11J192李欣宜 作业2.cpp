#include <iostream>
using namespace std;

class Point {
    friend class rectangle;
private:
    int m, n;
public:
    int showx();//求横坐标
    int showy();//求纵坐标
    Point(int a, int b) :m(a), n(b) {};
    ~Point() {}
};
int Point::showx() {
    return m;
}
int Point::showy() {
    return n;
}
class rectangle {
private:
    Point p1;//左上角点
    Point p2;//右下角点
public:
    int area();//求面积函数
    int cir();//求周长函数
    rectangle(Point A, Point B) :p1(A), p2(B) {};
};
int rectangle::area() {
    int s;
    s = (p1.n - p2.n) * (p2.m - p1.m);
    return s;
}
int rectangle::cir() {
    int c;
    c = 2 * (p1.n - p2.n) + 2 * (p2.m - p1.m);
    return c;
}

int main()
{
    int a, b, c, d;
    cout << "请输入左上角点的横纵坐标" << endl;
    cin >> a >> b;
    cout<< "请输入右下角点的横纵坐标" << endl;
    cin >> c >> d;
    Point A(a, b);
    Point B(c, d);
    rectangle C(A, B);
    cout << "左上角点坐标为：（" << A.showx() <<","<<A.showy()<<")"<< endl;//输出左上角点
    cout << "右下角点坐标为：（" << B.showx() << "," << B.showy() << ")" << endl;//输出右下角点
    cout<<"面积为"<<C.area()<<endl;//输出面积
    cout << "周长为" << C.cir() << endl;//输出周长
    return 0;
}