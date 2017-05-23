package com.murielgonzalez.github.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.murielgonzalez.github.R;
import com.murielgonzalez.github.model.Item;
import com.murielgonzalez.github.rest.ApiClient;
import com.murielgonzalez.github.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<Response> call = service.getUsersNamedTom("tom");
        call.enqueue(new Callback<Item>() {
            @Override
            public void onResponse(Call<Item> call, Response<Item> response) {

            }

            @Override
            public void onFailure(Call<Item> call, Throwable t) {

            }
        });







    }
}
