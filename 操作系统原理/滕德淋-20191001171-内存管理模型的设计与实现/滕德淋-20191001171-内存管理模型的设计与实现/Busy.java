package OS_4.java;

public class Busy {
     String name;//进程名
     int address;//起始地址
     int len;//长度

    public Busy(String name, int address, int len) {
        this.name = name;
        this.address = address;
        this.len = len;
    }

    public Busy() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }
}
