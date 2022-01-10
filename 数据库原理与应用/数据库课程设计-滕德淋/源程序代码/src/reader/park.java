package reader;

public class park {
    private int fid;
    private String name;
    private String maxclass;
    private String midclass;
    private String minclass;
    private String address;
    private String sheng;
    private String shi;
    private String qu;
    private String point;

    public park(int fid, String name, String maxclass, String midclass, String minclass, String address, String sheng, String shi, String qu, String point) {
        this.fid = fid;
        this.name = name;
        this.maxclass = maxclass;
        this.midclass = midclass;
        this.minclass = minclass;
        this.address = address;
        this.sheng = sheng;
        this.shi = shi;
        this.qu = qu;
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

    public String getMaxclass() {
        return maxclass;
    }

    public void setMaxclass(String maxclass) {
        this.maxclass = maxclass;
    }

    public String getMidclass() {
        return midclass;
    }

    public void setMidclass(String midclass) {
        this.midclass = midclass;
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

    public String getSheng() {
        return sheng;
    }

    public void setSheng(String sheng) {
        this.sheng = sheng;
    }

    public String getShi() {
        return shi;
    }

    public void setShi(String shi) {
        this.shi = shi;
    }

    public String getQu() {
        return qu;
    }

    public void setQu(String qu) {
        this.qu = qu;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
