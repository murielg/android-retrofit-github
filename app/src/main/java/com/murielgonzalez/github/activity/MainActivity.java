package com.murielgonzalez.github.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.view.View;

import com.murielgonzalez.github.R;
import com.murielgonzalez.github.adapter.ItemsAdapter;
import com.murielgonzalez.github.model.Item;
import com.murielgonzalez.github.rest.ApiInterface;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ItemsAdapter.ItemClickListener {
  private static String TAG = MainActivity.class.getCanonicalName();
  public static final String ROOT_URL = "https://api.github.com/";
  OkHttpClient client;
  private RecyclerView mRecyclerView;
  private LinearLayoutManager mLinearLayoutManager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Button getDataBtn = (Button) findViewById(R.id.getDataBtn);
    getDataBtn.setOnClickListener(this);

    mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    mLinearLayoutManager = new LinearLayoutManager(this);
    mRecyclerView.setLayoutManager(mLinearLayoutManager);
    client = new OkHttpClient();
  }

  @Override
  public void onClick(View view) {
    Log.d(TAG, "onclick");
    int id = view.getId();
    if (id == R.id.getDataBtn) {
      getRetrofitArray();
    }
  }

  //TODO: add loading indicator

  void getRetrofitArray() {
    Log.d(TAG, "getRetrofitArray");
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(ROOT_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build();

    ApiInterface service = retrofit.create(ApiInterface.class);
    String username = "murielg";
    Call<List<Item>> call = service.getItemDetails(username);

    call.enqueue(new Callback<List<Item>>() {
      @Override
      public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {

        try {
          List<Item> Data = response.body();
          mRecyclerView.setAdapter(new ItemsAdapter(Data, R.layout.item_layout, getApplicationContext(), MainActivity.this));
          Log.d("list", Data.toString());

        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      @Override
      public void onFailure(Call<List<Item>> call, Throwable t) {
        Log.d(TAG, "onFailure");

        t.printStackTrace();
      }
    });

  }

  @Override
  public void onClickItem(Item post, int position) {
    Log.d(TAG, "onClickItem");
  }
}

