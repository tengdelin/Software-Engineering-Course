package cool.tdl.Test;

import java.util.List;

class Imglist {
    private int id;

    private int news_id;

    private int food_id;

    private int type;

    private String url;

    private int sort;

    private String create_time;

    private String update_time;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public int getNews_id() {
        return this.news_id;
    }

    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    public int getFood_id() {
        return this.food_id;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return this.type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getSort() {
        return this.sort;
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

    @Override
    public String toString() {
        return "Imglist1{" +
                "id=" + id +
                ", news_id=" + news_id +
                ", food_id=" + food_id +
                ", type=" + type +
                ", url='" + url + '\'' +
                ", sort=" + sort +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}


public class Build {
    private int news_id;

    private int news_category_id;

    private String img;

    private String audio;

    private String longitude;

    private String latitude;

    private String title_en;

    private int cars_num;

    private String fees;

    private String title;

    private int sort;

    private int hits;

    private int is_top;

    private int is_hot;

    private int is_rec;

    private int is_hide;

    private String create_time;

    private String update_time;

    private String intro;

    private String active_img_url;

    private int type;

    private String content;

    private String source_url;

    private String post_time;

    private int article_type;

    private int level;

    private List<Imglist> imglist;

    private String category_name;

    private int is_collect;

    private String img_url;

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public int getNews_category_id() {
        return news_category_id;
    }

    public void setNews_category_id(int news_category_id) {
        this.news_category_id = news_category_id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getTitle_en() {
        return title_en;
    }

    public void setTitle_en(String title_en) {
        this.title_en = title_en;
    }

    public int getCars_num() {
        return cars_num;
    }

    public void setCars_num(int cars_num) {
        this.cars_num = cars_num;
    }

    public String getFees() {
        return fees;
    }

    public void setFees(String fees) {
        this.fees = fees;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getIs_top() {
        return is_top;
    }

    public void setIs_top(int is_top) {
        this.is_top = is_top;
    }

    public int getIs_hot() {
        return is_hot;
    }

    public void setIs_hot(int is_hot) {
        this.is_hot = is_hot;
    }

    public int getIs_rec() {
        return is_rec;
    }

    public void setIs_rec(int is_rec) {
        this.is_rec = is_rec;
    }

    public int getIs_hide() {
        return is_hide;
    }

    public void setIs_hide(int is_hide) {
        this.is_hide = is_hide;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getActive_img_url() {
        return active_img_url;
    }

    public void setActive_img_url(String active_img_url) {
        this.active_img_url = active_img_url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public String getPost_time() {
        return post_time;
    }

    public void setPost_time(String post_time) {
        this.post_time = post_time;
    }

    public int getArticle_type() {
        return article_type;
    }

    public void setArticle_type(int article_type) {
        this.article_type = article_type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<Imglist> getImglist() {
        return imglist;
    }

    public void setImglist1(List<Imglist> imglist) {
        this.imglist = imglist;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getIs_collect() {
        return is_collect;
    }

    public void setIs_collect(int is_collect) {
        this.is_collect = is_collect;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    @Override
    public String toString() {
        return "Build{" +
                "news_id=" + news_id +
                ", news_category_id=" + news_category_id +
                ", img='" + img + '\'' +
                ", audio='" + audio + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", title_en='" + title_en + '\'' +
                ", cars_num=" + cars_num +
                ", fees='" + fees + '\'' +
                ", title='" + title + '\'' +
                ", sort=" + sort +
                ", hits=" + hits +
                ", is_top=" + is_top +
                ", is_hot=" + is_hot +
                ", is_rec=" + is_rec +
                ", is_hide=" + is_hide +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", intro='" + intro + '\'' +
                ", active_img_url='" + active_img_url + '\'' +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", source_url='" + source_url + '\'' +
                ", post_time='" + post_time + '\'' +
                ", article_type=" + article_type +
                ", level=" + level +
                ", imglist1=" + imglist +
                ", category_name='" + category_name + '\'' +
                ", is_collect=" + is_collect +
                ", img_url='" + img_url + '\'' +
                '}';
    }
}
