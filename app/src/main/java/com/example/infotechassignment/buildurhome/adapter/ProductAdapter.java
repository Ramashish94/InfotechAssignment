package com.example.infotechassignment.buildurhome.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infotechassignment.R;
import com.example.infotechassignment.buildurhome.resp.BasicProductResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    BasicProductResponse basicProductResponse;
    Context context;
    List<BasicProductResponse.Product>productList;
    List<BasicProductResponse.Category>categoryList;

    public ProductAdapter(Context context, List<BasicProductResponse.Category> categoryList1) {
        this.context = context;
        this.categoryList = categoryList1;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        BasicProductResponse.Category category  = categoryList.get(position);
        holder.tvChooseYourRoom.setText(category.getName());
        Picasso.with(context).load(category.getProducts().get(position).getImage()).error(R.drawable.img_default_banner).into(holder.ivChooseSection);
        holder.tvSofaSetName.setText(category.getProducts().get(position).getName());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private TextView tvChooseYourRoom, tvSofaSetName;
        private ImageView ivChooseSection;
        private CheckBox cbLivingRoom;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tvChooseYourRoom = itemView.findViewById(R.id.tvChooseYourRoom);
            tvSofaSetName = itemView.findViewById(R.id.tvSofaSetName);
            ivChooseSection = itemView.findViewById(R.id.ivChooseSection);
            cbLivingRoom = itemView.findViewById(R.id.cbLivingRoom);
        }
    }
}
