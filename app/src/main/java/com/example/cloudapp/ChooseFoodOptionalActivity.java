package com.example.cloudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ChooseFoodOptionalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optional);

        TextView textView = findViewById(R.id.resName);
        textView.setText("麥當勞");
        TextView textView2 = findViewById(R.id.foodName);
        textView2.setText("薯條");
        Button button = findViewById(R.id.btn_complete);

        button.setOnClickListener(new View.OnClickListener() { //點擊後執行跳頁的指令
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ChooseFoodOptionalActivity.this, WaitActivity.class);
                startActivity(intent);
            }
        });//ClickListener結束
    }
}
