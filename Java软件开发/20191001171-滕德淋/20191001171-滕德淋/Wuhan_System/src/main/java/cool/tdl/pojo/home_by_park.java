package cool.tdl.pojo;

public class home_by_park {
    private String home_fid;
    private String park_name;
    private String point;

    public home_by_park(String home_fid, String park_name, String point) {
        this.home_fid = home_fid;
        this.park_name = park_name;
        this.point = point;
    }

    public String getHome_fid() {
        return home_fid;
    }

    public void setHome_fid(String home_fid) {
        this.home_fid = home_fid;
    }

    public String getPark_name() {
        return park_name;
    }

    public void setPark_name(String park_name) {
        this.park_name = park_name;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
