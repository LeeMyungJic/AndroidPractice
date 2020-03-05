package com.example.movie;

import android.graphics.drawable.Drawable;

public class ListViewItem {
    private Drawable icon;
    private String title;

    public void setIcon(Drawable icon) {
        icon = this.icon;
    }
    public void setTitle(String str) {
        str = this.title;
    }

    public Drawable getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }
}
