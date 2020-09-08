package com.example.infotechassignment.retrofit;

import com.example.infotechassignment.buildurhome.resp.BasicProductResponse;
import com.example.infotechassignment.buildurhome.resp.SelectAdditionResponse;
import com.example.infotechassignment.mainwork.modelnew.BentBasicHomeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiInterface {

    @GET("https://demoapp.bentchair.com/api/v1/bent-basic-home")
    Call<BentBasicHomeResponse>getData(@Header("ApiToken") String ApiToken);

    @GET("https://demoapp.bentchair.com/api/v1/bent-basic-product-app")
    Call<BasicProductResponse>getProductData(@Header("ApiToken") String ApiToken);

    @GET("https://demoapp.bentchair.com/api/v1/bent-basic-accessories-app")
    Call<SelectAdditionResponse>getAdditionData(@Header("ApiToken") String ApiToken);

}