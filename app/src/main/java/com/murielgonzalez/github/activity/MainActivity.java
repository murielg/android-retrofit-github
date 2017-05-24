package com.murielgonzalez.github.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.view.View;
import com.murielgonzalez.github.R;
import com.murielgonzalez.github.model.Item;
import com.murielgonzalez.github.rest.ApiInterface;

import java.util.List;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String ROOT_URL = "https://api.github.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listView);
        Button  getDataBtn = (Button) findViewById(R.id.getDataBtn);

        getDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRetrofitArray();
            }
        });

    }

    //TODO: add a loading indicator

    void getRetrofitArray() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface service = retrofit.create(ApiInterface.class);

        Call<List<Item>> call = service.getItemDetails("murielg");

        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                try {
                    List<Item> Data = response.body();
                    Log.i("Data",Data.get(1).toString());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {

            }
        });


    }


}

