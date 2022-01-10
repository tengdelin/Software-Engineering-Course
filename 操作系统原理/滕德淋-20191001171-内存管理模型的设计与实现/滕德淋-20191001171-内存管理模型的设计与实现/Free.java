package OS_4.java;

public class Free {
     int address;//起始地址
     int len;//长度

    public Free(int address, int len) {
        this.address = address;
        this.len = len;
    }

    public Free() {
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
