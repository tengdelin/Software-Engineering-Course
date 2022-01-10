package cool.tdl.pojo;

public class home_by_shop {
    private String home_fid;
    private String shop_name;
    private String point;

    public home_by_shop(String home_fid, String shop_name, String point) {
        this.home_fid = home_fid;
        this.shop_name = shop_name;
        this.point = point;
    }

    public String getHome_fid() {
        return home_fid;
    }

    public void setHome_fid(String home_fid) {
        this.home_fid = home_fid;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
