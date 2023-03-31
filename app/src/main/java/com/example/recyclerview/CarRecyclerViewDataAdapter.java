package com.example.recyclerview;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toast;


import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;



import com.google.android.material.snackbar.Snackbar;

import java.util.List;
import java.util.Set;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class CarRecyclerViewDataAdapter extends RecyclerView.Adapter<CarRecyclerViewItemHolder> implements View.OnClickListener {

    private List<CarRecyclerViewItem> carItemList;
    TextView carTitleView;

    TextView cardid;
    ImageView carImageView;

    public CarRecyclerViewDataAdapter(List<CarRecyclerViewItem> carItemList) {
        this.carItemList = carItemList;
    }

    @Override
    public CarRecyclerViewItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
              LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
                final View carItemView = layoutInflater.inflate(R.layout.activity_card_view_item, parent, false);
                carTitleView = (TextView) carItemView.findViewById(R.id.card_view_image_title);
        cardid = (TextView) carItemView.findViewById(R.id.id1);
               carImageView = (ImageView) carItemView.findViewById(R.id.card_view_image);
              carItemView.setOnClickListener(this);
              carImageView.setOnClickListener(this);
              CarRecyclerViewItemHolder ret = new CarRecyclerViewItemHolder(carItemView);


        return ret;
    }

    @Override
    public void onBindViewHolder(CarRecyclerViewItemHolder holder, int position) {

        if (carItemList != null) {
                       CarRecyclerViewItem carItem = carItemList.get(position);

            if (carItemList != null) {
                                holder.getCarTitleText().setText(carItem.getCarName());
                                holder.getCarImageView().setImageResource(carItem.getCarImageId());
                holder.getCardid().setText(carItem.getCardid()+"");

            }
            }
        }

        @Override public int getItemCount () {
            int ret = 0;
            if (carItemList != null) {
                ret = carItemList.size();
            }
            return ret;
        }

        @Override public void onClick (View V){
            // Get car title text.
        }

    }

