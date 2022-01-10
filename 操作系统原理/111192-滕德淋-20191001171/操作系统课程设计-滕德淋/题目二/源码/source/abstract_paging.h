#ifndef ABSTRACT_PAGING_H
#define ABSTRACT_PAGING_H

#include <list>
#include <stdexcept>
#include <QStringList>
using namespace std;

// 抽象页面替代类
class AbstractPaging {
public:
    //参数构造函数
    AbstractPaging(int pageCount) : mPageCount(pageCount)
    {
        if (pageCount <= 0)
        {
            throw invalid_argument("error,FrameCount <= 0");
        }
    }
    // 传送页
    virtual void refer(int page) = 0;
    virtual void refer1(int page,QStringList stringList,int count)=0;
    // 获取页面列表
    virtual const list<int> getList() = 0;
    // 获取中断数
    virtual int getPageFaultCount()
    {
        return mPageFault;
    }
    // 数据清理，恢复原状
    virtual void clear() = 0;
    // 虚构函数
    virtual ~AbstractPaging() {}

protected:
    //最大存储页数
    int mPageCount;
    // 当前页面缺失数
    int mPageFault = 0;
};

#endif // ABSTRACT_PAGING_H
