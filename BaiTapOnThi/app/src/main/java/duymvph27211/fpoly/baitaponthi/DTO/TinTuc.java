package duymvph27211.fpoly.baitaponthi.DTO;

public class TinTuc {
    String maTT;
    String title;
    String link;

    public TinTuc() {
    }

    public TinTuc(String maTT, String title, String link) {
        this.maTT = maTT;
        this.title = title;
        this.link = link;
    }

    public TinTuc(String title, String link) {
        this.title = title;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMaTT() {
        return maTT;
    }

    public void setMaTT(String maTT) {
        this.maTT = maTT;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
