package com.google.codelab.spectaresto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataItem {
    @SerializedName("images")
    private List<String> images;

    @SerializedName("_id")
    private String id;

    @SerializedName("menuname")
    private String menuName;

    @SerializedName("description")
    private String description;

    @SerializedName("__v")
    private int v;

    public List<String> getImages() {
        return images;
    }

    public String getId() {
        return id;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getDescription() {
        return description;
    }

    public int getV() {
        return v;
    }

    @Override
    public String toString() {
        return "DataItem{" +
                "images=" + images +
                ", id='" + id + '\'' +
                ", menuName='" + menuName + '\'' +
                ", description='" + description + '\'' +
                ", v=" + v +
                '}';
    }
}
