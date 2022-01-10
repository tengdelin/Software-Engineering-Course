## Homework #2

---

### 选择题

1. B
2. C
3. A
4. C
5. C
6. D

### 填空题

1. 数据 函数
2. 析构
3.  
4. `const T&`
5. `*this`

### 编程题

1. > 
   >
   > #### martix.hpp`
   >
   > ``` c++
   > #ifndef _MARTIX_H_
   > #define _MARTIX_H_
   > class martix44
   > {
   > public:
   > 	martix44()
   > 	{
   > 		for (size_t i = 0; i < 4; ++i)
   > 			for (size_t j = 0; j < 4; ++j)
   > 				data[i][j] = 0;
   > 	}
   > 	martix44(double array[4][4])
   > 	{
   > 		for (size_t i = 0; i < 4; ++i)
   > 			for (size_t j = 0; j < 4; ++j)
   > 				data[i][j] = array[i][j];
   > 	}
   > 	martix44(const martix44& m)
   > 	{
   > 		for (size_t i = 0; i < 4; ++i)
   > 			for (size_t j = 0; j < 4; ++j)
   > 				data[i][j] = m.data[i][j];
   > 	}
   > 	const martix44& operator=(const martix44& rhs)
   > 	{
   > 		for (size_t i = 0; i < 4; ++i)
   > 			for (size_t j = 0; j < 4; ++j)
   > 				data[i][j] = rhs.data[i][j];
   > 		return *this;
   > 	}
   > 	martix44 operator*(const martix44& rhs)
   > 	{
   > 		martix44 ret;
   > 		for (size_t i = 0; i < 4; ++i)
   > 			for (size_t j = 0; j < 4; ++j)
   > 				for (size_t k = 0; k < 4; ++k)
   > 					ret[i][j] += data[i][k] * rhs.data[k][j];
   > 		return ret;
   > 	}
   > 	martix44 operator*(const double& rhs)
   > 	{
   > 		martix44 ret;
   > 		for (size_t i = 0; i < 4; ++i)
   > 			for (size_t j = 0; j < 4; ++j)
   > 				ret[i][j] *= rhs;
   > 		return ret;
   > 	}
   > 	double* operator[](size_t npos)
   > 	{
   > 		return data[npos];
   > 	}
   > private:
   > 	double data[4][4];
   > };
   > #endif // !_MARTIX_H_
   > ```
   >
   > #### `main.cpp`
   >
   > ``` c++
   > #include "martix.hpp"
   > #include <iostream>
   > #include <fstream>
   > #include <cstdlib>
   > 
   > using namespace std;
   > 
   > int main()
   > {
   > 	ifstream fin;
   > 	fin.open("data.txt");
   > 	double a[4][4], b[4][4];
   > 	for (int i = 0; i < 4; ++i)
   > 		for (int j = 0; j < 4; ++j)
   > 			fin >> a[i][j];
   > 	for (int i = 0; i < 4; ++i)
   > 		for (int j = 0; j < 4; ++j)
   > 			fin >> b[i][j];
   > 	martix44 ma(a);
   > 	martix44 mb(b);
   > 	martix44 mc = ma * mb;
   > 	for (int i = 0; i < 4; ++i)
   > 	{
   > 		for (int j = 0; j < 4; ++j)
   > 			cout << mc[i][j] << ' ';
   > 		cout << endl;
   > 	}
   >     fin.close();
   > 	return 0;
   > }
   > ```
   >
   > #### `data.txt`
   >
   > ``` text
   > 1 2 1 0
   > 0 2 0 1
   > 4 0 0 0
   > 5 1 1 2
   > 
   > 0 0 0.25 0
   > 0.2 0.4 0.2 -0.2
   > 0.6 -0.8 -0.65 0.4
   > -0.4 0.2 -0.4 0.4
   > 
   > ```
   >
   > #### output
   >
   > ``` text
   > 1 0 0 0
   > 0 1 0 0
   > 0 0 1 0
   > 0 0 -1.11022e-16 1
   > ```

2. >  
   >
   > #### `rect.hpp`
   >
   > ``` c++
   > #ifndef _RECT_H_
   > #define _RECT_H_
   > #include <cmath>
   > using std::labs;
   > class point
   > {
   > private:
   > 	int _x;
   > 	int _y;
   > public:
   > 	point(int xx = 0, int yy = 0) : _x(xx), _y(yy) {}
   > 	~point() {}
   > 	int x() const { return _x; };
   > 	int y() const { return _y; };
   > };
   > 
   > class rect
   > {
   > private:
   > 	point _p1;
   > 	point _p2;
   > public:
   > 	rect(point p1 = point(), point p2 = point())
   > 	{
   > 		_p1 = p1;
   > 		_p2 = p2;
   > 	}
   > 	int cir() const
   > 	{
   > 		return 2 * (labs(_p1.x() - _p2.x()) + labs(_p1.y() - _p2.y()));
   > 	}
   > 	int area() const
   > 	{
   > 		return labs(_p1.x() - _p2.x()) * labs(_p1.y() - _p2.y());
   > 	}
   > };
   > #endif // !_RECT_H_
   > ```
   >
   > #### `main.cpp`
   >
   > ``` c++
   > #include "rect.hpp"
   > #include <iostream>
   > using namespace std;
   > int main()
   > {
   > 	point A(2, 3);
   > 	point B(5, 7);
   > 	rect rect1(A, B);
   > 
   > 	cout << "Circumference is " << rect1.cir() << endl
   > 		<< "Area is " << rect1.area() << endl;
   > }
   > ```
   >
   > #### output
   >
   > ``` text
   > Circumference is 14
   > Area is 12
   > ```