package com.google.codelab.spectaresto.favoritefeature;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.codelab.spectaresto.R;

import java.util.List;

public class FavAdapter extends RecyclerView.Adapter<FavAdapter.ViewHolder> {
    private Context context;
    private List<Favmenu> favmenuList;
    private FavDB favDB;

    private FavAdapter(Context context, List<Favmenu> favItemList)
    {
        this.context = context;
        this.favmenuList = favItemList;
    }


    @NonNull
    @Override
    public FavAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fav_item,parent,false);
        //favDB =new FavDB(context);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull FavAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
