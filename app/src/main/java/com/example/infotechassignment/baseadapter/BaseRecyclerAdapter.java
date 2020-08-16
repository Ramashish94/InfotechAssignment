package com.example.infotechassignment.baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class BaseRecyclerAdapter<MODEL, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {
    protected List<MODEL> items;
    protected Context context;
    private RecyclerItemClickListener recyclerItemClickListener;

    protected BaseRecyclerAdapter(Context context, List<MODEL> items) {
        this.context = context;
        this.items = items;
    }

    /**
     * This method is generic and creates view holder as per our requirement
     *
     * @param parent
     * @param viewType
     * @return
     */
    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getItemLayout(viewType), parent, false);
        return onCreateRecyclerViewHolder(view, viewType);
    }

    /**
     * This method binds item, item-position and item-click-listener to the view holder
     *
     * @param holder
     * @param position
     */
    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        try {
            if (items != null && items.size() > 0 && position < items.size()) {
                holder.performBind(items.get(position), position, recyclerItemClickListener);
                onBindRecyclerViewHolder(holder, position);
            } else {
//                AppSingleton.getInstance().showLog("BaseRecyclerAdapter", "Empty List");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setOnItemClickListener(RecyclerItemClickListener recyclerItemClickListener) {
        this.recyclerItemClickListener = recyclerItemClickListener;
    }

    // This method is responsible for list items count
    @Override
    public int getItemCount() {
        return items.size();
    }

    protected abstract int getItemLayout(int viewType);

    // This abstract method is implemented inside child adapter and returns a view holder
    protected abstract VH onCreateRecyclerViewHolder(View view, int viewType);

    // This abstract method is implemented inside child adapter where we can set the data on the UI components
    protected abstract void onBindRecyclerViewHolder(VH holder, int position);

}
