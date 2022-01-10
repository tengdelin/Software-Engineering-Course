#include "opt_paging.h"
#include <algorithm>

//参数构造函数
OptPaging::OptPaging(int pageCount) : AbstractPaging(pageCount) {}

// 页传送
void OptPaging::refer(int page)
{
    auto duplicate =find_if(mPages.begin(), mPages.end(),[&page](auto pair)
    {
        return pair.second == page;//找到第一个等于page的进程
    }
    );

    if (duplicate == mPages.end())//没找到进程，发生缺页中断
    {
        mPageFault++;
        if ((long)mPages.size() == (long)mPageCount)
        {
            mPages.erase(*mPages.begin());
        }
        mPages.insert({0, page});
    }
    else
    {
        int t = duplicate->first;
        mPages.erase(duplicate);
        mPages.insert({t + 1, page});
    }
}

void OptPaging:: refer1(int page,QStringList stringList,int count)
{
    //该函数会返回一个输入迭代器，
    //当 find() 函数查找成功时，其指向的是在 [first, last) 区域内查找到的第一个目标元素；
    //如果查找失败，则该迭代器的指向和 last 相同。
    if (find(mPages1.begin(), mPages1.end(), page) == mPages1.end())//在内存中找是否有page这个进程,发生缺页中断则进分支
    {
        ++mPageFault;//中断加1
        int num=mPages1.front();
        if ((long)mPages1.size() == (long)mPageCount)//发生页面置换
        {
           //查找当前内存中的页出现在stringlist中的最晚的值，用来替换掉page；
            for(int i=count+1;i<stringList.length();i++){
               if(find(mPages1.begin(), mPages1.end(), stringList[i])!=mPages1.end()){
                   num=stringList[i].toInt();
               }
            }
            mPages1.remove(num);
            mPages1.push_back(page);
        }
    }
}

// 获取页面列表
const list<int> OptPaging::getList() {
    std::list<int> list;
    for (auto &pair : mPages) {
        list.emplace_back(pair.second);
    }
    return list;
     //return mPages1;
}

// 数据清理，恢复原状
void OptPaging::clear() {
    mPageFault = 0;
    mPages.clear();
    mPages1.clear();
}
