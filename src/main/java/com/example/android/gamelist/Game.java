package com.example.android.gamelist;

import android.graphics.Bitmap;
import android.icu.text.SimpleDateFormat;

/**
 * Created by Giovanni on 28/08/2017.
 */

public class Game {

    int id;
    String name;
    Bitmap image;
    SimpleDateFormat release_date;
    String trailer;
    String platforms;

    public Game(int id, String name, Bitmap image, SimpleDateFormat release_date, String trailer, String platforms) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.release_date = release_date;
        this.trailer = trailer;
        this.platforms = platforms;
    }
}
