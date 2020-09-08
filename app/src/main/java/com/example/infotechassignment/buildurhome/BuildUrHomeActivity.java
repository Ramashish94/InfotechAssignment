package com.example.infotechassignment.buildurhome;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.infotechassignment.R;
import com.example.infotechassignment.buildurhome.adapter.SelectAdditionAdaptor;
import com.example.infotechassignment.buildurhome.adapter.ProductAdapter;
import com.example.infotechassignment.buildurhome.resp.BasicProductResponse;
import com.example.infotechassignment.buildurhome.resp.SelectAdditionResponse;
import com.example.infotechassignment.retrofit.ApiInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BuildUrHomeActivity extends AppCompatActivity {
    ProductAdapter productAdapter;
    List<BasicProductResponse.Category> categoryArrayList = new ArrayList<>();
    List<SelectAdditionResponse.Category> additionCategoriesList = new ArrayList<>();
    List<SelectAdditionResponse.Product> additionProductList = new ArrayList<>();
    private RecyclerView rvForChooseSection, rvSelectUrAddition;
    private ImageView ivBentBasicBanner, ivHamburger;
    private TextView tvBuildUrHome, tvBuildYourHomeTxt, tvChooseRoom, tvSelectUrAddition;
    private AppCompatRadioButton rdBtnFurnitureAddition, rdBtnRugs, rdBtnArtWork, rdBtnLights;
    private RadioGroup rdGrpChecked;
    private int indexPosition;
    BasicProductResponse basicProductResponse;
    SelectAdditionResponse selectAdditionResponse;
    SelectAdditionAdaptor selectAdditionAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_ur_home);
        ivBentBasicBanner = findViewById(R.id.ivBentBasicBanner);
        tvBuildUrHome = findViewById(R.id.tvBuildUrHome);
        tvBuildYourHomeTxt = findViewById(R.id.tvBuildYourHomeTxt);
        tvChooseRoom = findViewById(R.id.tvChooseRoom);
        rvForChooseSection = findViewById(R.id.rvForChooseSection);
        rvSelectUrAddition = findViewById(R.id.rvSelectUrAddition);

        rdGrpChecked = findViewById(R.id.rdGrpChecked);
        tvSelectUrAddition = findViewById(R.id.tvSelectUrAddition);
        rdBtnFurnitureAddition = findViewById(R.id.rdBtnFurnitureAddition);
        rdBtnRugs = findViewById(R.id.rdBtnRugs);
        rdBtnArtWork = findViewById(R.id.rdBtnArtWork);
        rdBtnLights = findViewById(R.id.rdBtnLights);

        onProductService();
        setBasicProductAdapter();
        setSelectAdditionAdapter();
        //setBasicAdditionAdapter();
    }

    private void onProductService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://demoapp.bentchair.com/api/v1/bent-basic-product-app/").addConverterFactory(GsonConverterFactory.create()).build();
        ApiInterface client = retrofit.create(ApiInterface.class);
        Call<BasicProductResponse> basicProductResponseCall = client.getProductData("uhUQGZPJhuwQ3zxEQkkIkBQZ9ekgQ");
        basicProductResponseCall.enqueue(new Callback<BasicProductResponse>() {
            @Override
            public void onResponse(Call<BasicProductResponse> call, Response<BasicProductResponse> response) {
                if (response != null && response.code() == 200 && response.body() != null) {
                    basicProductResponse = response.body();
                    setTopBanner(basicProductResponse);
                    setIntroduction(basicProductResponse);
                    notifyProductAdapter(basicProductResponse.getCategories());
                } else {
                    Toast.makeText(getApplicationContext(), "response failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<BasicProductResponse> call, Throwable t) {
                Toast.makeText(BuildUrHomeActivity.this, "product response failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setIntroduction(BasicProductResponse basicProductResponse) {
        if (basicProductResponse != null) {
            tvBuildYourHomeTxt.setText("" + basicProductResponse.getDescription());
        }
    }

    private void setTopBanner(BasicProductResponse basicProductResponse) {
        if (basicProductResponse != null) {
            Picasso.with(getApplicationContext()).load(basicProductResponse.getBanner())
                    .error(R.drawable.place_holder_imag).into(ivBentBasicBanner);
        }
    }

    private void setBasicProductAdapter() {
        productAdapter = new ProductAdapter(getApplicationContext(), categoryArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvForChooseSection.setLayoutManager(layoutManager);
        rvForChooseSection.setItemAnimator(new DefaultItemAnimator());
        rvForChooseSection.setAdapter(productAdapter);
    }

    private void notifyProductAdapter(List<BasicProductResponse.Category> categories) {
        categoryArrayList.clear();
        categoryArrayList.addAll(categories);
        if (categoryArrayList != null && categoryArrayList.size() > 0) {
            for (int i = 0; i < categoryArrayList.size(); i++) {
                productAdapter.notifyDataSetChanged();
            }
        }
    }

    private void onAdditionService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://demoapp.bentchair.com/api/v1/bent-basic-accessories-app/").addConverterFactory(GsonConverterFactory.create()).build();
        ApiInterface client = retrofit.create(ApiInterface.class);
        Call<SelectAdditionResponse> selectAdditionResponseCall = client.getAdditionData("uhUQGZPJhuwQ3zxEQkkIkBQZ9ekgQ");
        selectAdditionResponseCall.enqueue(new Callback<SelectAdditionResponse>() {
            @Override
            public void onResponse(Call<SelectAdditionResponse> call, Response<SelectAdditionResponse> response) {
                if (response != null && response.code() == 200 && response.body() != null) {
                    selectAdditionResponse = response.body();
                    setAdditionResponse(selectAdditionResponse);
                    setAdditionTittle(selectAdditionResponse);
                    setNotifyAdditionAdapter(selectAdditionResponse.getCategories().get(indexPosition).getProducts());
//                    setNotifyBasicAdditionAdapter(selectAdditionResponse.getCategories().get(indexPosition).getCategoryId());
                } else {
                    Toast.makeText(getApplicationContext(), "response failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SelectAdditionResponse> call, Throwable t) {
                Toast.makeText(BuildUrHomeActivity.this, "addition response failure", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setAdditionTittle(SelectAdditionResponse selectAdditionResponse) {
        if (selectAdditionResponse != null) {
            tvSelectUrAddition.setText(selectAdditionResponse.getTitle());
        }
    }

    private void setAdditionResponse(SelectAdditionResponse selectAdditionResponse) {
        if (selectAdditionResponse != null && selectAdditionResponse.getCategories().size() > 0) {
            rdGrpChecked.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId) {
                        case R.id.rdBtnFurnitureAddition:
                            indexPosition = 0;
                            rdBtnFurnitureAddition.setTextColor(Color.WHITE);
                            rdBtnRugs.setTextColor(Color.GRAY);
                            rdBtnArtWork.setTextColor(Color.GRAY);
                            rdBtnLights.setTextColor(Color.GRAY);
//                            rdBtnFurnitureAddition.setText(selectAdditionResponse.getCategories().get(indexPosition).getName());
//                            setBasicAdditionAdapter(selectAdditionResponse);
                            onAdditionService();
                            setSelectAdditionAdapter();
                            break;

                        case R.id.rdBtnRugs:
                            indexPosition = 1;
                            rdBtnRugs.setTextColor(Color.WHITE);
                            rdBtnFurnitureAddition.setTextColor(Color.GRAY);
                            rdBtnArtWork.setTextColor(Color.GRAY);
                            rdBtnLights.setTextColor(Color.GRAY);
//                            rdBtnRugs.setText(selectAdditionResponse.getCategories().get(indexPosition).getName());
                            onAdditionService();
                            setSelectAdditionAdapter();
                            break;

                        case R.id.rdBtnArtWork:
                            indexPosition = 2;
                            rdBtnArtWork.setTextColor(Color.WHITE);
                            rdBtnFurnitureAddition.setTextColor(Color.GRAY);
                            rdBtnRugs.setTextColor(Color.GRAY);
                            rdBtnLights.setTextColor(Color.GRAY);
//                            rdBtnArtWork.setText(selectAdditionResponse.getCategories().get(indexPosition).getName());
                            onAdditionService();
                            setSelectAdditionAdapter();
                            break;
                        case R.id.rdBtnLights:
                            indexPosition = 3;
                            rdBtnLights.setTextColor(Color.WHITE);
                            rdBtnFurnitureAddition.setTextColor(Color.GRAY);
                            rdBtnRugs.setTextColor(Color.GRAY);
                            rdBtnArtWork.setTextColor(Color.GRAY);
//                            rdBtnLights.setText(selectAdditionResponse.getCategories().get(indexPosition).getName());
                            onAdditionService();
                            setSelectAdditionAdapter();
                            break;
                    }
                }
            });
        }
    }

    private void setSelectAdditionAdapter() {
        selectAdditionAdaptor = new SelectAdditionAdaptor(getApplicationContext(), additionProductList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rvSelectUrAddition.setLayoutManager(layoutManager);
        rvSelectUrAddition.setItemAnimator(new DefaultItemAnimator());
        rvSelectUrAddition.setAdapter(selectAdditionAdaptor);
    }

    private void setNotifyAdditionAdapter(List<SelectAdditionResponse.Product> products) {
        additionProductList.clear();
        additionProductList.addAll(products);
        if (additionProductList != null && additionProductList.size() > 0) {
            selectAdditionAdaptor.notifyDataSetChanged();
        }
    }

    private void setNotifyBasicAdditionAdapter(Integer categoryId) {
        if (categoryId != null) {
            additionProductList.clear();
            if (additionProductList != null && additionProductList.size() > 0) {
                selectAdditionAdaptor.notifyDataSetChanged();
            }
        }

    }

//    private void setBasicAdditionAdapter() {
//        additionCategoryAdaptor = new AdditionCategoryAdaptor(getApplicationContext(), additionCategoriesList);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
//        rvSelectUrAddition.setLayoutManager(layoutManager);
//        rvSelectUrAddition.setItemAnimator(new DefaultItemAnimator());
//        rvSelectUrAddition.setAdapter(additionCategoryAdaptor);
//    }
//
//    private void setNotifyBasicAdditionAdapter(List<SelectAdditionResponse.Category> categories) {
//        additionCategoriesList.clear();
//        additionCategoriesList.addAll(categories);
//        if (additionCategoriesList != null && additionCategoriesList.size() > 0) {
//            additionCategoryAdaptor.notifyDataSetChanged();
//        }
//    }

}

