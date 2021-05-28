package com.android.a96selecteditemonrecyclerview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.a96selecteditemonrecyclerview.Common.Common;

public class NewActivity extends AppCompatActivity {

    public ImageView imageView;
    public TextView textView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_item);

        textView = findViewById(R.id.text_view);
        imageView = findViewById(R.id.image_view);

        textView.setText(Common.cuurentItem.getName());
        if (!Common.cuurentItem.isChecked()){
            imageView.setImageResource(R.drawable.ic_baseline_clear_24);
        }else{
            imageView.setImageResource(R.drawable.ic_baseline_check_24);
        }
    }
}
