package com.google.codelab.spectaresto;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.codelab.spectaresto.favoritefeature.FavDB;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> implements Filterable {
    private List<DataItem> dataMenu;
    private List<DataItem> dataMenuFull;
    private Context mContext;
    private FavDB favDB;
    public static final String EXTRA_MESSAGE = "com.google.codelab.spectaresto.extra.MESSAGE";

    public RecyclerAdapter(List<DataItem> dataMenu, Context mContext) {
        this.dataMenu = dataMenu;
        this.dataMenuFull = new ArrayList<>(dataMenu);
        this.mContext = mContext;
    }


    public void setFilteredList(List<DataItem> filteredList)
    {
        this.dataMenu = filteredList;
        notifyDataSetChanged();
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
        Glide.with(mContext).load(dataMenu.get(i).getImages().get(0)).into(viewHolder.imgMenu);
    }

    @Override
    public int getItemCount() {
        return dataMenu.size();
    }

    @Override
    public Filter getFilter() {
        return dataFilter;
    }

    private Filter dataFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            List<DataItem> filteredList = new ArrayList<>();
            if(charSequence == null || charSequence.length()== 0)
            {
                filteredList.addAll(dataMenuFull);
            }else{
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for(DataItem item :  dataMenuFull)
                {
                    if(item.getMenuName().toLowerCase().contains(filterPattern))
                    {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            dataMenu.clear();
            dataMenu.addAll((List) filterResults.values);
            notifyDataSetChanged();
        }
    };

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.img_menu)
        ImageView imgMenu;
        @BindView(R.id.menu_name)
        TextView menuName;

        Button favbtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            favbtn = itemView.findViewById(R.id.fav_btn);
            favbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String namaMenu = dataMenu.get(getLayoutPosition()).getMenuName();
                    String deskripsi = dataMenu.get(getLayoutPosition()).getDescription();
                    String id = dataMenu.get(getLayoutPosition()).getId();
                    favDB.insertIntoDatabase(namaMenu,1,id,"1");


                }
            });

            itemView.setOnClickListener(this::onClick);
        }

        @Override
        public void onClick(View view) {
            String idMenu = dataMenu.get(getLayoutPosition()).getId();
            Intent intent = new Intent(view.getContext(), MenuDetails.class);
            intent.putExtra(EXTRA_MESSAGE, idMenu);
            view.getContext().startActivity(intent);
        }
    }
}