package com.cossconsulting.gamelist;


/**
 * Created by Giovanni on 29/08/2017.
 */


public class Game {

    int id;
    String name;
    String image;
    String release_date;
    String trailer;
    String platforms[] = new String[10];


    @Override
    public String toString() {
        return id + " - " + name + "\n      Lançamento: " + release_date;
    }
}
