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

import com.squareup.picasso.Picasso;

import java.util.List;


/**

 */
public class ListViewAdapter3 extends ArrayAdapter<viewclass> implements View.OnClickListener {
    //the hero list that will be displayed
    private List<viewclass> heroList3;
    // TextView Registration_ID;
    //TextView car_owner_name;
    //  TextView cartype_ID;
    TextView PType_ID;
    TextView P_Type;


    ImageView img1;
    viewclass hero;
    //the context object
    private Context mCtx;


    public ListViewAdapter3(List<viewclass> heroList3, Context mCtx) {
        super(mCtx, R.layout.populatelist4, heroList3);
        this.heroList3 = heroList3;
        this.mCtx = mCtx;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View listViewItem = inflater.inflate(R.layout.populatelist4, null, true);


        PType_ID=(TextView) listViewItem.findViewById(R.id.PType_ID);
        P_Type=(TextView) listViewItem.findViewById(R.id.P_Type);
        // Registration_ID=(TextView) listViewItem.findViewById(R.id.rid);
        //car_owner_name=(TextView) listViewItem.findViewById(R.id.date);
        img1 = (ImageView) listViewItem.findViewById(R.id.img1);

        //img1 = (ImageView) listViewItem.findViewById(R.id.img1);
        hero = heroList3.get(position);
        //rid.setText(hero.id+"");
         PType_ID.setText(hero.PType_ID);
        P_Type.setText(hero.P_Type);
        Log.d("name4","msg");


        Picasso.get().load("http://192.168.43.36/tolet/admin1//house/"+hero.img1).resize(1000,500).into(img1);

        img1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(),"hi"+heroList.get(position).getSub(),Toast.LENGTH_LONG).show();
                Intent intentBundle = new Intent(v.getContext(), viewlandlord.class);
                intentBundle.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                Bundle bundle = new Bundle();
                bundle.putString("id", heroList3.get(position).getPType_ID());
                intentBundle.putExtra("data", bundle);
               // Log.d("Msg", heroList3.get(position).getP_Type());
                v.getContext().startActivity(intentBundle);

            }
        });
        return listViewItem;

    }

    @Override
    public void onClick(View v) {


    }
}