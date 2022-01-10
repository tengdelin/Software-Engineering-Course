import org.w3c.dom.Node;

public class treeTest {
    public static void main(String[] args) {
        searchTree<Integer,String> s = new searchTree<>();
        System.out.println("1、测试insert():");
        s.insert(1,"张三");
        s.insert(2,"李四");
        s.insert(3,"王五");
        s.insert(4,"赵六");
        s.insert(5,"刘七");
        System.out.println("插入了"+s.size()+"个数据！");
        System.out.println("2、测试visit():");
        System.out.println("key为2的名字叫做："+s.visit(2));
        System.out.println("3、测试delete():");
        System.out.println("删除key为2的数据");
        s.delete(2);
        System.out.println("删除之后树的所有数据为：");
        for (int i=1;i<=s.size();i++){
            System.out.println(s.visit(i));
        }
    }
}
