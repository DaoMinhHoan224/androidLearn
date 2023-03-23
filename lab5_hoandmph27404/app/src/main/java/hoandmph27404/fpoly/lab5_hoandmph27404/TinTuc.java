package hoandmph27404.fpoly.lab5_hoandmph27404;

public class TinTuc {
    String title;
    String description;
    String comment;
    String link;
    String date;


    public TinTuc() {
    }

    public TinTuc(String title, String description, String comment, String link, String date) {
        this.title = title;
        this.description = description;
        this.comment = comment;
        this.link = link;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
