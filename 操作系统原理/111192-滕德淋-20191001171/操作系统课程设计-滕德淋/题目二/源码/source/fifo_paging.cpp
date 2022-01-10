#include "fifo_paging.h"
#include <algorithm>

// 参数构造函数
FifoPaging::FifoPaging(int pageCount) : AbstractPaging(pageCount) {}

// 页传送
void FifoPaging::refer(int page)
{
    //该函数会返回一个输入迭代器，
    //当 find() 函数查找成功时，其指向的是在 [first, last) 区域内查找到的第一个目标元素；
    //如果查找失败，则该迭代器的指向和 last 相同。
    if (find(mPages.begin(), mPages.end(), page) == mPages.end())//在内存中找是否有page这个进程,发生缺页中断则进分支
    {
        ++mPageFault;//中断加1
        if ((long)mPages.size() == (long)mPageCount)//发生页面置换
        {
            //删除第一个或最后一个元素—–pop_front 和pop_back 函数，函数返回void
            mPages.pop_front();
        }
        mPages.emplace_back(page);
    }
}

void FifoPaging:: refer1(int page,QStringList stringList,int count)
{

}
// 获取页面列表
const list<int> FifoPaging::getList()
{
    return mPages;
}

// 数据清理，恢复原状
void FifoPaging::clear()
{
    mPageFault = 0;
    mPages.clear();
}
