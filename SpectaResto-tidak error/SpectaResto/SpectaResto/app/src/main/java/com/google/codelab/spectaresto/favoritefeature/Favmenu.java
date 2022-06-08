package com.google.codelab.spectaresto.favoritefeature;

public class Favmenu {

    private int imageResource;
    private String title;
    private String id;


    public Favmenu(){

    }

    public Favmenu(int imageResource,String title, String key_id)
    {
        this.imageResource = imageResource;
        this.title = title;
        this.id = key_id;

    }

}
