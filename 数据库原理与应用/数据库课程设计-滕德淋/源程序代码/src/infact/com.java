package infact;

public class com {
    private int fid;
    private String commend;
    private int parent_fid;
    private int house_fid;

    public com(int fid, String commend, int parent_fid, int house_fid) {
        this.fid = fid;
        this.commend = commend;
        this.parent_fid = parent_fid;
        this.house_fid = house_fid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getCommend() {
        return commend;
    }

    public void setCommend(String commend) {
        this.commend = commend;
    }

    public int getParent_fid() {
        return parent_fid;
    }

    public void setParent_fid(int parent_fid) {
        this.parent_fid = parent_fid;
    }

    public int getHouse_fid() {
        return house_fid;
    }

    public void setHouse_fid(int house_fid) {
        this.house_fid = house_fid;
    }
}
