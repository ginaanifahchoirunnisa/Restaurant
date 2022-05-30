package com.google.codelab.spectaresto.dao.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.codelab.spectaresto.R;
import com.google.codelab.spectaresto.dao.BookmarkDao;
import com.google.codelab.spectaresto.dao.entity.Bookmark;

import java.util.List;

public class BookmarkAdapter extends ListAdapter<Bookmark, BookmarkAdapter.BookmarkViewHolder> {
    private Context context;



    protected BookmarkAdapter(@NonNull DiffUtil.ItemCallback<Bookmark> diffCallback, Context context) {
        super(diffCallback);
        this.context = context;

    }





    @NonNull
    @Override
    public BookmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_bookmark, parent, false);
        return new BookmarkViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkViewHolder holder, int position) {
        Bookmark currentB = getItem(position);

        holder.bind(currentB.getMenuName(),currentB.getDescription());
        holder.layoutView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Bookmark bookmark = new Bookmark(currentB.getTitle(),currentTask.getDate(),currentTask.getDesc(),currentTask.getCourse(), currentB.getTime());
//                Intent item = new Intent(context, DetailEachTask.class);
//                item.putExtra("task",task);
//                item.putExtra("id", task.id);
//                context.startActivity(item);
            }
        });
    }

    static class BookmarkDiff extends DiffUtil.ItemCallback<Bookmark> {

        @Override
        public boolean areItemsTheSame(@NonNull Bookmark oldItem, @NonNull Bookmark newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Bookmark oldItem, @NonNull Bookmark newItem) {
            return oldItem.getMenuName().equals(newItem.getMenuName());
        }
    }


    class BookmarkViewHolder extends RecyclerView.ViewHolder {

        LinearLayout layoutView;
        private TextView nmenu,ndesc;



        public BookmarkViewHolder(@NonNull View itemView) {
            super(itemView);
            nmenu = itemView.findViewById(R.id.menu_nama);
            ndesc = itemView.findViewById(R.id.menu_deskripsi);
            layoutView = itemView.findViewById(R.id.layoutView);



        }

        public void bind (String name, String desc) {
            nmenu.setText(name);
            ndesc.setText(desc);

        }

        BookmarkViewHolder create(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_bookmark, parent, false);
            return new BookmarkViewHolder(view);
        }
    }

}
