package com.study.eren.recyclerviewitemdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by smartOrange_5 on 2018/1/7.
 * <p>
 * RecyclerView适配器
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private String[] data;
    private Context context;
    private OnItemClickListener onitemClickListener = null;

    public MyAdapter(Context context, String[] data) {
        this.data = data;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemClickListener onitemClickListener) {
        this.onitemClickListener = onitemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);

        void onItemLongClick(int position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onitemClickListener != null) {
                    onitemClickListener.onItemClick((Integer) v.getTag());
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onitemClickListener != null) {
                    onitemClickListener.onItemLongClick((Integer) v.getTag());
                }
                return true;
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.textView.setText(data[position]);
        holder.itemView.setTag(position);

    }


    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
        }
    }
}
