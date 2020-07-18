package com.example.infotechassignment.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.infotechassignment.R;

public class TaskPerformActivity extends AppCompatActivity {
Button btnQuestion1,btnQuestion2,btnQuestion3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_perform);
        btnQuestion1 = findViewById(R.id.btnQues1);
        btnQuestion2= findViewById(R.id.btnQues2);
        btnQuestion3 = findViewById(R.id.btnQues3);


        btnQuestion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),JsonParsingActivity.class);
                startActivity(intent);
            }
        });


        btnQuestion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),JsonParsingActivity.class);
                startActivity(intent);
            }
        });
    }
}
