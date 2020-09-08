package com.example.infotechassignment.buildurhome.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infotechassignment.R;
import com.example.infotechassignment.buildurhome.resp.BasicProductResponse;
import com.example.infotechassignment.buildurhome.resp.SelectAdditionResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdditionCategoryAdaptor extends RecyclerView.Adapter<AdditionCategoryAdaptor.AditionViewHolder> {

    BasicProductResponse basicProductResponse;
    Context context;
    List<SelectAdditionResponse.Product> productList;
    List<SelectAdditionResponse.Category>categoryList;

//    public AdditionCategoryAdaptor(Context context, List<SelectAdditionResponse.Category>categoryList) {
//        this.context = context;
//        this.categoryList = categoryList;
//    }

    public AdditionCategoryAdaptor(Context context, List<SelectAdditionResponse.Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public AditionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_select_addirion, parent, false);
        return new AditionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AditionViewHolder holder, int position) {
        SelectAdditionResponse.Product product  = productList.get(position);
        holder.tvProductName.setText(product.getName());
        Picasso.with(context).load(product.getImage()).error(R.drawable.img_default_banner).into(holder.ivForAddition);

//        SelectAdditionResponse.Category category  = categoryList.get(position);
//        holder.tvProductName.setText(category.getProducts().get(position).getName());
//        Picasso.with(context).load(category.getProducts().get(position).getImage()).error(R.drawable.img_default_banner).into(holder.ivForAddition);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class AditionViewHolder extends RecyclerView.ViewHolder {

        private TextView tvProductName, tvAdditionAccessories;
        private ImageView ivForAddition;
        private CheckBox cbImage;
        private RadioGroup rdGrpChecked;

        public AditionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAdditionAccessories = itemView.findViewById(R.id.tvAdditionAccessories);
            ivForAddition = itemView.findViewById(R.id.ivForAddition);
            cbImage = itemView.findViewById(R.id.cbImage);
            tvProductName = itemView.findViewById(R.id.tvProductName);

        }
    }
}
