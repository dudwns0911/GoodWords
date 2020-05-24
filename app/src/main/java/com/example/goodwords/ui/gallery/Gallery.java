package com.example.goodwords.ui.gallery;

import android.graphics.drawable.Drawable;

public class Gallery {
    private Drawable drawable;
    private String information;

    public Gallery(Drawable drawable,String text){
        this.drawable = drawable;
        this.information = text;

    }

    public Drawable getDrawable() {
        return drawable;
    }

    public String getInformation() {
        return information;
    }
}
