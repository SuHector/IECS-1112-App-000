package com.example.cloudapp;
;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GridItemAdapter extends RecyclerView.Adapter<GridItemAdapter.GridItemViewHolder> {
    private List<GridItem> gridItems;

    public GridItemAdapter(List<GridItem> gridItems) {
        this.gridItems = gridItems;
    }

    @NonNull
    @Override
    public GridItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_item_layout, parent, false);
        return new GridItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridItemViewHolder holder, int position) {
        final GridItem gridItem = gridItems.get(position);

        // 获取方形图片
        Drawable originalImage = ContextCompat.getDrawable(holder.imageView.getContext(), gridItem.getImageResId());

        // 将方形图片转换为圆形图片
        Drawable roundedImage = applyCircleMask(originalImage);

        // 设置圆形图片到 ImageView
        holder.imageView.setImageDrawable(roundedImage);

        // 设置标题和正文
        holder.titleView.setText(gridItem.getTitle());
        holder.contentView.setText(gridItem.getContent());
        holder.button.setText(gridItem.getButtonName());
        // 设置按钮点击事件
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), gridItem.getTargetActivity());
                intent.putExtra("name", gridItem.getRestaurantName());
                v.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return gridItems.size();
    }

    public static class GridItemViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleView;
        TextView contentView;
        Button button;

        public GridItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            titleView = itemView.findViewById(R.id.titleView);
            contentView = itemView.findViewById(R.id.contentView);
            button = itemView.findViewById(R.id.roundedButton);
        }
    }
    private static Drawable applyCircleMask(Drawable originalDrawable) {
        Bitmap originalBitmap = ((BitmapDrawable) originalDrawable).getBitmap();

        // 创建一个空的 Bitmap，用于应用遮罩
        Bitmap resultBitmap = Bitmap.createBitmap(originalBitmap.getWidth(), originalBitmap.getHeight(), Bitmap.Config.ARGB_8888);

        // 创建带有遮罩的画布
        Canvas canvas = new Canvas(resultBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        // 创建圆形的路径
        Rect rect = new Rect(0, 0, originalBitmap.getWidth(), originalBitmap.getHeight());
        RectF rectF = new RectF(rect);
        float radius = Math.min(rectF.width(), rectF.height()) / 2;
        Path path = new Path();
        path.addRoundRect(rectF, radius, radius, Path.Direction.CCW);

        // 在画布上绘制圆形遮罩
        canvas.drawPath(path, paint);

        // 将遮罩应用到原始图片上
        paint.setXfermode(null); //
        canvas.drawBitmap(originalBitmap, rect, rect, paint);

        // 返回带有遮罩的 Drawable
        return new BitmapDrawable(Resources.getSystem(), resultBitmap);
    }


}

