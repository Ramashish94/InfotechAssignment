package com.example.infotechassignment.retrofit;

import com.example.infotechassignment.model.AssignmentResp;

import okhttp3.RequestBody;
import retrofit2.Callback;

public class RestClient {
    private static final String TAG = "RestClient";

    public static void getDetails(RequestBody email_id, Callback<AssignmentResp> callback) {
        RetrofitClient.getClient().ASSIGNMENT_RESP_CALL(email_id).enqueue(callback);
    }


}