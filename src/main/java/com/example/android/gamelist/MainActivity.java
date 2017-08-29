package com.cossconsulting.gamelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Giovanni";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<AllGames> requestListGame = service.listGame();

        requestListGame.enqueue(new Callback<AllGames>() {
            @Override
            public void onResponse(Call<AllGames> call, Response<AllGames> response) {
                if(response.isSuccessful()){
                    ListView listView = (ListView) findViewById(R.id.gameList);
                    AllGames listGames = response.body();

                    for(Game g: listGames.games){
                        Log.i(TAG, "ID: " + g.id
                                + "\nName: " + g.name
                                + "\nRelease date: " + g.release_date);
                    }

                    ArrayAdapter <Game> adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, listGames.games);
                    listView.setAdapter(adapter);

                    Log.i(TAG, "Sucess");

                } else{
                    Log.e(TAG, "Error: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<AllGames> call, Throwable t) {
                Log.e(TAG, "Error: " + t.getMessage());
            }
        });

    }
}
