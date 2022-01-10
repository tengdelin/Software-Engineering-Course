package cool.tdl.pojo;

public class Something {
    private String name;
    private String code;
    private String longitude;
    private String latitude;
    private String count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getCount() {
        return count;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public Something(String name,String code,String longitude,String latitude,String count){
        this.code=code;
        this.count=count;
        this.latitude=latitude;
        this.longitude=longitude;
        this.name=name;

    }
}

