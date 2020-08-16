package com.example.infotechassignment.mainwork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infotechassignment.R;
import com.example.infotechassignment.mainwork.modelnew.Addition;
import com.example.infotechassignment.mainwork.modelnew.BentBasicHomeResponse;
import com.example.infotechassignment.mainwork.modelnew.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdditionAdapter extends RecyclerView.Adapter<AdditionAdapter.ViewHolder> {
    Context context;
    BentBasicHomeResponse bentBasicHomeResponse;
    List<Addition>additions;
    List<Category>categories;

    public AdditionAdapter(BentBasicHomeResponse bentBasicHomeResponse, Context context, List<Addition>additions){
        this.context = context;
        this.bentBasicHomeResponse = bentBasicHomeResponse;
        this.additions=additions;
    }

    public AdditionAdapter(Context applicationContext, List<Addition> additions,List<Category>categories) {
        this.context = applicationContext;
        this.additions=additions;
        this.categories = categories;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_addition, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Addition addition = bentBasicHomeResponse.getAddition().getCategories().get(position);
        holder.tvAdditionName.setText(""+addition.getTitle());
        Category category = bentBasicHomeResponse.getAddition().getCategories().get(position);
        Picasso.with(context).load(category.getImage()).into(holder.ivAddition);


    }

    @Override
    public int getItemCount() {
        if (additions.size()>0){
        }else {
            return 0;
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivAddition;
        private TextView tvAdditionName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivAddition = itemView.findViewById(R.id.ivAddition);
            tvAdditionName= itemView.findViewById(R.id.ivAddition);
        }
    }
}
