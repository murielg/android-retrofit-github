package com.murielgonzalez.github.rest;

import java.util.List;

import com.murielgonzalez.github.model.Item;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by muriel_gonzalez on 5/23/17.
 */

public interface ApiInterface {

  @GET("users/{user}/starred")
  Call<List<Item>> getItemDetails(@Path("user") String user);
}
