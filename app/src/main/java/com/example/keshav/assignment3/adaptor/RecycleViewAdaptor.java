package com.example.keshav.assignment3.adaptor;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.keshav.assignment3.R;
import com.example.keshav.assignment3.ScreenCActivity;
import com.example.keshav.assignment3.constants.Constants;
import com.example.keshav.assignment3.model.Items;

import java.util.ArrayList;

/**
 * adaptor for recycler View to inflate
 */

public class RecycleViewAdaptor extends RecyclerView.Adapter<RecycleViewAdaptor.ViewHolder> implements Constants {

    private ArrayList<Items> itemList;
    private Context context;
    private int mode;

    /**
     * @param itemList list of items
     * @param context  context to the activty
     * @param mode     mode of adaptor
     */
    public RecycleViewAdaptor(final ArrayList<Items> itemList, final Context context, final int mode) {
        this.itemList = itemList;
        this.context = context;
        this.mode = mode;
    }

    @Override
    public RecycleViewAdaptor.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewholder_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecycleViewAdaptor.ViewHolder holder, final int position) {
        Items item = itemList.get(position);
        holder.tvItemName.setText(item.getItmName());
        holder.tvItemValue.setText(item.getItmValue());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public Void init() {
        return null;
    }

    /**
     * viewHolder that contains the view
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvItemName, tvItemValue, tvNameTitle, tvValTitle;

        /**
         * @param itemView inflated view on which functionality is to be performed
         */
        public ViewHolder(final View itemView) {
            super(itemView);
            tvItemName = (TextView) itemView.findViewById(R.id.tvItemName);
            tvItemValue = (TextView) itemView.findViewById(R.id.tvItemValue);
            if (mode == KEY_NORMAL) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View v) {
                        Intent intent = new Intent(context, ScreenCActivity.class);
                        Bundle bundle = new Bundle();
                        context.startActivity(intent);
                    }
                });
            } else {
                tvNameTitle = (TextView) itemView.findViewById(R.id.tvItmNameTitle);
                tvValTitle = (TextView) itemView.findViewById(R.id.tvItmValTitle);
                tvNameTitle.setVisibility(View.GONE);
                tvValTitle.setVisibility(View.GONE);
            }
        }
    }
}
