package com.example.shortcodemanager;

import android.view.View;

public interface RecyclerViewClickListener {

    void onRowClicked(int position);
    void onViewClicked(View view, int position);
}
