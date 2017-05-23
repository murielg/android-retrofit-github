package com.murielgonzalez.github.rest;

import com.murielgonzalez.github.model.Item;
import com.murielgonzalez.github.model.Response;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by muriel_gonzalez on 5/23/17.
 */

public interface ApiInterface {

    @GET("/users/murielg/starred")
    @Headers("Content-type: application/json")
    Call <Response> getRepos(@Query("q") String name);

}
