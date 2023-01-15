package com.fstt.cours.ecommerce.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.fstt.cours.ecommerce.interfaces.ItemClickListner;

public class CardView extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtProductName , txtProductPrice ,txtProductQuantity;
    private ItemClickListner itemClickListner;

    public CardView(@NonNull View itemView) {
        super(itemView);

    }

    @Override
    public void onClick(View v) {
        itemClickListner.onClick(v, getAdapterPosition() ,false);
    }

    public void setItemClickListner(ItemClickListner itemClickListner) {
        this.itemClickListner = itemClickListner;
    }
}