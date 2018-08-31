package com.nsh.getintoclub.model;

import android.graphics.drawable.Drawable;

/**
 * Created by ThisIsNSH on 9/1/2018.
 */

public class Quote {

    String quote, title, detail;
    Drawable drawable;

    public Quote(String quote, Drawable drawable, String title, String detail) {
        this.drawable = drawable;
        this.detail = detail;
        this.title = title;
        this.quote = quote;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public String getQuote() {
        return quote;
    }

}
