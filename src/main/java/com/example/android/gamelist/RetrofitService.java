package com.cossconsulting.gamelist;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Giovanni on 29/08/2017.
 */

public interface RetrofitService {

    final String BASE_URL = "https://dl.dropboxusercontent.com/s/1b7jlwii7jfvuh0/";

    @GET("games")
    Call<AllGames> listGame();
}