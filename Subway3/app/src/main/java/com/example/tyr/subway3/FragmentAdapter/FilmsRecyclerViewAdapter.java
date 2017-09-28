package com.example.tyr.subway3.FragmentAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.tyr.subway3.R;
import com.example.tyr.subway3.Utils.CropSquareTransformation;
import com.example.tyr.subway3.beans.FilmRoot;
import com.example.tyr.subway3.OnMyItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class FilmsRecyclerViewAdapter extends RecyclerView.Adapter<FilmsRecyclerViewAdapter.MyHolder> {


    List<FilmRoot.Subjects> filmRoots;
    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;
    private Context context;
    private OnMyItemClickListener onMyItemClickListener1;

    public FilmsRecyclerViewAdapter(List<FilmRoot.Subjects> contents, Context context) {
        this.context = context;
        filmRoots = contents;
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
        return filmRoots.size();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType) {
            case TYPE_HEADER: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.film_item, parent, false);
                return new MyHolder(view);

            }
            case TYPE_CELL: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.film_item, parent, false);
                return new MyHolder(view);
            }
        }
        return null;
    }


    public void addAll(List<FilmRoot.Subjects> collection){
        int size = filmRoots.size();
        filmRoots.addAll(collection);
        Log.d("gank", "add succccc");

       // notifyItemRangeChanged(size,filmRoots.size());
       // this.notifyItemRangeChanged(size, filmRoots.size());
        Log.d("gank","局部刷新");
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
                        if (onMyItemClickListener1 != null) {
                            onMyItemClickListener1.itemClick(v, position);
                        }
                    }
                });

                  holder.textView.setText(filmRoots.get(position).getTitle());
                  holder.textYear.setText(filmRoots.get(position).getYear());
                  holder.textStar.setText(filmRoots.get(position).getRating().getAverage()+"分");
                  holder.textDir.setText(filmRoots.get(position).getDirectors().get(0).getName()+" 导演");
                  holder.textCast.setText(filmRoots.get(position).getCasts().get(0).getName() + " 主演");

                  holder.ratingBar.setRating(Integer.valueOf(filmRoots.get(position).getRating().getStars())/10);
                  StringBuilder sb = new StringBuilder();
                  for (int i=0;i<filmRoots.get(position).getGenres().size();i++){
                      sb.append(filmRoots.get(position).getGenres().get(i) + " ");
                  }
                  holder.textFenLei.setText(sb.toString());
                  Picasso.with(context).load(filmRoots.get(position).getImages().getMedium()).transform(new CropSquareTransformation()).tag("filmPicassico").into(holder.videoView);

                break;
        }
    }



    static class MyHolder extends RecyclerView.ViewHolder {

        ImageView videoView;
        TextView textView;
        TextView textYear;
        TextView textStar;
        TextView textDir;
        TextView textCast;
        TextView textFenLei;
        RatingBar ratingBar;
        public MyHolder(View itemView) {
            super(itemView);
            ratingBar = (RatingBar)itemView.findViewById(R.id.film_rating);
            videoView = (ImageView)itemView.findViewById(R.id.film_video);
            textView = (TextView)itemView.findViewById(R.id.film_title);
            textYear = (TextView)itemView.findViewById(R.id.film_year);
            textStar = (TextView)itemView.findViewById(R.id.film_star);
            textDir = (TextView)itemView.findViewById(R.id.film_directior);
            textCast = (TextView)itemView.findViewById(R.id.film_casts);
            textFenLei = (TextView)itemView.findViewById(R.id.fenlei);
            ratingBar.setEnabled(false);
        }
    }



}