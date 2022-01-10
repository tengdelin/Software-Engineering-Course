#include<iostream>
using namespace std;

class Cpoint {//定义点类
	friend class Csquare;//设置友元
public:
	Cpoint() {
		X = 0; Y = 0;
	}//默认构造
	Cpoint(int x, int y) {
		X = x; Y = y;
	}//有参构造
	void show() {
		cout << "横坐标为 " << X << endl;
		cout << "纵坐标为 " << Y << endl;
	}//输出横纵坐标
private:
	int X, Y;
};
class Csquare {//定义矩阵类

public:
	Csquare(Cpoint& a, Cpoint& b) {
		A = a; B = b;
	}
	int S(){
		return (A.X - B.X) * (A.Y - B.Y);
	}//计算面积
	int C() {
		return abs((A.X - B.X) + (A.Y - B.Y)) * 2;
	}//计算周长
private:
	Cpoint A, B;
};
int main() {
	int x1=0, y1=0, x2=0, y2=0;
	cout << "输入第一个点" << endl;
	cin >> x1 >> y1;
	cout << "输入第二个点" << endl;
	cin >> x2 >> y2;
	Cpoint A(x1, y1), B(x2, y2);
	Csquare P(A, B);
	cout << "该矩形面积为" << P.S ()<< endl;
	cout << "该矩形周长为" << P.C ()<< endl;
	return 0;
}
