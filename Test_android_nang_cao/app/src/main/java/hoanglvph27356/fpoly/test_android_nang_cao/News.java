package hoanglvph27356.fpoly.test_android_nang_cao;

public class News {

    int id_news;
    String title;
    String pubDate;
    String link;
    String commemt;


    public static final String TB_NAME = "tb_news";
    public static final String COL_ID = "id_news";
    public static final String COL_TITLE = "title";
    public static final String COL_PUBDATE = "pubDate";
    public static final String COL_LINK = "link";
    public static final String COL_COMMENT = "commemt";



    public int getId_news() {
        return id_news;
    }

    public void setId_news(int id_news) {
        this.id_news = id_news;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCommemt() {
        return commemt;
    }

    public void setCommemt(String commemt) {
        this.commemt = commemt;
    }
}
