package com.example.tyr.subway3.FragmentAdapter;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tyr.subway3.MyVideoView;
import com.example.tyr.subway3.R;
import com.example.tyr.subway3.beans.VideoRoot;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class VideoRecyclerViewAdapter extends RecyclerView.Adapter<VideoRecyclerViewAdapter.MyHolder> {

    VideoRoot contents;
    private Context context;
    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;

    public VideoRecyclerViewAdapter(VideoRoot contents,Context context) {
        this.contents = contents;
        this.context = context;
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
        return contents.getItemList().size();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType) {
            case TYPE_HEADER: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.video_item, parent, false);
                return new MyHolder(view);

            }
            case TYPE_CELL: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.video_item, parent, false);
                return new MyHolder(view);
            }
        }
        return null;
    }


    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        holder.videoView.setOnFullScreenListener(new MyVideoView.OnFullScreenListener() {
            @Override
            public void onFullScreen(int currentPosition) {
               // Intent intent = new Intent(context,)
            }
        });
        String videoUrl1 = Environment.getExternalStorageDirectory().getAbsolutePath()+"/downloads/SubWay3/"+position+".mp4" ;


        switch (getItemViewType(position)) {
            case TYPE_HEADER:

                holder.videoView.setPlayData(videoUrl1);
               // holder.videoView.start();
                Log.d("ser",contents.getItemList().get(position).getData().getPlayUrl());
                break;
            case TYPE_CELL:
                holder.videoView.setPlayData(videoUrl1);
                break;
        }
    }


    static class MyHolder extends RecyclerView.ViewHolder {

        MyVideoView videoView;

        public MyHolder(View itemView) {
            super(itemView);
            videoView = (MyVideoView)itemView.findViewById(R.id.video);

        }
    }

}