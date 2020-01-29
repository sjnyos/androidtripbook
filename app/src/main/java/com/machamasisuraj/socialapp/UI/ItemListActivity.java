package com.machamasisuraj.socialapp.UI;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.machamasisuraj.socialapp.Adapter.ItemRecyclerAdapter;
import com.machamasisuraj.socialapp.BLL.ItemBll;
import com.machamasisuraj.socialapp.R;

public class ItemListActivity extends AppCompatActivity {
    private RecyclerView item_recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        PopulateRecyclerViewList();
    }

    public void  PopulateRecyclerViewList(){
        item_recyclerView= findViewById(R.id.itemlists);
        ItemBll itemBll= new ItemBll();
        ItemRecyclerAdapter itemRecyclerAdapter= new ItemRecyclerAdapter(this, itemBll.getAllItems());
        item_recyclerView.setAdapter(itemRecyclerAdapter);
        item_recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
