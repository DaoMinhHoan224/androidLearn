package vn.edu.spx.loadrss315;

public class TinTuc {
    String title;
    String description;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

// 1 tin tức sẽ có các thuộc tính
//<item>
//<title>Màn đấu võ uyển chuyển như múa</title>
//<description><![CDATA[<a href="https://vnexpress.net/man-dau-vo-uyen-chuyen-nhu-mua-4518948.html"><img src="https://i1-vnexpress.vnecdn.net/2022/10/04/-7313-1664852307.gif?w=1200&h=0&q=100&dpr=1&fit=crop&s=d7u8soRh1NI0Bt2tJnWZAw&t=image" ></a></br>Hai chàng trai bắt chước màn đấu võ trong game Street Fighter khiến người xem không nhịn được cười.]]></description>
//<pubDate>Tue, 04 Oct 2022 22:00:00 +0700</pubDate>
//<link>https://vnexpress.net/man-dau-vo-uyen-chuyen-nhu-mua-4518948.html</link>
//<guid>https://vnexpress.net/man-dau-vo-uyen-chuyen-nhu-mua-4518948.html</guid>
//<slash:comments>0</slash:comments>
//</item>