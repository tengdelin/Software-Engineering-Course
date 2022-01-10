#include <iostream>
#include <cmath>
using namespace std;
class Cpoint  //Cpoint类声明
{
public:
	Cpoint();
	Cpoint(int xx, int yy); //构造函数
	friend class Crectangle;//友元声明
private:
	int x, y;//点的横纵坐标
};
Cpoint::Cpoint() {
	x = 0;
	y = 0;
}
Cpoint::Cpoint(int xx, int yy) {
	x = xx;
	y = yy;
}
class  Crectangle//矩形类
{
private:
	Cpoint p1, p2;//矩形的两个点
public:
	Crectangle(Cpoint a, Cpoint b);//构造函数
	int acreage();//计算面积的函数
	int perimeter();//计算周长的函数
};
Crectangle::Crectangle(Cpoint a, Cpoint b) {
	p1 = a;
	p2 = b;
}
int Crectangle::acreage() {
	int length = abs(p1.x - p2.x);//计算长度
	int high = abs(p1.y - p2.y);//计算高度
	return length * high;
}
int Crectangle::perimeter() {
	int length = abs(p1.x - p2.x);//计算长度
	int high = abs(p1.y - p2.y);//计算高度
	return 2 * (length + high);
}
int main() {
	int i, j, m, n;
	cout << "请输入两个点的坐标" << endl;
	cin >> i >> j >> m >> n;
	Cpoint a(i, j), b(m, n);//定义两个点
	Crectangle rec(a, b);//定义矩形
	cout <<"面积"<< rec.acreage() << endl;
	cout <<"周长"<< rec.perimeter() << endl;
	return 0;
}