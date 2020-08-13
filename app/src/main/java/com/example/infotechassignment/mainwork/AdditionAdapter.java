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
import com.example.infotechassignment.mainwork.modelnew.BentBasicHomeResp;

public class AdditionAdapter extends RecyclerView.Adapter<AdditionAdapter.ViewHolder> {
    Context context;
    BentBasicHomeResp bentBasicHomeResp;

    public AdditionAdapter(BentBasicHomeResp bentBasicHomeResp,Context context){
        this.context = context;
        this.bentBasicHomeResp = bentBasicHomeResp;
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
        Addition addition = bentBasicHomeResp.getAddition().getCategories().get(position);
        holder.tvAdditionName.setText(""+addition.getTitle());
    }

    @Override
    public int getItemCount() {
        return R.layout.item_addition;
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
