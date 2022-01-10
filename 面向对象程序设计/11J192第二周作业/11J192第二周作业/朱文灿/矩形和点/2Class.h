#pragma once
class CPoint {
public:
    CPoint();
    CPoint(double a, double b);
    CPoint(const CPoint& a);
    ~CPoint();
    void PrintDots();
    void CinDots();
    friend class CRectangle;
private:
    double m_x;
    double m_y;
};
CPoint::CPoint() {
    m_x = 0;
    m_y = 0;
}
CPoint::CPoint(double a, double b) {
    m_x = a;
    m_y = b;
}
CPoint::~CPoint() {}
CPoint::CPoint(const CPoint& a) :m_x(a.m_x), m_y(a.m_y) {}
void CPoint::PrintDots() {
    cout << "x is" << m_x << "and y is" << m_y;
}
void CPoint::CinDots() {
    cout << "请输入该点横纵坐标";
    cin >> m_x >> m_y;
}
class CRectangle {
public:
    CRectangle();
    ~CRectangle();
    CRectangle(CPoint a, CPoint b);
    double Area();
    double Cir();
private:
    CPoint m_lu;
    CPoint m_rd;
};
CRectangle::CRectangle(){}
CRectangle::~CRectangle() {}
CRectangle::CRectangle(CPoint a, CPoint b) {
    m_lu = a;
    m_rd = b;
}
double CRectangle::Area() {
    return (m_rd.m_x - m_lu.m_x) * (m_lu.m_y - m_rd.m_y);
}
double CRectangle::Cir() {
    return ((m_rd.m_x - m_lu.m_x) +(m_lu.m_y - m_rd.m_y))*2;
}