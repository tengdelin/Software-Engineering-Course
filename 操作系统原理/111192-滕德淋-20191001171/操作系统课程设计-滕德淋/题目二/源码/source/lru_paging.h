#ifndef LRU_PAGING_H
#define LRU_PAGING_H

#include "abstract_paging.h"

class LruPaging : public AbstractPaging {
  public:

    LruPaging(int pageCount);

    void refer(int page) override;

    const list<int> getList() override;

    void clear() override;
    void refer1(int page,QStringList stringList,int count);

  private:

    list<int> mPages;
};

#endif // LRU_PAGING_H
