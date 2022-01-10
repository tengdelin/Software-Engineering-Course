package OS_4.java;

public class test {
    public static void main(String[] args) {
        Partition pa = new Partition();
        pa.requierMemo("A", 20);
        pa.requierMemo("B", 16);
        pa.requierMemo("C", 64);
        pa.requierMemo("D", 124);
        pa.printLink();
        pa.freeMemo("C");
        pa.printLink();
        pa.requierMemo("E", 50);
        pa.printLink();
        pa.freeMemo("D");
        pa.printLink();

    }
}
