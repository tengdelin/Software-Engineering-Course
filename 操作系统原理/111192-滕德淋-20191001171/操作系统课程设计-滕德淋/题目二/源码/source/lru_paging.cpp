#include "lru_paging.h"
#include <algorithm>

//
LruPaging::LruPaging(int pageCount) : AbstractPaging(pageCount) {}

//
void LruPaging::refer(int page)
{
    auto duplicate = find(mPages.begin(), mPages.end(), page);
    if (duplicate == mPages.end())
    {
        ++mPageFault;
        if ((long)mPages.size() == (long)mPageCount)
        {
            mPages.pop_front();
        }
        mPages.emplace_back(page);
    }
    else
    {
        //更新最近使用
        mPages.remove(page);
        mPages.emplace_back(page);
    }
}
void LruPaging:: refer1(int page,QStringList stringList,int count)
{

}
//
const std::list<int> LruPaging::getList() { return mPages; }

//
void LruPaging::clear() {
    mPageFault = 0;
    mPages.clear();
}
