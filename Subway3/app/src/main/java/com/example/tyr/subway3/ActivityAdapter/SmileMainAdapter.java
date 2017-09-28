package com.example.tyr.subway3.ActivityAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tyr.subway3.R;
import com.example.tyr.subway3.beans.DuanZiBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tyr on 2017/8/19.
 */
public class SmileMainAdapter extends ArrayAdapter<DuanZiBean.Datum>{

    private List<DuanZiBean.Datum> datums;
    private LayoutInflater mInflater;
    private int mResourceId;

    public SmileMainAdapter(Context context, int resource, List<DuanZiBean.Datum> datums) {
        super(context, resource, datums);
        this.datums = datums;
        this.mResourceId = resource;
    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DuanZiBean.Datum datum = datums.get(position);
        View view = LayoutInflater.from(parent.getContext()).inflate(mResourceId, parent, false);
        TextView  textView = (TextView)view.findViewById(R.id.helloText);
        TextView  textName = (TextView)view.findViewById(R.id.smile_author_name);
        ImageView imgeView = (ImageView)view.findViewById(R.id.smile_author_img);
        textView.setText("  "+datum.getGroup().getText());
        textName.setText(datum.getGroup().getUser().getName());
        Picasso.with(getContext()).load(datum.getGroup().getUser().getAvatarUrl()).into(imgeView);
        return view;
      /*  MyHolder myHolder;
        if (convertView==null){
            myHolder = new MyHolder();
            convertView = mInflater.inflate(R.layout.item,null);
            myHolder.textView = (TextView)convertView.findViewById(R.id.helloText);
            convertView.setTag(myHolder);
        }else {
            myHolder = (MyHolder)convertView.getTag();
        }

        myHolder.textView.setText(datums.get(position).getGroup().getText());
        return convertView;*/
    }
}
