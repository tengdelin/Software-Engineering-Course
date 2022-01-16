public class pojo {
    private int id;

    private String title;

    private int uid;

    private String ftr_name;

    private String ftr_phone;

    private String ftr_xuehao;

    private String lxdz;

    private int type_id;

    private int item_id;

    private int event_time;

    private String event_address;

    private String img;

    private String content;

    private String reply_content;

    private int reply_uid;

    private int zh_uid;

    private int sj_uid;

    private int sj_user_levle_id;

    private String create_time;

    private int reply_time;

    private int status;

    private int is_show;

    private int is_index;

    private int delete_time;

    private String type_name;

    private String item_name;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setUid(int uid){
        this.uid = uid;
    }
    public int getUid(){
        return this.uid;
    }
    public void setFtr_name(String ftr_name){
        this.ftr_name = ftr_name;
    }
    public String getFtr_name(){
        return this.ftr_name;
    }
    public void setFtr_phone(String ftr_phone){
        this.ftr_phone = ftr_phone;
    }
    public String getFtr_phone(){
        return this.ftr_phone;
    }
    public void setFtr_xuehao(String ftr_xuehao){
        this.ftr_xuehao = ftr_xuehao;
    }
    public String getFtr_xuehao(){
        return this.ftr_xuehao;
    }
    public void setLxdz(String lxdz){
        this.lxdz = lxdz;
    }
    public String getLxdz(){
        return this.lxdz;
    }
    public void setType_id(int type_id){
        this.type_id = type_id;
    }
    public int getType_id(){
        return this.type_id;
    }
    public void setItem_id(int item_id){
        this.item_id = item_id;
    }
    public int getItem_id(){
        return this.item_id;
    }
    public void setEvent_time(int event_time){
        this.event_time = event_time;
    }
    public int getEvent_time(){
        return this.event_time;
    }
    public void setEvent_address(String event_address){
        this.event_address = event_address;
    }
    public String getEvent_address(){
        return this.event_address;
    }
    public void setImg(String img){
        this.img = img;
    }
    public String getImg(){
        return this.img;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getContent(){
        return this.content;
    }
    public void setReply_content(String reply_content){
        this.reply_content = reply_content;
    }
    public String getReply_content(){
        return this.reply_content;
    }
    public void setReply_uid(int reply_uid){
        this.reply_uid = reply_uid;
    }
    public int getReply_uid(){
        return this.reply_uid;
    }
    public void setZh_uid(int zh_uid){
        this.zh_uid = zh_uid;
    }
    public int getZh_uid(){
        return this.zh_uid;
    }
    public void setSj_uid(int sj_uid){
        this.sj_uid = sj_uid;
    }
    public int getSj_uid(){
        return this.sj_uid;
    }
    public void setSj_user_levle_id(int sj_user_levle_id){
        this.sj_user_levle_id = sj_user_levle_id;
    }
    public int getSj_user_levle_id(){
        return this.sj_user_levle_id;
    }
    public void setCreate_time(String create_time){
        this.create_time = create_time;
    }
    public String getCreate_time(){
        return this.create_time;
    }
    public void setReply_time(int reply_time){
        this.reply_time = reply_time;
    }
    public int getReply_time(){
        return this.reply_time;
    }
    public void setStatus(int status){
        this.status = status;
    }
    public int getStatus(){
        return this.status;
    }
    public void setIs_show(int is_show){
        this.is_show = is_show;
    }
    public int getIs_show(){
        return this.is_show;
    }
    public void setIs_index(int is_index){
        this.is_index = is_index;
    }
    public int getIs_index(){
        return this.is_index;
    }
    public void setDelete_time(int delete_time){
        this.delete_time = delete_time;
    }
    public int getDelete_time(){
        return this.delete_time;
    }
    public void setType_name(String type_name){
        this.type_name = type_name;
    }
    public String getType_name(){
        return this.type_name;
    }
    public void setItem_name(String item_name){
        this.item_name = item_name;
    }
    public String getItem_name(){
        return this.item_name;
    }

    @Override
    public String toString() {
        return "pojo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", uid=" + uid +
                ", ftr_name='" + ftr_name + '\'' +
                ", ftr_phone='" + ftr_phone + '\'' +
                ", ftr_xuehao='" + ftr_xuehao + '\'' +
                ", lxdz='" + lxdz + '\'' +
                ", type_id=" + type_id +
                ", item_id=" + item_id +
                ", event_time=" + event_time +
                ", event_address='" + event_address + '\'' +
                ", img='" + img + '\'' +
                ", content='" + content + '\'' +
                ", reply_content='" + reply_content + '\'' +
                ", reply_uid=" + reply_uid +
                ", zh_uid=" + zh_uid +
                ", sj_uid=" + sj_uid +
                ", sj_user_levle_id=" + sj_user_levle_id +
                ", create_time='" + create_time + '\'' +
                ", reply_time=" + reply_time +
                ", status=" + status +
                ", is_show=" + is_show +
                ", is_index=" + is_index +
                ", delete_time=" + delete_time +
                ", type_name='" + type_name + '\'' +
                ", item_name='" + item_name + '\'' +
                '}';
    }
}
