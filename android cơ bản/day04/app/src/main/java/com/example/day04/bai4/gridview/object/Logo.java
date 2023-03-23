package com.example.day04.bai4.gridview.object;

import android.widget.ImageView;
import android.widget.TextView;

public class Logo {
    private int image_id;
    private String tv_namelogo;

    public Logo(int image_id, String tv_namelogo) {
        this.image_id = image_id;
        this.tv_namelogo = tv_namelogo;
    }

    public Logo() {
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getTv_namelogo() {
        return tv_namelogo;
    }

    public void setTv_namelogo(String tv_namelogo) {
        this.tv_namelogo = tv_namelogo;
    }
}
