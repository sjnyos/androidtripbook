package com.machamasisuraj.socialapp.GUI;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.machamasisuraj.socialapp.R;

public class ItemListActivity extends AppCompatActivity {
    private RecyclerView item_recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }


}
