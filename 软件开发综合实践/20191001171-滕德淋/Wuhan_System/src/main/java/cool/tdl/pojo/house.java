package cool.tdl.pojo;

public class house {
    private int fid;
    private String huxin;
    private int totalprize;
    private int avgprize;
    private int allarea;
    private String innerarea;
    private String chaoxiang;
    private String name;
    private String floor;
    private String allfloor;
    private String year;
    private String neixin;

    public house(int fid, String huxin, int totalprize, int avgprize, int allarea, String innerarea, String chaoxiang, String name, String floor, String allfloor, String year, String neixin) {
        this.fid = fid;
        this.huxin = huxin;
        this.totalprize = totalprize;
        this.avgprize = avgprize;
        this.allarea = allarea;
        this.innerarea = innerarea;
        this.chaoxiang = chaoxiang;
        this.name = name;
        this.floor = floor;
        this.allfloor = allfloor;
        this.year = year;
        this.neixin = neixin;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getHuxin() {
        return huxin;
    }

    public void setHuxin(String huxin) {
        this.huxin = huxin;
    }

    public int getTotalprize() {
        return totalprize;
    }

    public void setTotalprize(int totalprize) {
        this.totalprize = totalprize;
    }

    public int getAvgprize() {
        return avgprize;
    }

    public void setAvgprize(int avgprize) {
        this.avgprize = avgprize;
    }

    public int getAllarea() {
        return allarea;
    }

    public void setAllarea(int allarea) {
        this.allarea = allarea;
    }

    public String getInnerarea() {
        return innerarea;
    }

    public void setInnerarea(String innerarea) {
        this.innerarea = innerarea;
    }

    public String getChaoxiang() {
        return chaoxiang;
    }

    public void setChaoxiang(String chaoxiang) {
        this.chaoxiang = chaoxiang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getAllfloor() {
        return allfloor;
    }

    public void setAllfloor(String allfloor) {
        this.allfloor = allfloor;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNeixin() {
        return neixin;
    }

    public void setNeixin(String neixin) {
        this.neixin = neixin;
    }
}
