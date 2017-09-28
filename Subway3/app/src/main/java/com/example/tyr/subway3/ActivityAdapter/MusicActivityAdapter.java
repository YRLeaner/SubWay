package com.example.tyr.subway3.ActivityAdapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.example.tyr.subway3.OnMyItemClickListener;
import com.example.tyr.subway3.R;
import com.example.tyr.subway3.Utils.BlurTransformation;
import com.example.tyr.subway3.beans.MainMusicRoot;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class MusicActivityAdapter extends DelegateAdapter.Adapter<RecyclerView.ViewHolder> {

        private Context context;
        private LayoutHelper mHelper;
        private VirtualLayoutManager.LayoutParams params;
        private OnMyItemClickListener itemClickListerner;
        static final int TYPE_HEADER = 0;
        static final int TYPE_CELL = 1;
        static final int TYPE_FOOTER = 2;
        private MainMusicRoot mainMusicRoot;
        Target target;
        public void setItemClickListerner(OnMyItemClickListener itemClickListerner) {

            this.itemClickListerner = itemClickListerner;

        }

        public MusicActivityAdapter(Context context, LayoutHelper mHelper, int count,MainMusicRoot musicRoot) {
            this(context,mHelper,count,musicRoot,new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,300));
        }

        public MusicActivityAdapter(Context context, LayoutHelper mHelper, int count, MainMusicRoot mainMusicRoot, VirtualLayoutManager.LayoutParams params) {
            this.context = context;
            this.mHelper = mHelper;
            this.params = params;
            this.mainMusicRoot = mainMusicRoot;

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
                    return new HeaderHolder(LayoutInflater.from(context).inflate(R.layout.music_main_header, parent, false));
                }

                case TYPE_FOOTER: {
                    return new FooterHolder(LayoutInflater.from(context).inflate(R.layout.music_main_footer, parent, false));
                }
            }
            return null;
        }
        @Override

        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            holder.itemView.setLayoutParams(new VirtualLayoutManager.LayoutParams(params));
        }


        @Override
        protected void onBindViewHolderWithOffset(final RecyclerView.ViewHolder holder, int position, final int offsetTotal) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                   Log.i("TAG","---->" + offsetTotal);
                    if (itemClickListerner != null)
                        itemClickListerner.itemClick(v, offsetTotal);
                }
            });

            if (holder instanceof HeaderHolder){
                ((HeaderHolder) holder).musciName.setText(mainMusicRoot.getData().getTitle());
                Picasso.with(context).load(mainMusicRoot.getData().getCover()).into(((HeaderHolder) holder).imageView);
                Picasso.with(context).load(mainMusicRoot.getData().getFeeds_cover()).transform(new BlurTransformation(context)).into(target);
            }else if (holder instanceof FooterHolder){
                ((FooterHolder) holder).textView.setText(Html.fromHtml("  "+mainMusicRoot.getData().getStory()));
            }

        }
        @Override
        public int getItemCount() {
            return mainMusicRoot==null?0:2;
        }

    public void addAll(MainMusicRoot mainMusicRoot) {
        this.mainMusicRoot = mainMusicRoot;
        notifyItemChanged(0);
    }


    private class HeaderHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView musciName;
        LinearLayout linearLayout;
        public HeaderHolder(View itemView) {
            super(itemView);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.music_main_linear);
            imageView = (ImageView)itemView.findViewById(R.id.music_main_header_img);
            musciName = (TextView)itemView.findViewById(R.id.music_main_title);
            target = new Target() {
                @Override
                public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
                    linearLayout.setBackground(new BitmapDrawable(bitmap));
                }

                @Override
                public void onBitmapFailed(Drawable drawable) {

                }

                @Override
                public void onPrepareLoad(Drawable drawable) {

                }
            };
        }
    }

    private class FooterHolder extends RecyclerView.ViewHolder {

        TextView textView;
        public FooterHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.music_main_footer_text);
        }
    }
}