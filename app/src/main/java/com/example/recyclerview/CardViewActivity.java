package com.example.recyclerview;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class CardViewActivity extends AppCompatActivity {


    private List<CarRecyclerViewItem> cardItemList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        setTitle("To Let");
        initializeCarItemList();
                RecyclerView carRecyclerView = (RecyclerView)findViewById(R.id.card_view_recycler_list);
               GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
              carRecyclerView.setLayoutManager(gridLayoutManager);
               CarRecyclerViewDataAdapter carDataAdapter = new CarRecyclerViewDataAdapter(cardItemList);
               carRecyclerView.setAdapter(carDataAdapter);


    }

    /* Initialise car items in list. */
    private void initializeCarItemList() {
        if (cardItemList == null) {
            cardItemList = new ArrayList<CarRecyclerViewItem>();
            cardItemList.add(new CarRecyclerViewItem("Single", R.drawable.image1, 1));
            cardItemList.add(new CarRecyclerViewItem("4BHK", R.drawable.image2, 2));
            cardItemList.add(new CarRecyclerViewItem("3BHK", R.drawable.image3, 3));
            cardItemList.add(new CarRecyclerViewItem("2BHK", R.drawable.im4, 4));
            cardItemList.add(new CarRecyclerViewItem("Independent", R.drawable.image2, 5));
            cardItemList.add(new CarRecyclerViewItem("5BHK", R.drawable.image1, 6));

        }
    }
}

