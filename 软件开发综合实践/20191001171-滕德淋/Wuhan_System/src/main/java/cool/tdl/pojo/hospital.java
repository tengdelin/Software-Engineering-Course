package cool.tdl.pojo;

public class hospital {
    private int fid;
    private String name;
    private String minclass;
    private String address;
    private String midclass;
    private String maxclass;
    private String point;

    public hospital(int fid, String name, String minclass, String address, String midclass, String maxclass, String point) {
        this.fid = fid;
        this.name = name;
        this.minclass = minclass;
        this.address = address;
        this.midclass = midclass;
        this.maxclass = maxclass;
        this.point = point;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMinclass() {
        return minclass;
    }

    public void setMinclass(String minclass) {
        this.minclass = minclass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMidclass() {
        return midclass;
    }

    public void setMidclass(String midclass) {
        this.midclass = midclass;
    }

    public String getMaxclass() {
        return maxclass;
    }

    public void setMaxclass(String maxclass) {
        this.maxclass = maxclass;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
