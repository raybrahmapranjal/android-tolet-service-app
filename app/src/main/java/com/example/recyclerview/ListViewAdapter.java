package com.example.recyclerview;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by surajit.
 */

public class ListViewAdapter extends ArrayAdapter<view>  implements View.OnClickListener  {

    //the hero list that will be displayed
    private List<view> heroList;
    TextView PropertyID;
    TextView OwnerID;
    TextView Type;
    ImageView img1;
    TextView Rent;
    TextView AC;
    TextView SwimmingPool;
    TextView Garage;
    TextView Inverter;
    TextView Localities;
    view hero;
    //the context object
    private Context mCtx;


    //here we are getting the herolist and context
//so while creating the object of this adapter class we need to give herolist and context
    public ListViewAdapter(List<view> heroList, Context mCtx) {
        super(mCtx, R.layout.populatelist2, heroList);
        this.heroList = heroList;
        this.mCtx = mCtx;
    }

    //this method will return the list item
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
//getting the layoutinflater
        LayoutInflater inflater = LayoutInflater.from(mCtx);

//creating a view with our xml layout
        View listViewItem = inflater.inflate(R.layout.populatelist2, null, true);

//getting text views
         PropertyID = (TextView) listViewItem.findViewById(R.id.PropertyID);
        // OwnerID = (TextView) listViewItem.findViewById(R.id.OwnerID);

         Type = (TextView) listViewItem.findViewById(R.id.Type);
         Rent = (TextView) listViewItem.findViewById(R.id.Rent);

         Localities = (TextView) listViewItem.findViewById(R.id.Localities);
        img1 = (ImageView) listViewItem.findViewById(R.id.img1);
         hero = heroList.get(position);

        Type.setText(hero.Type);
//Toast.makeText(mCtx, ""+hero.date,Toast.LENGTH_SHORT).show();
        Rent.setText(hero.Rent);

        Localities.setText(hero.Localities);
        PropertyID.setText(hero.PropertyID+"");
        Log.d("property id",hero.getPropertyID()+"");

        // OwnerID.setText(hero.OwnerID+"");
//total.setText(Integer.toString(hero.total));
       Picasso.get().load("http://192.168.43.36/tolet/admin1//house/"+hero.img1).into(img1);
      //  PropertyID.setOnClickListener(this);
        img1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(),"hi"+heroList.get(position).getSub(),Toast.LENGTH_LONG).show();
                Intent intentBundle = new Intent(v.getContext(), viewimagedetails.class);
                intentBundle.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                Bundle bundle = new Bundle();
                bundle.putString("PropertyID", heroList.get(position).getPropertyID()+"");
              // Toast.makeText(v.getContext(),"test"+heroList.get(position).getPropertyID()+"",Toast.LENGTH_LONG).show();
                intentBundle.putExtra("data", bundle);

                v.getContext().startActivity(intentBundle);


            }
        });
        return listViewItem;

    }

    @Override
    public void onClick(View v) {

        Toast.makeText(v.getContext(),"msg"+hero.PropertyID,Toast.LENGTH_LONG).show();

        //intentBundle.putExtra("data", bundle)
        // v.getContext().startActivity(intentBundle);


    }
}


