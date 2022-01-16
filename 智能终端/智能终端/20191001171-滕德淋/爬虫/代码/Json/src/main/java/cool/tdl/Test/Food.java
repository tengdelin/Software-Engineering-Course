package cool.tdl.Test;


public class Food {
    private int food_id;

    private int category_id;

    private String img_url;

    private String longitude;

    private String latitude;

    private String title;

    private String address;

    private int score;

    private int sort;

    private int hits;

    private int is_top;

    private int is_hot;

    private int is_rec;

    private int is_hide;

    private String create_time;

    private String update_time;

    private String intro;

    private String tags;

    private String category_name;

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public int getFood_id() {
        return this.food_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getCategory_id() {
        return this.category_id;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getImg_url() {
        return this.img_url;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return this.address;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getSort() {
        return this.sort;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getHits() {
        return this.hits;
    }

    public void setIs_top(int is_top) {
        this.is_top = is_top;
    }

    public int getIs_top() {
        return this.is_top;
    }

    public void setIs_hot(int is_hot) {
        this.is_hot = is_hot;
    }

    public int getIs_hot() {
        return this.is_hot;
    }

    public void setIs_rec(int is_rec) {
        this.is_rec = is_rec;
    }

    public int getIs_rec() {
        return this.is_rec;
    }

    public void setIs_hide(int is_hide) {
        this.is_hide = is_hide;
    }

    public int getIs_hide() {
        return this.is_hide;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getCreate_time() {
        return this.create_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getUpdate_time() {
        return this.update_time;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getIntro() {
        return this.intro;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getTags() {
        return this.tags;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_name() {
        return this.category_name;
    }

    @Override
    public String toString() {
        return "Food{" +
                "food_id=" + food_id +
                ", category_id=" + category_id +
                ", img_url='" + img_url + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", title='" + title + '\'' +
                ", address='" + address + '\'' +
                ", score=" + score +
                ", sort=" + sort +
                ", hits=" + hits +
                ", is_top=" + is_top +
                ", is_hot=" + is_hot +
                ", is_rec=" + is_rec +
                ", is_hide=" + is_hide +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", intro='" + intro + '\'' +
                ", tags='" + tags + '\'' +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
