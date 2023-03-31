
package com.example.recyclerview;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

public class CarRecyclerViewItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


    private TextView carTitleText = null;
    private TextView cardid = null;
    private ImageView carImageView = null;

    public CarRecyclerViewItemHolder(View itemView) {
        super(itemView);


        if(itemView != null)
        {
            carTitleText = (TextView)itemView.findViewById(R.id.card_view_image_title);
            cardid = (TextView)itemView.findViewById(R.id.id1);
            carImageView = (ImageView)itemView.findViewById(R.id.card_view_image);
        }
       // itemView.setOnClickListener(this);
        carImageView.setOnClickListener(this);
    }

    public TextView getCarTitleText() {
        return carTitleText;
    }

    public ImageView getCarImageView() {
        return carImageView;
    }
    public TextView getCardid() {
        return cardid;
    }

    @Override    public void onClick(View v) {

        int pos=getLayoutPosition();

        Intent intentBundle=new Intent(v.getContext(),viewlandlord.class);
        Bundle bundle=new Bundle();
        bundle.putString("title",getCarTitleText().getText().toString());
        bundle.putString("id",getCardid().getText().toString());
        intentBundle.putExtra("data",bundle);
        v.getContext().startActivity(intentBundle);
      //  Log.d("Msg",getCarTitleText().getText().toString());
       // Toast.makeText(itemView.getContext(), "position = " +getCarTitleText().getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
