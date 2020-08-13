package com.example.infotechassignment.retrofit;

import com.example.infotechassignment.mainwork.modelnew.BentBasicHomeResp;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Part;

public interface ApiInterface {

    @GET("https://demoapp.bentchair.com/api/v1/bent-basic-home")
    Call<BentBasicHomeResp>BENT_BASIC_HOME_RESP_CALL(@Header("ApiToken") RequestBody ApiToken);

}