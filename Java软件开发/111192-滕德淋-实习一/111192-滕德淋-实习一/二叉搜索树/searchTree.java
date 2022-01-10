public class searchTree<Key extends Comparable<Key>, Value> {

    //根节点
    private Node root;
    //结点数
    private int N;

    //节点
    private class Node {
        //成员变量
        public Key key;
        public Value value;
        Node left;//左子树
        Node right;//右子树
        //构造函数
        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //API
    //返回数的节点数
    public int size() {
        return N;
    }

    //插入节点
    public void insert(Key key, Value value) {
        root = insert(root, key, value);
    }
    public Node insert(Node x, Key key, Value value) {
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }
        //与当前节点比较，如果大就插入右子树，
        // 小就插入左子树，
        // 如果相等，就将当前节点的value值重新赋值；
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = insert(x.right, key, value);
        } else if (cmp < 0) {
            x.left = insert(x.left, key, value);
        } else {
            x.value = value;
        }
        return x;
    }

    //获取节点
    public Value visit(Key key) {
        return visit(root, key);
    }
    public Value visit(Node x, Key key) {
        //没找到
        if (x == null) {
            return null;
        }
        //向下查找，如果找到相等的就返回值
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            return visit(x.right, key);
        } else if (cmp < 0) {
            return visit(x.left, key);
        } else {
            return x.value;
        }
    }

    //删除节点
    public void delete(Key key) {
        delete(root, key);
    }
    public Node delete(Node x, Key key) {
        //没找到
        if (x == null) {
            return null;
        }
        //向下递归找
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            x.left = delete(x.left, key);
        } else {//找到了之后，进行删除操作
            N--;
            //删除节点的右子树为空
            if (x.right == null) {
                return x.left;
            }
            //删除节点的左子树为空
            if (x.left == null) {
                return x.right;
            }
            //找到最小节点
            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            //断开有子树中最小节点与上一个节点的连接
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                } else {
                    n = n.left;
                }
            }
            //将右子树中的最小节点作为当前节点，表示删除了当前节点
            minNode.left = x.left;
            minNode.right = x.right;
            x = minNode;
        }
        return x;
    }
}

