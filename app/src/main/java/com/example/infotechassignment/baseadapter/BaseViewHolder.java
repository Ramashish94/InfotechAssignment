package com.example.infotechassignment.baseadapter;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder<MODEL> extends RecyclerView.ViewHolder implements View.OnClickListener {
    public RecyclerItemClickListener recyclerItemClickListener;
    protected MODEL item;
    protected int position;

    protected BaseViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    final void performBind(MODEL item, int position, RecyclerItemClickListener recyclerItemClickListener) {
        this.item = item;
        this.position = position;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

    @Override
    public void onClick(View view) {
        if (recyclerItemClickListener != null)
            recyclerItemClickListener.onItemClicked(view, item);
    }
}
