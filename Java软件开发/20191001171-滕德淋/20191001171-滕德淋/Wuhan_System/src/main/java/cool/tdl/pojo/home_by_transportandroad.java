package cool.tdl.pojo;

public class home_by_transportandroad {

    private String home_fid;
    private String transportandroad_name;
    private String point;

    public home_by_transportandroad(String home_fid, String transportandroad_name, String point) {
        this.home_fid = home_fid;
        this.transportandroad_name = transportandroad_name;
        this.point = point;
    }

    public String getHome_fid() {
        return home_fid;
    }

    public void setHome_fid(String home_fid) {
        this.home_fid = home_fid;
    }

    public String getTransportandroad_name() {
        return transportandroad_name;
    }

    public void setTransportandroad_name(String transportandroad_name) {
        this.transportandroad_name = transportandroad_name;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
