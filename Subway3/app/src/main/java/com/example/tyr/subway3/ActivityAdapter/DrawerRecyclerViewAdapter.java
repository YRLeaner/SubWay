package com.example.tyr.subway3.ActivityAdapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tyr.subway3.OnMyItemClickListener;
import com.example.tyr.subway3.R;
import com.kyleduo.switchbutton.SwitchButton;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class DrawerRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<String> contents;
    List<Integer> imges;
    private Context context;
    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;
    private OnMyItemClickListener onMyItemClickListener;
    private OnCheckedLiseneter checkedLiseneter;

    public void setCheckedLiseneter(OnCheckedLiseneter checkedLiseneter) {
        this.checkedLiseneter = checkedLiseneter;
    }

    public void setOnMyItemClickListener(OnMyItemClickListener onMyItemClickListener) {
        this.onMyItemClickListener = onMyItemClickListener;
    }

    public DrawerRecyclerViewAdapter(Context context,List<String> contents) {
        this.context = context;
        this.contents = contents;
    }



    public DrawerRecyclerViewAdapter(Context context, List<String> contents, List<Integer> imges) {
        this.context = context;
        this.contents = contents;
        this.imges = imges;
    }



    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
            case 1:
                return TYPE_HEADER;
            default:
                return TYPE_CELL;
        }
    }

    @Override
    public int getItemCount() {
        return contents.size()+1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType) {
            case TYPE_HEADER:{
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.drawer_item, parent, false);
                return new MyHolder(view);
            }
            case TYPE_CELL: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.drawer_item2, parent, false);
                return new MyHolder2(view);
            }
        }
        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {



        switch (getItemViewType(position)) {
            case TYPE_HEADER:{
                if (onMyItemClickListener!=null){
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onMyItemClickListener.itemClick(v,position);
                        }
                    });
                }
                ((MyHolder)holder).textView.setText(contents.get(position));
                if (imges!=null&&imges.size()!=0){
                    Picasso.with(context).load(imges.get(position)).into(((MyHolder)holder).imageView);
                }
                break;
            }
            case TYPE_CELL:

                SharedPreferences preferences=context.getSharedPreferences("SubWay3", Context.MODE_PRIVATE);
                boolean isChecked = preferences.getBoolean("check", false);
                if (isChecked){
                    ((MyHolder2)holder).switchButton.setChecked(true);
                }else {
                    ((MyHolder2)holder).switchButton.setChecked(false);
                }

               if (checkedLiseneter!=null){
                   ((MyHolder2)holder).switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                       @Override
                       public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            checkedLiseneter.oncheckChanged(buttonView,isChecked);
                       }
                   });
               }
                break;
        }
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public MyHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.drawer_img);
            textView = (TextView)itemView.findViewById(R.id.drawer_title);
        }
    }

    public class MyHolder2 extends RecyclerView.ViewHolder{

        SwitchButton switchButton;
        public MyHolder2(View itemView) {
            super(itemView);
            switchButton = (SwitchButton)itemView.findViewById(R.id.draw_switch);
        }
    }

    public interface OnCheckedLiseneter{
        public void oncheckChanged(CompoundButton buttonView, boolean isChecked);
    }
}