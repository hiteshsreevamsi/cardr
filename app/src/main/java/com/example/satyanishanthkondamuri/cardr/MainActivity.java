package com.example.satyanishanthkondamuri.cardr;

import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

import java.util.List;


public class MainActivity extends AppCompatActivity  {

    public static RecyclerView Rv;
    ObjectAdapter mObjectAdapter;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Rv = findViewById(R.id.recycleview);
        mObjectAdapter = new ObjectAdapter(this);


        GridLayoutManager layoutManager =
                new GridLayoutManager(this, 2);

        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {

            @Override
            public int getSpanSize(int position) {
                int x = 1;
                if (position == 6) {
                    x = 2;

                }
                return x;
            }
        });

        View.OnScrollChangeListener l =
                new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                   Log.e("distance of y",String.valueOf(scrollY));
            }
        };
        Rv.setLayoutManager(layoutManager);
        Rv.setItemAnimator(new DefaultItemAnimator());
        Rv.setAdapter(mObjectAdapter);
        Rv.setOnScrollChangeListener(l);
    }


}

