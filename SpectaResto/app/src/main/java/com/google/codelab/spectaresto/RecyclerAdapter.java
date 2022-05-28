package com.google.codelab.spectaresto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<DataItem> dataMenu;
    private Context mContext;


    public RecyclerAdapter(List<DataItem> dataMenu, Context mContext) {
        this.dataMenu = dataMenu;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.menuName.setText(dataMenu.get(i).getMenuName());
        Glide.with(mContext).load(dataMenu.get(i).getImages()).into(viewHolder.imgMenu);
    }

    @Override
    public int getItemCount() {
        return dataMenu.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_menu)
        ImageView imgMenu;
        @BindView(R.id.menu_name)
        TextView menuName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}