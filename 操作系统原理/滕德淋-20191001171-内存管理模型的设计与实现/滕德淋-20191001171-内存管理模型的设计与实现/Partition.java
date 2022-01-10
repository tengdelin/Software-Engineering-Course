
package OS_4.java;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Partition {
    LinkedList<Free> freeLink;//空闲区队列
    LinkedList<Busy> busyLink;//已分配区队列
    Free free;
    Busy busy;

    public Partition() {
        super();
        start();
    }
    void start() {
        freeLink=new LinkedList<Free>();
        busyLink=new LinkedList<Busy>();

        Busy os=new Busy("OS",0,64);//系统占用区64K
        busyLink.add(os);//加入已分配队列
        free=new Free(64,300);//初始的内存空闲区就一块，大小300K，首地址64K
        freeLink.add(free);//加入空闲区队列
    }
    void requierMemo(String name,int require) {//模拟内存分配
        if(require<=freeLink.get(0).len) {//可划分内存给所请求分配的大小
            int address=freeLink.get(0).address;//获得该最大空闲区的首地址，从这开始分配require长度内存
            freeLink.get(0).address=address+require;//更新该空闲区的首地址
            freeLink.get(0).len=freeLink.get(0).len-require;//更新该空闲区的长度
            busy=new Busy(name, address, require);//生成分配区间
            busyLink.add(busy);//将该分区分配给请求者,加入已分配队列
            Collections.sort(freeLink, new compatorFree());//因为原来最大的空闲区被划分走一块后可能不是最大了，必须重新排序
            System.out.println("为"+busy.name+"分配内存成功！");
        }
        else
            System.out.println("当前无法找到足够内存分配，请求失败，请等待！");
    }
    void freeMemo(String name) {//模拟内存回收
        Busy recycle=new Busy();//暂时存放要回收的内存的信息
		/*如果该回收区分别与上下两块空闲区邻接（第三种情况），下面算法必会先会依次执行一二两种情况，导致回收区被重复计算，要消除该影响
		就得先记录下这两块已经完成操作的空闲区间位置，再把这两块合并即可（因为两者有重叠区域）*/
        int freeUp=-1;//记录上面相邻接块的位置，-1代表不邻接
        int freeDown=-1;//记录下面相邻接块的位置，-1代表不邻接
        for(int i=0;i<busyLink.size();++i) {
            busy=busyLink.get(i);
            if(busy.name==name) {
                recycle=busy;//先找到要回收的内存,保留信息
                busyLink.remove(recycle);//如果用了迭代器，必须用它的方法增删改查，容器的方法会失效
            }
        }
//		for(ListIterator<Free> iter=freeLink.listIterator();iter.hasNext();){//迭代器效率O(1)远高于随机访问O(N^2)
        for(int i=0;i<freeLink.size();++i) {
            free=freeLink.get(i);//获得链表中指针指向的对象
            /*第一种情况回收区与上面一个空闲区间相邻接*/
            if(recycle.address==(free.address+free.len)) {
                freeUp=freeLink.indexOf(free);//记录下该空闲区间的位置
                free.len=free.len+recycle.len;//更新该空闲区间长度
                freeLink.set(freeUp, free);
            }
            /*第二情况回收区与下面一个空闲区间相邻接*/
            if((recycle.address+recycle.len)==free.address) {
                freeDown=freeLink.indexOf(free);//记录下该空闲区间的位置
                free.address=recycle.address;//更新该空闲区间首地址
                free.len=recycle.len+free.len;//更新该空闲区间长度
                freeLink.set(freeDown, free);
            }
            /*第三情况回收区分别与上下面空闲区间相邻接*/
            if(freeUp!=-1&&freeDown!=-1) {
                Free freeUpObj=freeLink.get(freeUp);
                Free freeDownObj=freeLink.get(freeDown);
				/*不用多此一举，前面已经决定了freeUp的首地址必然小于freeDown的首地址
				if(freeUpObj.address<freeDownObj.address) {//确保低地址在前，高地址在后
					Free temp;
					temp=freeUpObj;freeDownObj=freeUpObj;freeUpObj=temp;
				}*/
                freeUpObj.len=freeUpObj.len+freeDownObj.len-recycle.len;//更新两块合并后的长度
                freeLink.set(freeUp, freeUpObj);//修改链表中三块合一后的最终空闲块
                freeLink.remove(freeDown);//下面这块已经被上面那块合并，把它从链表中删除
            }
        }
        /*第四情况回收区与空闲区间不相邻接(注意：这情况不能放在上面的for循环内，否则会造成队列不断变大，死循环)*/
        if(freeUp==-1&&freeDown==-1) {
            Free addFree=new Free(recycle.address, recycle.len);
            freeLink.addLast(addFree);
        }
        System.out.println("回收"+recycle.name+"的内存成功！");
        Collections.sort(freeLink,new compatorFree());//长度改变需要重排
    }

    void printLink() {//输出内存情况
        System.out.println("********************************");
        System.out.println("内存已分配区间情况：");
        for(Iterator<Busy> iter=busyLink.iterator();iter.hasNext();) {
            busy=(Busy)iter.next();
            System.out.print(busy.name+":"+busy.address+"~"+(busy.address+busy.len)+"  ");
        }
        System.out.println('\n'+"内存空闲区间信息，按从大到小排列：");
        for(Iterator<Free> iter=freeLink.iterator();iter.hasNext();){//迭代器效率O(1)远高于随机访问O(N^2)
            free=(Free)iter.next();//获得链表中下一个元素
            System.out.print(free.address+"~"+(free.address+free.len)+"  ");//空闲区间
        }
        System.out.println('\n'+"********************************");
    }

}
class compatorFree  implements Comparator<Free>{//按空闲区间从大到小排列

    @Override
    public int compare(Free o1, Free o2) {
        return o1.len<o2.len?1:-1;
    }

}
