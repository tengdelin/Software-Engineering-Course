package reader;

public class wh_xz {
    private int fid;
    private int id;
    private String country;
    private String name;
    private String enname;
    private String locname;
    private String offname;
    private String boundary;
    private String adminlevel;
    private String wikidata;
    private String wikimedia;
    private String timestamp;
    private String note;
    private String rpath;
    private String Polygon;

    public wh_xz(int fid, int id, String country, String name, String enname, String locname, String offname, String boundary, String adminlevel, String wikidata, String wikimedia, String timestamp, String note, String rpath, String polygon) {
        this.fid = fid;
        this.id = id;
        this.country = country;
        this.name = name;
        this.enname = enname;
        this.locname = locname;
        this.offname = offname;
        this.boundary = boundary;
        this.adminlevel = adminlevel;
        this.wikidata = wikidata;
        this.wikimedia = wikimedia;
        this.timestamp = timestamp;
        this.note = note;
        this.rpath = rpath;
        Polygon = polygon;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }

    public String getLocname() {
        return locname;
    }

    public void setLocname(String locname) {
        this.locname = locname;
    }

    public String getOffname() {
        return offname;
    }

    public void setOffname(String offname) {
        this.offname = offname;
    }

    public String getBoundary() {
        return boundary;
    }

    public void setBoundary(String boundary) {
        this.boundary = boundary;
    }

    public String getAdminlevel() {
        return adminlevel;
    }

    public void setAdminlevel(String adminlevel) {
        this.adminlevel = adminlevel;
    }

    public String getWikidata() {
        return wikidata;
    }

    public void setWikidata(String wikidata) {
        this.wikidata = wikidata;
    }

    public String getWikimedia() {
        return wikimedia;
    }

    public void setWikimedia(String wikimedia) {
        this.wikimedia = wikimedia;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRpath() {
        return rpath;
    }

    public void setRpath(String rpath) {
        this.rpath = rpath;
    }

    public String getPolygon() {
        return Polygon;
    }

    public void setPolygon(String polygon) {
        Polygon = polygon;
    }
}
