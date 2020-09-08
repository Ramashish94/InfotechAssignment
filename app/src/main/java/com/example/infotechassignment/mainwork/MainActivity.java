package com.example.infotechassignment.mainwork;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infotechassignment.R;
import com.example.infotechassignment.mainwork.modelnew.Addition;
import com.example.infotechassignment.mainwork.modelnew.BentBasicHomeResponse;
import com.example.infotechassignment.mainwork.modelnew.Category;
import com.example.infotechassignment.mainwork.modelnew.Product;
import com.example.infotechassignment.mainwork.modelnew.Section;
import com.example.infotechassignment.retrofit.ApiInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHome;
    private MainActivity mActivity;
    private boolean isBottomLoading;
    private ImageView ivHamburger, ivBentBasicBG;
    private TextView tvIntroHeading, tvIntroDescription, tvBentBasicAddition;
    private Button btnBookYourConsultation;
    private RecyclerView rvSection, rvAddition;
    SectionAdapter sectionAdapter;
    AdditionAdapter additionAdapter;
    List<Section> sectionList = new ArrayList<>();
    List<Addition> additionList = new ArrayList<>();
    List<Category> categoryList = new ArrayList<>();
    List<Product> productList = new ArrayList<>();
    BentBasicHomeResponse bentBasicHomeResponse;
    BentBasicHomeResponse basicHomeResponse = new BentBasicHomeResponse();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivBentBasicBG = findViewById(R.id.ivBentBasicBG);
        tvIntroHeading = findViewById(R.id.tvIntroBentBasicHeading);
        tvIntroDescription = findViewById(R.id.tvIntroBentBasicText);
        btnBookYourConsultation = findViewById(R.id.btnBookYourConsultation);
        rvSection = findViewById(R.id.rvBentBasicSections);
        tvBentBasicAddition = findViewById(R.id.tvBentBasicAddition);
        rvAddition = findViewById(R.id.rvBentBasicSAddition);

//        selectionAdapter = new SelectionAdapter(bentBasicHomeResp, getApplicationContext()); // as you want you dec or nor
//        additionAdapter = new AdditionAdapter(bentBasicHomeResp, getApplicationContext());

        onservice();

    }


    private void onservice() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://demoapp.bentchair.com/api/v1/bent-basic-home/").addConverterFactory(GsonConverterFactory.create()).build();
        ApiInterface client = retrofit.create(ApiInterface.class);
        Call<BentBasicHomeResponse> bentBasicHomeResponseCall = client.getData("uhUQGZPJhuwQ3zxEQkkIkBQZ9ekgQ");
        bentBasicHomeResponseCall.enqueue(new Callback<BentBasicHomeResponse>() {
            @Override
            public void onResponse(Call<BentBasicHomeResponse> call, Response<BentBasicHomeResponse> response) {
                if (response != null && response.code() == 200 && response.body() != null) {
                    basicHomeResponse=response.body();
                    setTopBanner(basicHomeResponse);
                    setIntroduction(basicHomeResponse);
                    setSectionAdapter(basicHomeResponse);
                    setAdditionAdapter();
                } else {
                    Toast.makeText(mActivity, "response failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BentBasicHomeResponse> call, Throwable t) {
                Toast.makeText(mActivity, "ApiFailure", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void setTopBanner(BentBasicHomeResponse response) {
        if (response != null) {
            Picasso.with(getApplicationContext()).load(basicHomeResponse.getBanner())
                    .error(R.drawable.place_holder_imag).into(ivBentBasicBG);
        }
    }

    private void setIntroduction(BentBasicHomeResponse response) {
        if (response != null) {
            tvIntroHeading.setText("" + basicHomeResponse.getTitle());
            tvIntroDescription.setText("" + basicHomeResponse.getDescription());
            btnBookYourConsultation.setText("" + basicHomeResponse.getButton());
        }
    }

    private void setAdditionAdapter() {
        rvAddition.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        additionAdapter = new AdditionAdapter(getApplicationContext(), additionList, categoryList);
        rvAddition.setItemAnimator(new DefaultItemAnimator());
        rvAddition.setAdapter(additionAdapter);
        //additionAdapter.setOnItemClickListener(this);
    }

    private void setSectionAdapter(BentBasicHomeResponse sections) {
        sectionAdapter = new SectionAdapter(sections,getApplicationContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvSection.setLayoutManager(layoutManager);
        rvSection.setItemAnimator(new DefaultItemAnimator());
        rvSection.setAdapter(sectionAdapter);
        //sectionAdapter.setOnItemClickListener(this);

    }

}