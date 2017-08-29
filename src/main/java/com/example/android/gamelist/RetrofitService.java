package com.example.android.gamelist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Giovanni on 28/08/2017.
 */

public interface RetrofitService {
    @GET("courses")
    Call <List<Game>> listGame ();
}
