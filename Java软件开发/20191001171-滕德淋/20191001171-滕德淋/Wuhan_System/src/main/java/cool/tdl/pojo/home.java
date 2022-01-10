package cool.tdl.pojo;

public class home {
    private String fid;
    private String diqu;
    private String name;
    private String SaleStatus;
    private String class1;
    private String greenRate;
    private String prize;
    private String RongjiRate;
    private String point;

    public home(String fid, String diqu, String name, String saleStatus, String class1, String prize,String greenRate, String rongjiRate, String point) {
        this.fid = fid;
        this.diqu = diqu;
        this.name = name;
        SaleStatus = saleStatus;
        this.class1 = class1;
        this.greenRate = greenRate;
        this.prize = prize;
        RongjiRate = rongjiRate;
        this.point = point;
    }

    public home(String fid, String name, String point) {
        this.fid = fid;
        this.name = name;
        this.point = point;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getDiqu() {
        return diqu;
    }

    public void setDiqu(String diqu) {
        this.diqu = diqu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSaleStatus() {
        return SaleStatus;
    }

    public void setSaleStatus(String saleStatus) {
        SaleStatus = saleStatus;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getGreenRate() {
        return greenRate;
    }

    public void setGreenRate(String greenRate) {
        this.greenRate = greenRate;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String getRongjiRate() {
        return RongjiRate;
    }

    public void setRongjiRate(String rongjiRate) {
        RongjiRate = rongjiRate;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
