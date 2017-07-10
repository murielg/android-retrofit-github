package com.murielgonzalez.github.adapter;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.Context;

import com.murielgonzalez.github.R;
import com.murielgonzalez.github.model.Item;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by muriel_gonzalez on 5/24/17.
 */

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {
  private static String TAG = ItemsAdapter.class.getSimpleName();
  private List<Item> items;
  private int rowLayout;
  private Context context;
  private ItemClickListener mClickListener;

  public interface ItemClickListener {
    void onClickItem(Item post, int position);
  }

  public static class ItemViewHolder extends RecyclerView.ViewHolder {
    LinearLayout itemsLayout;
    TextView itemName;
    TextView itemUrl;
    ImageView itemImage;

    public ItemViewHolder(View view) {
      super(view);
      itemsLayout = (LinearLayout) view.findViewById(R.id.item_layout);
      itemName = (TextView) view.findViewById(R.id.item_name);
      itemUrl = (TextView) view.findViewById(R.id.item_url);
      itemImage = (ImageView) view.findViewById(R.id.item_image);
    }

  }

  public ItemsAdapter(List<Item> items, int rowLayout, Context context, ItemClickListener listener) {
    this.items = items;
    this.rowLayout = rowLayout;
    this.context = context;
    this.mClickListener = listener;
  }

  @Override
  public ItemsAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
    return new ItemViewHolder(view);

  }

  @Override
  public void onBindViewHolder(ItemViewHolder viewholder, final int position) {
    Item currentItem = items.get(position);
    viewholder.itemName.setText(currentItem.getName());
    viewholder.itemUrl.setText(currentItem.getRepoUrl());

    viewholder.itemsLayout.setTag(currentItem);

    Picasso.with(context)
        .load(currentItem.getAvatarUrl())
        .into(viewholder.itemImage);

    viewholder.itemsLayout.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Item current = (Item) v.getTag();
        Log.d(TAG, "onClick " + current.getName());
        if (mClickListener != null) {
          mClickListener.onClickItem(current, position);
        }
      }
    });
  }

  @Override
  public int getItemCount() {
    return items.size();
  }
}
