package com.example.infotechassignment.baseadapter;

import android.view.View;

public interface RecyclerItemClickListener {
    <MODEL> void onItemClicked(View view, MODEL item);
}