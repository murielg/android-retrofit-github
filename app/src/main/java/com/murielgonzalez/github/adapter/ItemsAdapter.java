package com.murielgonzalez.github.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;

import com.murielgonzalez.github.R;
import com.murielgonzalez.github.model.Item;

import java.util.List;
/**
 * Created by muriel_gonzalez on 5/24/17.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {
    private List<Item> items;
    private int rowLayout;
    private Context context;

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        LinearLayout itemsLayout;
        TextView itemName;
        TextView itemUrl;

        public ItemViewHolder(View view) {
            super(view);
            itemsLayout = (LinearLayout) view.findViewById(R.id.item_layout);
            itemName = (TextView) view.findViewById(R.id.item_name);
            itemUrl = (TextView) view.findViewById(R.id.item_url);
        }

    }

    public ItemsAdapter(List<Item> items, int rowLayout, Context context) {
        this.items = items;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public ItemsAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent,false);
        return new ItemViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ItemViewHolder viewholder, final int position) {
        viewholder.itemName.setText(items.get(position).getName());
        viewholder.itemUrl.setText(items.get(position).getRepoUrl());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
