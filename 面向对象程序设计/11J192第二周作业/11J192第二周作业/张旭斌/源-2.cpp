//老师，两个文件错误都一样，LNK2019，我试了我能查的方法，改链接器什么的，还是有这个错误。
#include<iostream>
#include<math.h>
using namespace std;
class CPoint {
public:
	CPoint(int i,int j);//构造函数
	~CPoint() {//析构函数
		cout << "析构函数" << endl;
	};
	int show();
	void getxy(int *px,int *py)const;//提取 x，y
private:
	int x;
	int y;
	friend class CPoint;//友元类
};
CPoint::CPoint(int i,int j) :x(i),y(j){}
int CPoint::show() {
	cout << "点的坐标为" << "(" << x << "," << y << ")" << endl;
	return 0;
}
void CPoint::getxy(int *px,int *py)const{
	*px = x;
	*py = y;
}

class CPoint;
class CRectangle {
public:
	CRectangle();//构造函数
	~CRectangle();//析构函数
	int area(const CPoint& a, const CPoint& b);//面积函数
	int circumference(const CPoint& a, const CPoint& b);//周长函数
private:
};
int CRectangle::area(const CPoint&a,const CPoint&b) {
	int p;
	int i(0), j(0), k(0), l(0);
	a.getxy(&i,& j);
	b.getxy(&k, &l);
	p = abs( i-k ) * abs(j -l );
	return p;
}
int CRectangle::circumference(const CPoint& a, const CPoint& b) {
	int  p;
	int i(0), j(0), k(0), l(0);
	a.getxy(&i,& j);
	b.getxy(&k, &l);
	p = (abs(i - k) + abs(j - l))*2;
	return p;
}
int main() {
	int i(0), j(0), k(0), l(0);
	CPoint a(i, j);//左上角点
	CPoint b(k, l);//右下角点
	cout << "请输入左上角的坐标" << endl;
	cin >> i >> j;
	cout << "请输入右上角的坐标" << endl;
	cin >> k >> l;
	CRectangle c;
	cout << "矩形的面积为" <<c.area(a,b)<<endl;
	cout << "矩形的周长为" << c.circumference(a, b) << endl;
	return 0;
}
