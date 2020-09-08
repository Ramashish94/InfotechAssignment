package com.example.infotechassignment.mainwork;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infotechassignment.R;
import com.example.infotechassignment.mainwork.modelnew.BentBasicHomeResponse;
import com.example.infotechassignment.mainwork.modelnew.Product;
import com.example.infotechassignment.mainwork.modelnew.Section;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SectionAdapter extends RecyclerView.Adapter<SectionAdapter.MyViewHolder> {
    Context context;
    BentBasicHomeResponse bentBasicHomeResponse;
    List<Section>sections;
    List<Product>products;

    public SectionAdapter(BentBasicHomeResponse bentBasicHomeResponse, Context context) {
        this.context = context;
        this.bentBasicHomeResponse = bentBasicHomeResponse;
    }

    public SectionAdapter(Context applicationContext, List<Section>sections,List<Product> products) {
        this.context = applicationContext;
        this.sections=sections;
        this.products = products;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_section, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Section section = bentBasicHomeResponse.getSections().get(position);
        holder.tvSectionName.setText("" + section.getName());
        List<Product> product=section.getProducts();
        holder.rdBtnLivingRoom.setText("" + product.get(0).getName());
        holder.rdBtnDiningRoom.setText("" + product.get(1).getName());
        holder.rdBtnBedRoom.setText("" + product.get(2).getName());

        holder.radioGrpChecked.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                boolean isSelected = true;
                switch (checkedId) {
                    case R.id.rdBtnLivingRoom:
                        if (isSelected) {
                            holder.rdBtnLivingRoom.setTextColor(Color.WHITE);
                            holder.rdBtnDiningRoom.setTextColor(Color.GRAY);
                            holder.rdBtnBedRoom.setTextColor(Color.GRAY);
                            Picasso.with(context).load(product.get(0).getImage()).error(R.drawable.img_default_banner).into(holder.ivForLivingDiningBedRoom);
                        }
                        break;
                    case R.id.rdBtnDiningRoom:
                        if (isSelected) {
                            holder.rdBtnLivingRoom.setTextColor(Color.GRAY);
                            holder.rdBtnDiningRoom.setTextColor(Color.WHITE);
                            holder.rdBtnBedRoom.setTextColor(Color.GRAY);
                            Picasso.with(context).load(product.get(1).getImage()).error(R.drawable.place_holder_imag).into(holder.ivForLivingDiningBedRoom);

                        }
                        break;
                    case R.id.rdBtnBedRoom:
                        if (isSelected) {
                            holder.rdBtnLivingRoom.setTextColor(Color.GRAY);
                            holder.rdBtnDiningRoom.setTextColor(Color.GRAY);
                            holder.rdBtnBedRoom.setTextColor(Color.WHITE);
                            Picasso.with(context).load(product.get(2).getImage()).error(R.drawable.img_default_banner).into(holder.ivForLivingDiningBedRoom);

                        }
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return bentBasicHomeResponse.getSections().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvSectionName, tvSectionPrice;
        private AppCompatRadioButton rdBtnLivingRoom, rdBtnDiningRoom, rdBtnBedRoom;
        private ImageView ivForLivingDiningBedRoom;
        private Button btnAddLivingRoomToCart, btnBuildUrHome, btnViewDetails;
        private CardView cvSection;
        RadioGroup radioGrpChecked;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvSectionName = itemView.findViewById(R.id.tvSectionName);
            rdBtnLivingRoom = itemView.findViewById(R.id.rdBtnLivingRoom);
            rdBtnDiningRoom = itemView.findViewById(R.id.rdBtnDiningRoom);
            rdBtnBedRoom = itemView.findViewById(R.id.rdBtnBedRoom);
            ivForLivingDiningBedRoom = itemView.findViewById(R.id.ivForLivingDiningBedRoom);
            btnAddLivingRoomToCart = itemView.findViewById(R.id.btnAddLivingRoomToCart);
            btnBuildUrHome = itemView.findViewById(R.id.btnBuildUrHome);
            btnViewDetails = itemView.findViewById(R.id.btnViewDetails);
            cvSection = itemView.findViewById(R.id.cvSection);
            radioGrpChecked = itemView.findViewById(R.id.radioGrpChecked);
        }
    }
}
