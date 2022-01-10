package cool.tdl.pojo;

public class wuhan_project {
    private int fid;
    private String name;
    private String Uid;
    private String CityName;
    private String Polygon;

    public wuhan_project(int fid, String name, String uid, String cityName, String polygon) {
        this.fid = fid;
        this.name = name;
        Uid = uid;
        CityName = cityName;
        Polygon = polygon;
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

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

    public String getCityName() {
        return CityName;
    }

    public void setCityName(String cityName) {
        CityName = cityName;
    }

    public String getPolygon() {
        return Polygon;
    }

    public void setPolygon(String polygon) {
        Polygon = polygon;
    }
}
