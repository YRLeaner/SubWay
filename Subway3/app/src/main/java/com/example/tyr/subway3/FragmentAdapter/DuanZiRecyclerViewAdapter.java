package com.example.tyr.subway3.FragmentAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tyr.subway3.R;
import com.example.tyr.subway3.beans.DuanZiBean;
import com.example.tyr.subway3.OnMyItemClickListener;

import java.util.List;
import java.util.Random;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class DuanZiRecyclerViewAdapter extends RecyclerView.Adapter<DuanZiRecyclerViewAdapter.MyHolder> {


    List<DuanZiBean.Datum> duanZis;
    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;
    private Context context;
    private Random mRandom;
    private OnMyItemClickListener onMyItemClickListener1;

    public DuanZiRecyclerViewAdapter(List<DuanZiBean.Datum> contents, Context context) {
        this.context = context;
        mRandom = new Random();
        duanZis = contents;
    }
    public void setOnItemClickListener(OnMyItemClickListener onMyItemClickListener2){
        onMyItemClickListener1 = onMyItemClickListener2;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_HEADER;
            default:
                return TYPE_CELL;
        }
    }

    @Override
    public int getItemCount() {
        return duanZis.size();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType) {
            case TYPE_HEADER: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.smile_item, parent, false);
                return new MyHolder(view);

            }
            case TYPE_CELL: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.smile_item, parent, false);
                return new MyHolder(view);
            }
        }
        return null;
    }


    public void addAll(List<DuanZiBean.Datum> collection){
        int size = duanZis.size();
        duanZis.addAll(collection);
        Log.d("gank", "add succccc");

      /*  for (int i=0;i<collection.size();i++){
            Log.d("gank",i+"");
        }*/
       // notifyDataSetChanged();
       // notifyItemRangeChanged(size,duanZis.size());
        Log.d("gank","duan"+duanZis.size());
    }





    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        Log.d("gank","hh");
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                //holder.newstitle.setText(musicRoots.get(position).getTitle());
                //Picasso.with(this).load(xBookRoots.get(position).getImage())


            case TYPE_CELL:

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (onMyItemClickListener1 !=null){
                            onMyItemClickListener1.itemClick(v,position);
                        }
                    }
                });
                Log.d("gank","bind+");
                holder.smiletxt.setText("    " + duanZis.get(position).getGroup().getText());
                break;
        }
    }



    static class MyHolder extends RecyclerView.ViewHolder {


        TextView smiletxt;
        public MyHolder(View itemView) {
            super(itemView);

            smiletxt = (TextView)itemView.findViewById(R.id.smile_txt);
        }
    }

    private double getRandomHeightRatio() {

        return (mRandom.nextDouble() / 2.0) + 1.0; // height will be 1.0 - 1.5 the width

    }
}