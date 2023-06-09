package com.example.cloudapp;

import android.view.View;

public class GridItem {
    private int imageResId;
    private String title;
    private String content;

    private String buttonName;
    private Class<?> targetActivity;
    private View.OnClickListener clickListener;
    private String foodName;

    public GridItem(int imageResId, String title, String content,String buttonName,Class<?> targetActivity) {
        this.imageResId = imageResId;
        this.title = title;
        this.content = content;
        this.buttonName = buttonName;
        this.targetActivity = targetActivity;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getRestaurantName() {
        return title;
    }
    public String getButtonName() {
        return buttonName;
    }

    public Class<?> getTargetActivity() {
        return targetActivity;
    }

    public int getImageId() {
        return imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
    
    public void setClickListener(View.OnClickListener clickListener) {
        this.clickListener = clickListener;
    }
}