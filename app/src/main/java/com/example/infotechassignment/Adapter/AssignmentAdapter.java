package com.example.infotechassignment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infotechassignment.R;
import com.example.infotechassignment.model.AssignmentResp;
import com.example.infotechassignment.model.Response;


public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.MyViewHolder> {
    Context context;
    AssignmentResp assignmentResp;

    public AssignmentAdapter(AssignmentResp assignmentResp1, Context context1) {
        this.assignmentResp = assignmentResp1;
        this.context = context1;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Response response = assignmentResp.getResponse().get(position);
        holder.tvFname.setText("" + response.getFname());
        holder.tvLname.setText("" + response.getLname());
        holder.tvPersonType.setText("" + response.getType());
        holder.tvConctNum.setText("" + response.getNumber());
        holder.tvAddress.setText("" + response.getAddress());

    }

    @Override
    public int getItemCount() {

        if (assignmentResp != null
                && assignmentResp.getResponse() != null
                && assignmentResp.getResponse().size() > 0) {
            return assignmentResp.getResponse().size();
        } else {
            return 0;
        }
    }

    public void setData(AssignmentResp assignmentResp) {
        this.assignmentResp = assignmentResp;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvFname, tvLname, tvConctNum, tvPersonType, tvAddress;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvFname = itemView.findViewById(R.id.TvFname);
            tvLname = itemView.findViewById(R.id.TvLname);
            tvPersonType = itemView.findViewById(R.id.TvType);
            tvConctNum = itemView.findViewById(R.id.TvConctNumber);
            tvAddress = itemView.findViewById(R.id.TvAddress);
        }
    }
}
