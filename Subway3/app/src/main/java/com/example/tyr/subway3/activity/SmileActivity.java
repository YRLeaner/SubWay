package com.example.tyr.subway3.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.tyr.subway3.R;
import com.example.tyr.subway3.ActivityAdapter.SmileMainAdapter;
import com.example.tyr.subway3.beans.DuanZiBean;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tyr on 2017/8/5.
 */
public class SmileActivity extends AppCompatActivity {


    SwipeFlingAdapterView swipeFlingAdapterView;

    private List<DuanZiBean.Datum> datumList;
    private List<String> a1;
    private SmileMainAdapter datumArrayAdapter;
    private ImageView mNormalImage;
    private float alpha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smile_main);

        initAdapter();
    }



    private void initAdapter() {
        swipeFlingAdapterView = (SwipeFlingAdapterView)findViewById(R.id.swipe_card);
        a1 = new ArrayList<>();
        datumList = new ArrayList<>();
        Bundle bundle = getIntent().getExtras();
        datumList.addAll((List<DuanZiBean.Datum>) bundle.getSerializable("duanzi"));

        for (int i=0;i<datumList.size();i++){
            Log.d("gank",datumList.get(i).getGroup().getText());
        }
        datumArrayAdapter = new SmileMainAdapter(this,R.layout.item,datumList);
        swipeFlingAdapterView.setAdapter(datumArrayAdapter);
        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!");
                if (datumList.size() != 1) {
                    datumList.remove(0);
                    datumArrayAdapter.notifyDataSetChanged();
                }else {
                    makeToast(SmileActivity.this,"已经是最后了");
                }
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                makeToast(SmileActivity.this, "Left!");
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                makeToast(SmileActivity.this, "Right!");
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
                datumArrayAdapter.notifyDataSetChanged();
                makeToast(SmileActivity.this, "kongle");
                Log.d("LIST", "notified");
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                View view = swipeFlingAdapterView.getSelectedView();
            }
        });

    }

    static void makeToast(Context ctx, String s){
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
    }




    @Override
    public void finish() {
        super.finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.in_anim,R.anim.out_anim);
    }
}
