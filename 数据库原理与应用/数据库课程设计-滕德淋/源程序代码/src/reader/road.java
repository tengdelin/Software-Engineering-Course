package reader;

public class road {
    private int fid;
    private String osm_id;
    private String code;
    private String fclass;
    private String name;
    private String bridge;
    private String tunnel;
    private String road;

    public road(int fid, String osm_id, String code, String fclass, String name, String bridge, String tunnel, String road) {
        this.fid = fid;
        this.osm_id = osm_id;
        this.code = code;
        this.fclass = fclass;
        this.name = name;
        this.bridge = bridge;
        this.tunnel = tunnel;
        this.road = road;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getOsm_id() {
        return osm_id;
    }

    public void setOsm_id(String osm_id) {
        this.osm_id = osm_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFclass() {
        return fclass;
    }

    public void setFclass(String fclass) {
        this.fclass = fclass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBridge() {
        return bridge;
    }

    public void setBridge(String bridge) {
        this.bridge = bridge;
    }

    public String getTunnel() {
        return tunnel;
    }

    public void setTunnel(String tunnel) {
        this.tunnel = tunnel;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }
}
