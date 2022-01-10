#include "clock_paging.h"
#include <algorithm>

// 参数构造函数
ClockPaging::ClockPaging(int pageCount) : AbstractPaging(pageCount) {}

// 页传送
void ClockPaging::refer(int page)
{
    auto duplicate = std::find(mPages.begin(), mPages.end(), page);
    if (duplicate != mPages.end())
    {
        mBits[duplicate - mPages.begin()] = true;//访问位
        return;
    }
    ++mPageFault;
    //发生缺页中断，但是内存还有空闲
    if ((long)mPages.size() != (long)mPageCount)
    {
        mPages.emplace_back(page);
        mBits.emplace_back(false);
        return;
    }
    while (true)
    {
        if (!mBits[mCurrent])
        {
            mPages[mCurrent] = page;
            mCurrent = (mCurrent + 1) % mPageCount;//循环检查
            return;
        }
        mBits[mCurrent] = false;
        mCurrent = (mCurrent + 1) % mPageCount;
    }
}
void ClockPaging:: refer1(int page,QStringList stringList,int count)
{

}
// 获取页面列表
const std::list<int> ClockPaging::getList() {
    return std::list<int>(mPages.begin(), mPages.end());
}

// 数据清理，恢复原状
void ClockPaging::clear() {
    mPageFault = 0;
    mCurrent = 0;
    mPages.clear();
    mBits.clear();
}
