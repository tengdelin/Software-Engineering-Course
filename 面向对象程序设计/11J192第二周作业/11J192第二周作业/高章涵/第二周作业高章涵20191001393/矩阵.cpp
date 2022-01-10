#include<iostream>
using namespace std;
class Cmatrix {
public:
    Cmatrix() {//默认构造
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                arr[i][j] = 0;
    }
    Cmatrix(int a[4][4]) {//有参构造
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                arr[i][j] = a[i][j];
    }
    Cmatrix operator*( Cmatrix a) {//重载*
        Cmatrix c;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                c.arr[i][j] = a.arr[i][0] * arr[0][j] + a.arr[i][1] * arr[1][j] + a.arr[i][2] * arr[2][j] + a.arr[i][3] * arr[3][j];//代公式计算
            }
        }
        return c;
    }
    void show() {//输出这个矩阵
        for (int i = 0; i < 4; i++) {
            cout << " " << endl;
            for (int j = 0; j < 4; j++) {
                cout << arr[i][j] << " ";
            }
        }
    }
private:
    int arr[4][4];//四阶矩阵
 };
int main(){
    int E[4][4]{ {1,0,0,0} ,{0,1,0,0} ,{0,0,1,0} ,{0,0,0,1} };
    int A[4][4]{ {1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1} };
    int B[4][4]{ {1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4} };
    Cmatrix a(A); Cmatrix b(B); Cmatrix o(); Cmatrix e(E);
    Cmatrix c = e * b; c.show();
    Cmatrix d = a * b; d.show();
    return 0;
}