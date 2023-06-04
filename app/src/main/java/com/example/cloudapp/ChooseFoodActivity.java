package com.example.cloudapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChooseFoodActivity extends AppCompatActivity {
    private List<GridItem> gridItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosefood);

        // 初始化方格數據
        //initializeGridItems();

        Intent intent = getIntent();
        String RestaurantName = intent.getStringExtra("name");
        TextView textView = findViewById(R.id.titleTextView);
        //initializeGridItems();
        gridItems = initializeGridItems_choose(RestaurantName);

        // 修改TextView的文本内容
        textView.setText(RestaurantName);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        GridItemAdapter adapter = new GridItemAdapter(gridItems);
        recyclerView.setAdapter(adapter);
    }

    private void initializeGridItems() {
        // 添加方格數據到 gridItems 列表中
        //gridItems.add(new GridItem(R.drawable.image1,"麥當勞", "1號餐廳","查看",MainActivity.class));
        //gridItems.add(new GridItem(R.drawable.image2,"肯德基","2號餐廳","查看", MainActivity.class));
        WriteFoodList.setContext(getApplicationContext());
        // 添加更多方格數據
    }
    private List<GridItem> initializeGridItems_choose(String filename) {
        //WriteFoodList.setContext(getApplicationContext());
        if( filename.equals("麥當勞")){
            return WriteFoodList.Mc_data();
        }else if( filename.equals("肯德基")){
            return WriteFoodList.Kfc_data();
        }
        else if( filename.equals("胖老爹")){
            return WriteFoodList.fd_data();
        }else if( filename.equals("摩斯漢堡")){
            return WriteFoodList.mos_data();
        }else if( filename.equals("頂呱呱")){
            return WriteFoodList.tkk_data();
        }else if( filename.equals("達美樂")){
            return WriteFoodList.dom_data();
        }else if( filename.equals("必勝客")){
            return WriteFoodList.hb_data();
        }else if( filename.equals("拿波里")){
            return WriteFoodList.nap_data();
        }

        return null;
    }

}
