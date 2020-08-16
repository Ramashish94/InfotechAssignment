package com.example.infotechassignment.retrofit;

import com.example.infotechassignment.mainwork.modelnew.BentBasicHomeResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiInterface {

    @GET("https://demoapp.bentchair.com/api/v1/bent-basic-home")
    Call<BentBasicHomeResponse>getData(@Header("ApiToken") String ApiToken);

}