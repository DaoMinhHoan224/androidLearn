package com.example.baitestgiaodienandroid.object;

public class User {
     int id;
     String content;
     String dataTime;

    public User(String content, String dataTime) {
        this.content = content;
        this.dataTime = dataTime;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public static final String COL_NAME="test_thithu";
    public static final String COL_NAME_ID="id";
    public static final String COL_NAME_CONTENT="content";
    public static final String COL_NAME_DATETIME="datatime";
}
