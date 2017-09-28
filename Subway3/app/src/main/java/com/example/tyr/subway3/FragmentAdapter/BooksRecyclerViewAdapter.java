package com.example.tyr.subway3.FragmentAdapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tyr.subway3.R;
import com.example.tyr.subway3.Utils.CircleTransform;
import com.example.tyr.subway3.beans.MusicRoot;
import com.example.tyr.subway3.OnMyItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class BooksRecyclerViewAdapter extends RecyclerView.Adapter<BooksRecyclerViewAdapter.MyHolder> {


    List<MusicRoot.Data> musicRoots;
    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;
    private Context context;
    private OnMyItemClickListener onMyItemClickListener1;

    public BooksRecyclerViewAdapter( List<MusicRoot.Data> contents,Context context) {
        this.context = context;
        musicRoots = contents;
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
        return musicRoots.size();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType) {
            case TYPE_HEADER: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.books_item, parent, false);
                return new MyHolder(view);

            }
            case TYPE_CELL: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.books_item, parent, false);
                return new MyHolder(view);
            }
        }
        return null;
    }


    public void addAll(List<MusicRoot.Data> collection){
        int size = musicRoots.size();
        musicRoots.addAll(collection);
        Log.d("gank", "add succccc");
        for (int i=0;i<collection.size();i++){
            Log.d("gank",collection.get(i).getTitle());
            Log.d("gank",collection.get(i).getItem_id());
        }
        notifyDataSetChanged();
        //notifyItemRangeChanged(size,musicRoots.size());
    }





    @Override
    public void onBindViewHolder(MyHolder holder, final int position) {
        Log.d("gank","hh2");
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
                holder.newstitle.setText(musicRoots.get(position).getTitle());
                holder.newstxt.setText(musicRoots.get(position).getAuthor().getUser_name());
                Picasso.with(context).load(musicRoots.get(position).getImg_url()).transform(new CircleTransform()).into(holder.newsImage);
                break;
        }
    }


    static class MyHolder extends RecyclerView.ViewHolder {

        ImageView newsImage;
        TextView newstitle;
        TextView newstxt;
        public MyHolder(View itemView) {
            super(itemView);
            newsImage = (ImageView)itemView.findViewById(R.id.news_img);
            newstitle = (TextView)itemView.findViewById(R.id.news_title);
            newstxt = (TextView)itemView.findViewById(R.id.news_txt);
        }
    }

}