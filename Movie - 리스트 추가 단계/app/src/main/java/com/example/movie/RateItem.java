package com.example.movie;

import java.io.Serializable;

public class RateItem implements Serializable {

    String id;
    String text;

    public RateItem(String id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public String toString() {
        return "RateItem{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
