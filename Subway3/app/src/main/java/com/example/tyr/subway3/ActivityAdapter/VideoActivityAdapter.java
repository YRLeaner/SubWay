package com.example.tyr.subway3.ActivityAdapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.example.tyr.subway3.OnMyItemClickListener;
import com.example.tyr.subway3.R;
import com.example.tyr.subway3.Utils.BlurTransformation;
import com.example.tyr.subway3.Utils.CropSquareTransformation;
import com.example.tyr.subway3.beans.MainFilmRoot;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

/**
* Created by tyr on 2017/8/21.
*/
public class VideoActivityAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private LayoutHelper mHelper;
    private VirtualLayoutManager.LayoutParams params;
    private OnMyItemClickListener onItemClickitemClickListerner;
    private MainFilmRoot mainFilmRoot;
    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;
    static final int TYPE_FOOTER = 2;

    public void setItemClickListerner(OnMyItemClickListener itemClickListerner) {

        this.onItemClickitemClickListerner = itemClickListerner;

    }

    public VideoActivityAdapter(Context context, LayoutHelper mHelper, int count, MainFilmRoot mainFilmRoot) {
        this(context,mHelper,count,mainFilmRoot,new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,300));
    }

    public VideoActivityAdapter(Context context, LayoutHelper mHelper, int count, MainFilmRoot mainFilmRoot, VirtualLayoutManager.LayoutParams params) {
        this.context = context;
        this.mHelper = mHelper;
        this.params = params;
        this.mainFilmRoot = mainFilmRoot;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_HEADER;
            default:
                return TYPE_FOOTER;
        }
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mHelper;
    }

    @Override

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case TYPE_HEADER: {
                return new HeaderHolder(LayoutInflater.from(context).inflate(R.layout.film_main_header, parent, false));
            }
            case TYPE_CELL: {
                //return new MyHolder(LayoutInflater.from(context).inflate(R.layout.list_item_card_small, parent, false));
            }
            case TYPE_FOOTER: {
                return new FooterHolder(LayoutInflater.from(context).inflate(R.layout.film_main_footer, parent, false));
            }
        }
        return null;
    }
    @Override

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.itemView.setLayoutParams(new VirtualLayoutManager.LayoutParams(params));
    }

    public void addAll(MainFilmRoot content){
        mainFilmRoot = content;
        notifyItemChanged(0);
    }


    @Override
    protected void onBindViewHolderWithOffset(final RecyclerView.ViewHolder holder, int position, final int offsetTotal) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                   Log.i("TAG","---->" + offsetTotal);
                if (onItemClickitemClickListerner != null)
                    onItemClickitemClickListerner.itemClick(v, offsetTotal);
            }
        });

        if (holder instanceof HeaderHolder){
            ((HeaderHolder) holder).filmName.setText(mainFilmRoot.getTitle());
            ((HeaderHolder) holder).d1.append("主演：");
            for (int i=0;i<mainFilmRoot.getCasts().size();i++){
                ((HeaderHolder) holder).d1.append(mainFilmRoot.getCasts().get(i).getName()+"  ");
            }
            ((HeaderHolder) holder).d2.append("导演：");
            for (int i=0;i<mainFilmRoot.getDirectors().size();i++){
                ((HeaderHolder) holder).d2.append(mainFilmRoot.getDirectors().get(i).getName()+"  ");
            }
            ((HeaderHolder) holder).textYear.setText(mainFilmRoot.getYear() + "   " + mainFilmRoot.getCountries().get(0));
            Picasso.with(context).load(mainFilmRoot.getImages().getLarge()).transform(new CropSquareTransformation()).tag("filmpica").into(((HeaderHolder) holder).imageView);


        }else if (holder instanceof FooterHolder){
            ((FooterHolder) holder).textView.setText("  "+mainFilmRoot.getSummary());
        }

    }
    @Override
    public int getItemCount() {
        return mainFilmRoot==null?0:2;
    }


    private class HeaderHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView filmName;
        TextView textYear;
        TextView d1;
        TextView d2;

        public HeaderHolder(View itemView) {
            super(itemView);

            imageView = (ImageView)itemView.findViewById(R.id.film_main_header_img);
            filmName = (TextView)itemView.findViewById(R.id.film_main_title);
            textYear = (TextView)itemView.findViewById(R.id.film_main_year);
            d1 = (TextView)itemView.findViewById(R.id.film_main_d1);
            d2 = (TextView)itemView.findViewById(R.id.film_main_d2);
        }
    }

    private class FooterHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public FooterHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.film_main_footer_text);
        }
    }
}
