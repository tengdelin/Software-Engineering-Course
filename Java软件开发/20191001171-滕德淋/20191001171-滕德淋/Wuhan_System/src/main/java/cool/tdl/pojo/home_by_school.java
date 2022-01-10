package cool.tdl.pojo;

public class home_by_school {
    private String home_fid;
    private String school_name;
    private String point;

    public home_by_school(String home_fid, String school_name, String point) {
        this.home_fid = home_fid;
        this.school_name = school_name;
        this.point = point;
    }

    public String getHome_fid() {
        return home_fid;
    }

    public void setHome_fid(String home_fid) {
        this.home_fid = home_fid;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
