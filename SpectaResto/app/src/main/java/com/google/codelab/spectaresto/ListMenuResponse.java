package com.google.codelab.spectaresto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListMenuResponse {
    @SerializedName("Total Menu")
    private int total;

    @SerializedName("Result")
    private List<DataItem> data;

    public int getTotal() {
        return total;
    }

    public List<DataItem> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ListMenuResponse{" +
                "total=" + total +
                ", data=" + data +
                '}';
    }
}
