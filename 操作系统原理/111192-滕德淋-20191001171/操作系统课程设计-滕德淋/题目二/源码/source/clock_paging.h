#ifndef CLOCK_PAGING_H
#define CLOCK_PAGING_H

#include "abstract_paging.h"
#include <vector>

class ClockPaging : public AbstractPaging
{
  public:

    ClockPaging(int pageCount);

    void refer(int page) override;

    const list<int> getList() override;

    void clear() override;
    void refer1(int page,QStringList stringList,int count);

  private:

    int mCurrent = 0;

    vector<int> mPages;

    vector<bool> mBits;
};

#endif // CLOCK_PAGING_H
