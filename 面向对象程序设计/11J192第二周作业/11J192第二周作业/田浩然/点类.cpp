#include <iostream>
using namespace std;
class CP//点类
{
public:
	int X, Y;
	CP(int x, int y)
	{
		X = x; Y = y;
		cout << "点的横坐标为：" << X << " " << "点的纵坐标为：" << Y << endl;
	}
};
class CM//矩形类
{
public:
	double C();
	double S();
	friend class CP;
	CM(CP A, CP B)
	{
		X1 = A.X; Y1 = A.Y;
		X2 = B.X, Y2 = B.Y;
	}
private:
	int X1, Y1, X2, Y2;
};
double CM::C()//计算矩形周长
{
	double c;
	c = (2 * (abs(X1 - X2) + abs(Y1 - Y2)));
	return c;
}
double CM::S()//计算矩形面积
{
	double s;
	s = abs((X1 - X2) * (Y1 - Y2));
	return s;
}
int main()
{
	int x1, y1, x2, y2;
	cout << "请输入矩形的左上角与右上角坐标：" << endl;
	cin >> x1 >> y1 >> x2 >> y2;
	CP A(x1, y1);
	CP B(x2, y2);
	CM shu(A, B);
	cout << "周长为：" << shu.C() << " 面积为：" << shu.S();
	return 0;
}