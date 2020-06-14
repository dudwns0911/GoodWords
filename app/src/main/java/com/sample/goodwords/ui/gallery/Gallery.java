package com.sample.goodwords.ui.gallery;

import android.graphics.drawable.Drawable;

public class Gallery {
    private Drawable drawable;
    private String information;
    private String translate;

    public Gallery(Drawable drawable,String text){
        this.drawable = drawable;
        this.information = text;

    }
    public Gallery(Drawable drawable,String text,String translate){
        this.drawable = drawable;
        this.information = text;
        this.translate = translate;

    }

    public Drawable getDrawable() {
        return drawable;
    }

    public String getInformation() {
        return information;
    }

    public String getTranslate(){
        return translate;
    }
}
