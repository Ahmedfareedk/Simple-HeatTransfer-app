package com.example.amedfareed.heattransfer;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amedfareed.heattransfer.model.Heat;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    TextView nameTextView, snopTextView, explainTextView;
    ImageView detailImage, explainPoster;
    AppBarLayout appBarLayout;
    CollapsingToolbarLayout collapse;
    Toolbar toolbar;
    List<Heat> heatList;
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        heatList = new ArrayList<>();
        fab = findViewById(R.id.action_play);
        initializeCollapsingLayout();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initializeViews();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this, HeatTransferVideoExplaination.class);
                startActivity(intent);
            }
        });
    }

    public void initializeViews() {
        nameTextView = findViewById(R.id.name_textView);
        snopTextView = findViewById(R.id.snop_tv);
        explainTextView = findViewById(R.id.explain_tv);
        detailImage = findViewById(R.id.detail_poster);
        explainPoster = findViewById(R.id.detail_content_poster);
        Intent intent = getIntent();
        String kindName = intent.getExtras().getString("Heat_kind");
        String snop = intent.getExtras().getString("desc_text");
        String explain = intent.getExtras().getString("explain_text");
        int posterId = intent.getExtras().getInt("image_id");
        nameTextView.setText(kindName);
        snopTextView.setText(snop);
        explainTextView.setText(explain);
        Picasso.with(this)
                .load(posterId)
                .into(detailImage);
        Picasso.with(this)
                .load(posterId)
                .resize(512,512)
                .into(explainPoster);

    }

    private void initializeCollapsingLayout(){
        collapse = findViewById(R.id.collapsing_layout);
       toolbar = findViewById(R.id.toolbar);
        appBarLayout = findViewById(R.id.appbar_layout);
        final Heat heatModel  = new Heat();
        final Intent intent =getIntent();
        collapse.setTitle(" ");
        appBarLayout.setExpanded(true);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                boolean isShow = false;
                int appBarScrollRange = -1;
                if (appBarScrollRange == -1) {
                    appBarScrollRange = appBarLayout.getTotalScrollRange();
                }
                if (appBarScrollRange + verticalOffset == 0) {
                    collapse.setTitle(intent.getExtras().getString("Heat_kind"));
                    toolbar.setVisibility(View.VISIBLE);
                } else if (isShow) {
                    collapse.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }
}
