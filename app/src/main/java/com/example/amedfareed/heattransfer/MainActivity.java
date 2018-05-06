package com.example.amedfareed.heattransfer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.amedfareed.heattransfer.adapter.MyLovelyAdapter;
import com.example.amedfareed.heattransfer.model.Heat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Heat> heatList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        recyclerView.smoothScrollToPosition(0);
        initializeData();
        recyclerView.setAdapter(new MyLovelyAdapter(this, heatList));
    }



    public void initializeData(){
        heatList = new ArrayList<>();
        heatList.add(new Heat(getString(R.string.heat_transfer_label),getString(R.string.heat_desc),getString(R.string.heat_transfer_brief),R.drawable.heat));
        heatList.add(new Heat(getString(R.string.conduction_label),getString(R.string.conduction_desc),getString(R.string.conduction_brief),R.drawable.conduction));
        heatList.add(new Heat(getString(R.string.convection_label),getString(R.string.convection_desc) ,getString(R.string.convection_brief),R.drawable.boiling));
        heatList.add(new Heat(getString(R.string.radiation_label),getString(R.string.radiation_desc),getString(R.string.radiation_brief),R.drawable.radiation));
    }
}
