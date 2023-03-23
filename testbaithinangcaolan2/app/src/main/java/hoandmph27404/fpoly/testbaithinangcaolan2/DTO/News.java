package hoandmph27404.fpoly.testbaithinangcaolan2.DTO;

public class News {
    String maTT;
    String title;
    String link;

    public News(String maTT, String title, String link) {
        this.maTT = maTT;
        this.title = title;
        this.link = link;
    }

    public News() {
    }

    public String getMaTT() {
        return maTT;
    }

    public void setMaTT(String maTT) {
        this.maTT = maTT;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
