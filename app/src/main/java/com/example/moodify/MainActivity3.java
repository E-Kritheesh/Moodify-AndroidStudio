package com.example.moodify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.moodify.DRVinterface.LoadMore;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StaticRvAdapter staticRvAdapter;

    List<DynamicRVModel> items = new ArrayList();
    DynamicRVAdapter dynamicRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main3);

        ArrayList<StaticRvModel> item = new ArrayList<>();
        item.add(new StaticRvModel(R.drawable.ic_baseline_photo_camera_24,"Camera"));
        item.add(new StaticRvModel(R.drawable.ic_baseline_subdirectory_arrow_right_24,"Recently \nPlayed"));
        item.add(new StaticRvModel(R.drawable.ic_baseline_thumb_up_24,"Liked Songs"));
        item.add(new StaticRvModel(R.drawable.ic_baseline_subject_24,"Playlist \nHistory"));
        item.add(new StaticRvModel(R.drawable.ic_baseline_phone_iphone_24,"Saved \nPictures"));

        recyclerView = findViewById(R.id.rv_1);
        staticRvAdapter = new StaticRvAdapter(item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(staticRvAdapter);

        items.add(new DynamicRVModel("Song"));
        items.add(new DynamicRVModel("Song"));
        items.add(new DynamicRVModel("Song"));
        items.add(new DynamicRVModel("Song"));
        items.add(new DynamicRVModel("Song"));
        items.add(new DynamicRVModel("Song"));
        items.add(new DynamicRVModel("Song"));
        items.add(new DynamicRVModel("Song"));
        items.add(new DynamicRVModel("Song"));
        items.add(new DynamicRVModel("Song"));
        items.add(new DynamicRVModel("Song"));
        items.add(new DynamicRVModel("Song"));
        items.add(new DynamicRVModel("Song"));
        items.add(new DynamicRVModel("Song"));
        items.add(new DynamicRVModel("Song"));
        items.add(new DynamicRVModel("Song"));
        items.add(new DynamicRVModel("Song"));
        items.add(new DynamicRVModel("Song"));
        items.add(new DynamicRVModel("Song"));
        items.add(new DynamicRVModel("Song"));

        RecyclerView drv = findViewById(R.id.rv_2);
        drv.setLayoutManager(new LinearLayoutManager(this));
        dynamicRVAdapter = new DynamicRVAdapter(drv, this,items);
        drv.setAdapter(dynamicRVAdapter);

        dynamicRVAdapter.setLoadMore(new LoadMore() {
            @Override
            public void onLoadMore() {
                if(items.size()<=10){
                    item.add(null);
                    dynamicRVAdapter.notifyItemInserted(items.size()-1);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            items.remove(items.size()-1);
                            dynamicRVAdapter.notifyItemRemoved(items.size());

                            int index = items.size();

                        }
                    },4000);
                }
                else
                    Toast.makeText(MainActivity3.this,"Data Completed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}