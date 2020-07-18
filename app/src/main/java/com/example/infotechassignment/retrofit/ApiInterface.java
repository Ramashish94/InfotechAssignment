package com.example.infotechassignment.retrofit;

import com.example.infotechassignment.model.AssignmentResp;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    @Multipart
    @POST("https://www.maishainfotech.com/adinterview/interview.php")
    Call<AssignmentResp>ASSIGNMENT_RESP_CALL(@Part("email_id") RequestBody email_id);


}