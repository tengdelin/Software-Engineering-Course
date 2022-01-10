#ifndef LFU_PAGING_H
#define LFU_PAGING_H

#include "abstract_paging.h"
#include <set>
#include <QMessageBox>

class OptPaging : public AbstractPaging {
public:

    OptPaging(int pageCount);
    void refer(int page)override;
    const list<int> getList() override;
    void clear() override;

    void refer1(int page,QStringList stringList,int count);

private:
    set<pair<int, int>> mPages;
    list<int> mPages1;
};

#endif // LFU_PAGING_H
