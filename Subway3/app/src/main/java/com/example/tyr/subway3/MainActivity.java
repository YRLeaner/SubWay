package com.example.tyr.subway3;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.tyr.subway3.Fragments.BaseFragment;
import com.example.tyr.subway3.Fragments.XFilmFragment;
import com.example.tyr.subway3.Fragments.XNewsFragment;
import com.example.tyr.subway3.Fragments.XSmileFragment;
import com.example.tyr.subway3.Fragments.XVideoFragment;
import com.example.tyr.subway3.activity.DrawerActivity;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.othershe.nicedialog.BaseNiceDialog;
import com.othershe.nicedialog.NiceDialog;
import com.othershe.nicedialog.ViewConvertListener;
import com.othershe.nicedialog.ViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends DrawerActivity {

    @BindView(R.id.materialViewPager)
    MaterialViewPager mViewPager;
    FilmHolder filmHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("");
        ButterKnife.bind(this);
        final Toolbar toolbar = mViewPager.getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        initViews();

    }



    private void initViews() {
        //mViewPager = (MaterialViewPager)findViewById(R.id.materialViewPager);
       mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
           @Override
           public Fragment getItem(int position) {
              switch (position%4){
                  case 0:
                      return XNewsFragment.newInstance();
                  case 1:
                      XFilmFragment xFilmFragment =  XFilmFragment.newInstance();
                      xFilmFragment.setFraToActAnimListener(new BaseFragment.FraToActAnimListener() {
                          @Override
                          public void beginToAnim(Intent intent, View view) {
                              if (android.os.Build.VERSION.SDK_INT > 20) {
                                  filmHolder = new FilmHolder();
                                  filmHolder.imageView = (ImageView)view.findViewById(R.id.film_video);
                                  startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,filmHolder.imageView, "filmImage").toBundle());
                                  overridePendingTransition(R.anim.in_anim, R.anim.out_anim);
                              }else {
                                  startActivity(intent);
                              }
                          }
                      });
                      return xFilmFragment;
                  case 2:
                      return XSmileFragment.newInstance();
                  default:
                      return XVideoFragment.newInstance();
              }
           }

           @Override
           public int getCount() {
               return 4;
           }

           @Override
           public CharSequence getPageTitle(int position) {
               switch (position % 4) {
                   case 0:
                       return "图书";
                   case 1:
                       return "电影";
                   case 2:
                       return "笑话";
                   case 3:
                       return "视频";
               }
               return "";
           }
       });
        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.green,
                                getResources().getDrawable(R.drawable.music));
                    case 1:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.blue,
                               getResources().getDrawable(R.drawable.filmbg));
                    case 2:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.cyan,
                                getResources().getDrawable(R.drawable.smile));
                    case 3:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.red,
                                getResources().getDrawable(R.drawable.video));
                }
                //execute others actions if needed (ex : modify your header logo)
                return null;
            }
        });
        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());
    }

    public static class FilmHolder{
        public ImageView imageView;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK &&event.getAction() == KeyEvent.ACTION_DOWN){
            Log.d("back","yes");
            NiceDialog.init()
                    .setLayoutId(R.layout.dialog)     //设置dialog布局文件
                    .setConvertListener(new ViewConvertListener() {     //进行相关View操作的回调
                        @Override
                        public void convertView(ViewHolder holder, final BaseNiceDialog dialog) {
                                holder.getView(R.id.sure).setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        finish();
                                    }
                                });
                            holder.getView(R.id.cancle).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                }
                            });
                        }
                    })
                    .setDimAmount(0.3f)     //调节灰色背景透明度[0-1]，默认0.5f
                    .setShowBottom(true)     //是否在底部显示dialog，默认flase
                    .setMargin(1)     //dialog左右两边到屏幕边缘的距离（单位：dp），默认0dp
                    //.setWidth()     //dialog宽度（单位：dp），默认为屏幕宽度
                    //.setHeight()     //dialog高度（单位：dp），默认为WRAP_CONTENT
                    .setOutCancel(false)     //点击dialog外是否可取消，默认true
                    .show(getSupportFragmentManager());     //显示dialog
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
