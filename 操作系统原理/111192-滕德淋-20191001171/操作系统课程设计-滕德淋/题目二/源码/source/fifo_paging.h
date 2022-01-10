#ifndef FIFO_PAGING_H
#define FIFO_PAGING_H

#include "abstract_paging.h"
using namespace std;
class FifoPaging : public AbstractPaging
{
  public:
    FifoPaging(int pageCount);//页面数
    void refer(int page) override;//重写抽象类的函数
    const list<int> getList() override;//重写抽象类的函数
    void clear() override;//重写抽象类的函数
    void refer1(int page,QStringList stringList,int count);
  private:
    list<int> mPages;
};

#endif // FIFO_PAGING_H
