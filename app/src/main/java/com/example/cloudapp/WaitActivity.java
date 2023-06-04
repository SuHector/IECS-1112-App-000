package com.example.cloudapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WaitActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wait);

        TextView textView = findViewById(R.id.tv_waitres);
        textView.setText("麥當勞");
        Button button = findViewById(R.id.btn_reset);

        button.setOnClickListener(new View.OnClickListener() { //點擊後執行跳頁的指令
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(WaitActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });//ClickListener結束
    }
}