package com.example.infotechassignment.mainwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.infotechassignment.R;
import com.example.infotechassignment.mainwork.modelnew.BentBasicHomeResp;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHome;
    private MainActivity mActivity;
    private boolean isBottomLoading;
    private ImageView ivHamburger, ivBentBasicBG;
    private TextView tvIntroBentBasicHeading, tvIntroBentBasicText, tvBentBasicAddition;
    private Button btnBookYourConsultation;
    private RecyclerView rvBentBasicSections, rvBentBasicSAddition;
    SelectionAdapter selectionAdapter;
    AdditionAdapter additionAdapter;
    BentBasicHomeResp bentBasicHomeResp;
    String ApiToken = "uhUQGZPJhuwQ3zxEQkkIkBQZ9ekgQ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivBentBasicBG = findViewById(R.id.ivBentBasicBG);
        tvIntroBentBasicHeading = findViewById(R.id.tvIntroBentBasicHeading);
        tvIntroBentBasicText = findViewById(R.id.tvIntroBentBasicText);
        btnBookYourConsultation = findViewById(R.id.btnBookYourConsultation);
        rvBentBasicSections = findViewById(R.id.rvBentBasicSections);
        tvBentBasicAddition = findViewById(R.id.tvBentBasicAddition);
        rvBentBasicSAddition = findViewById(R.id.rvBentBasicSAddition);

        selectionAdapter = new SelectionAdapter(bentBasicHomeResp, getApplicationContext()); // as you want you dec or nor
        additionAdapter = new AdditionAdapter(bentBasicHomeResp, getApplicationContext());

        onservice();

    }

    private void onservice() {

    }
}