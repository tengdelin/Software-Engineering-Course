#include<iostream>
using namespace std;
class point
{
public:
	double m_x;
	double m_y;
	point() = default;
	point(int x, int y)
	{
		m_x = x;
		m_y = y;
	}
};
class linestring :public point
{
public:
	linestring() = default;
	//构造函数,通过传入点数组来构造
	linestring(point* pnts, int num)
	{
		m_data = pnts;
		m_num = num;
	}
	// 复制构造函数
	linestring(const linestring& another)
	{
		m_data = another.m_data;
		m_num = another.m_num;
	}
	// 析构函数
	~linestring()
	{

	}
	// 赋值函数
	linestring& operator =(const linestring& rhs)
	{
		linestring temp;
		temp.m_data = rhs.m_data;
		temp.m_num = rhs.m_num;
		return temp;

	}
	//返回线串中第 index 个点的引用
	point& operator[](int index)
	{
		return m_data[index];
	}
private:
	point* m_data; // 用于保存组成线串的点
	int m_num;// 线串中点的数量
};
void test01()
{
	point p1[5];
	cout << "请输入5个点" << endl;
	for (int i = 0; i < 5; i++)
	{
		cout << "x" << i + 1 << ": ";
		cin >> p1[i].m_x;
		cout << "y" << i + 1 << ": ";
		cin >> p1[i].m_y;
	}
	linestring L(p1, 5);
	linestring L2 = L;
	cout << "您想查看第个点，请输入： ";
	int a;
	cin >> a;
	point pr = L[a-1];
	cout << "您查看的点为： ";
	cout << "(" << pr.m_x << "," << pr.m_y << ")" << endl;
}
int main()
{

	test01();
	return 0;
}