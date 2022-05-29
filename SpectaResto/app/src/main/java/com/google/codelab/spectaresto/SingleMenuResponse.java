package com.google.codelab.spectaresto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SingleMenuResponse {
    @SerializedName("Result")
    private DataItem result;

    public DataItem getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "SingleMenuResponse{" +
                "result=" + result +
                '}';
    }
}
