package cool.tdl.pojo;

public class home_by_hospital {
    private String home_fid;
    private String hospital_name;
    private String point;

    public home_by_hospital(String home_fid, String hospital_name, String point) {
        this.home_fid = home_fid;
        this.hospital_name = hospital_name;
        this.point = point;
    }

    public String getHome_fid() {
        return home_fid;
    }

    public void setHome_fid(String home_fid) {
        this.home_fid = home_fid;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
