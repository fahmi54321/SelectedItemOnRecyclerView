package com.android.a96selecteditemonrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.a96selecteditemonrecyclerview.Adapter.CustomAdapter;
import com.android.a96selecteditemonrecyclerview.Model.Item;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView list_item;
    RecyclerView.LayoutManager layoutManager;
    List<Item> items = new ArrayList<>();
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {

            startActivity(new Intent(MainActivity.this,NewActivity.class));

        });

        list_item = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        list_item.setHasFixedSize(true);
        list_item.setLayoutManager(layoutManager);

        getData();
    }

    private void getData() {
        for (int i=0;i<10;i++){
            Item item = new Item();
            item.setName("Item "+i);
            if (i%2==0){
                item.setChecked(false);
            }else{
                item.setChecked(true);
            }

            items.add(item);
        }

        //create adapter
        CustomAdapter adapter = new CustomAdapter(items,this);
        list_item.setAdapter(adapter);
    }
}