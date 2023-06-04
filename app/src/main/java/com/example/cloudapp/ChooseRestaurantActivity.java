package com.example.cloudapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChooseRestaurantActivity extends AppCompatActivity {
    private List<GridItem> gridItems = new ArrayList<>();

    private final String filePath = "src/data";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooserestaurant);


        // 初始化方格數據
        initializeGridItems();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        GridItemAdapter adapter = new GridItemAdapter(gridItems);
        recyclerView.setAdapter(adapter);
    }

    private void initializeGridItems() {
        // 添加方格數據到 gridItems 列表中
        gridItems.add(new GridItem(R.drawable.image1,"麥當勞", "1號餐廳","查看",ChooseFoodActivity.class));
        gridItems.add(new GridItem(R.drawable.image2,"肯德基","2號餐廳","查看", ChooseFoodActivity.class));
        gridItems.add(new GridItem(R.drawable.image3,"胖老爹","3號餐廳","查看", ChooseFoodActivity.class));
        gridItems.add(new GridItem(R.drawable.image4,"摩斯漢堡","4號餐廳","查看", ChooseFoodActivity.class));
        gridItems.add(new GridItem(R.drawable.image5,"頂呱呱","5號餐廳","查看", ChooseFoodActivity.class));
        gridItems.add(new GridItem(R.drawable.image6,"達美樂","6號餐廳","查看", ChooseFoodActivity.class));
        gridItems.add(new GridItem(R.drawable.image7,"必勝客","7號餐廳","查看", ChooseFoodActivity.class));
        gridItems.add(new GridItem(R.drawable.image8,"拿波里","8號餐廳","查看", ChooseFoodActivity.class));
        // 添加更多方格數據

    }


}
