package cool.tdl.pojo;

public class icon {
    private String userfid;
    private String iconname;

    public icon(String userfid, String iconname) {
        this.userfid = userfid;
        this.iconname = iconname;
    }

    public String getUserfid() {
        return userfid;
    }

    public void setUserfid(String userfid) {
        this.userfid = userfid;
    }

    public String getIconname() {
        return iconname;
    }

    public void setIconname(String iconname) {
        this.iconname = iconname;
    }
}
