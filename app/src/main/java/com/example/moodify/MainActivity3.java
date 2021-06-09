package com.example.moodify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private StaticRvAdapter staticRvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main3);

        ArrayList<StaticRvModel> item = new ArrayList<>();
        item.add(new StaticRvModel(R.drawable.ic_baseline_play_arrow_24,"Liked Songs"));
        item.add(new StaticRvModel(R.drawable.ic_baseline_play_arrow_24,"Recently Played"));
        item.add(new StaticRvModel(R.drawable.ic_baseline_play_arrow_24,"Recommended Playlists"));
        item.add(new StaticRvModel(R.drawable.ic_baseline_play_arrow_24,"Camera"));
        item.add(new StaticRvModel(R.drawable.ic_baseline_play_arrow_24,"Saved Pics"));

        recyclerView = findViewById(R.id.rv_1);
        staticRvAdapter = new StaticRvAdapter(item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(staticRvAdapter);

    }
}