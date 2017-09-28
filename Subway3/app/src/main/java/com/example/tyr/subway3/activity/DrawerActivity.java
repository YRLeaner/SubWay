package com.example.tyr.subway3.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;


import com.example.tyr.subway3.ActivityAdapter.DrawerRecyclerViewAdapter;
import com.example.tyr.subway3.OnMyItemClickListener;
import com.example.tyr.subway3.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by florentchampigny on 27/05/2016.
 */
public class DrawerActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mDrawerToggle;
    @BindView(R.id.draw_rec)
    RecyclerView recyclerView;
    private List<String> contents;
    private  boolean isChecked;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void onStart() {
        super.onStart();

        mDrawer = (DrawerLayout) findViewById(R.id.draw_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, 0, 0);
        mDrawer.setDrawerListener(mDrawerToggle);

        ButterKnife.bind(this);

       initRecycler();


        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setDisplayUseLogoEnabled(false);
            actionBar.setHomeButtonEnabled(true);
        }
    }

    private void initRecycler() {
        contents = new ArrayList<>();
        contents.add("电影");
        contents.add("视频");
        DrawerRecyclerViewAdapter drawerRecyclerViewAdapter = new DrawerRecyclerViewAdapter(this,contents);
        drawerRecyclerViewAdapter.setOnMyItemClickListener(new OnMyItemClickListener() {
            @Override
            public void itemClick(View v, int position) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(DrawerActivity.this,FilmLikeTypeActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2 = new Intent(DrawerActivity.this,VideoLikeTypeActivity.class);
                        startActivity(intent2);
                        break;
                }
            }
        });


        drawerRecyclerViewAdapter.setCheckedLiseneter(new DrawerRecyclerViewAdapter.OnCheckedLiseneter() {
            @Override
            public void oncheckChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    SharedPreferences sharedPreferences = getSharedPreferences("SubWay3",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("check",true);
                    editor.commit();
                  /*  Fileinfo fileinfo = new Fileinfo(0,"http://baobab.kaiyanapp.com/api/v1/playUrl?vid=25769&editionType=default&source=qcloud",
                           "hhahahahahahahah.mp4",0,0);
                    Intent intent = new Intent(DrawerActivity.this, DownloadService.class);
                    intent.setAction(DownloadService.ACTION_START);
                    intent.putExtra("fileinfo",fileinfo);
                    startService(intent);*/
                    //
                }else {
                    SharedPreferences sharedPreferences = getSharedPreferences("SubWay3",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("check",false);
                    editor.commit();
                }
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(drawerRecyclerViewAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(DrawerActivity.this,DividerItemDecoration.VERTICAL));
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item) ||
            super.onOptionsItemSelected(item);
    }
}
