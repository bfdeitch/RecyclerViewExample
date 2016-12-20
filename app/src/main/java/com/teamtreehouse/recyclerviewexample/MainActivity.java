package com.teamtreehouse.recyclerviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter adapter;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int visibleItemCount = layoutManager.getChildCount();
                int totalItemCount = layoutManager.getItemCount();
                int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();
                if (pastVisibleItems + visibleItemCount >= totalItemCount) {
                    add20Items();
                }
            }
        });

        add20Items();
    }

    void add20Items() {
        List<Integer> itemsToAdd = new ArrayList<>();
        int iPlus20 = i + 20;
        for (/*This can be left empty*/; i < iPlus20; i++) {
            itemsToAdd.add(i);
        }
        adapter.list.addAll(itemsToAdd);
        adapter.notifyDataSetChanged();
    }
}
