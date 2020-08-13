package com.example.infotechassignment.mainwork;

import android.content.Context;
import android.graphics.Color;
import android.graphics.RadialGradient;
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
import com.example.infotechassignment.mainwork.modelnew.BentBasicHomeResp;
import com.example.infotechassignment.mainwork.modelnew.Product;
import com.example.infotechassignment.mainwork.modelnew.Section;

public class SelectionAdapter extends RecyclerView.Adapter<SelectionAdapter.MyViewHolder> {
    Context context;
    BentBasicHomeResp bentBasicHomeResp;

    public SelectionAdapter(BentBasicHomeResp bentBasicHomeResp, Context context) {
        this.context = context;
        this.bentBasicHomeResp = bentBasicHomeResp;
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

        Section section = bentBasicHomeResp.getSections().get(position);
        holder.tvSectionName.setText("" + section.getName());
        holder.rdBtnLivingRoom.setText("" + section.getTitle());
        holder.rdBtnDiningRoom.setText("" + section.getTitle());
        holder.rdBtnBedRoom.setText("" + section.getTitle());


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
                        }
                        break;
                    case R.id.rdBtnDiningRoom:
                        if (isSelected) {
                            holder.rdBtnLivingRoom.setTextColor(Color.GRAY);
                            holder.rdBtnDiningRoom.setTextColor(Color.WHITE);
                            holder.rdBtnBedRoom.setTextColor(Color.GRAY);
                        }
                        break;
                    case R.id.rdBtnBedRoom:
                        if (isSelected) {
                            holder.rdBtnLivingRoom.setTextColor(Color.GRAY);
                            holder.rdBtnDiningRoom.setTextColor(Color.GRAY);
                            holder.rdBtnBedRoom.setTextColor(Color.WHITE);
                        }
                        break;
                }
            }


        });

    }

    @Override
    public int getItemCount() {
        return R.layout.item_section;
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
