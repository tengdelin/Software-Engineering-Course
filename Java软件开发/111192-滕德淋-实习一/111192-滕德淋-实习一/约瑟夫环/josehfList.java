public class josehfList {
    public static void main(String[] args) {
        int N = 41;
        int C = 3;

        //1、建立循环链表
        Node<Integer> first = null;
        Node<Integer> pre = null;
        for (int i = 1; i <= N; i++) {
            //首节点
            if (i == 1) {
                Node<Integer> node = new Node<Integer>(i, null, "player"+i);
                first = node;
                pre = node;
                continue;
            }
            //不是首节点
            Node<Integer> node = new Node<Integer>(i, null,"player"+i);
            pre.next = node;
            pre = node;
            //尾结点
            if (i == N) {
                pre.next = first;
            }
        }
        //2、模拟报数
        int count = 0;
        //3、进行报数
        Node<Integer> n = first;
        Node<Integer> before = null;
        System.out.println("姓名\t\t报数次序");
        while (n != n.next) {
            count++;
            if (count == C) {
                before.next = n.next;
                System.out.println(n.name+":\t"+n.item );
                n = n.next;
                count = 0;
            } else {
                before = n;
                n = n.next;
            }
        }
        System.out.println(n.name+":\t"+n.item);
    }

    //节点类
    private static class Node<T> {
        T item;
        Node next;
        String name;
        public Node(T item, Node next, String name) {
            this.item = item;
            this.next = next;
            this.name = name;
        }
    }
}
