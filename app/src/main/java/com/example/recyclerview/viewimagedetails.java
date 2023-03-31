package com.example.recyclerview;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.recyclerview.dashboard.MyPREFERENCES;

public class viewimagedetails extends AppCompatActivity implements View.OnClickListener{
    private static final String JSON_URL = "http://192.168.43.36/tolet/admin1/house/details.php";

   // private int mYear, mMonth, mDay, mHour, mMinute;
   // EditText e1;
  //  Button search;
    //Spinner c;
    //JSONArray array1;
    //JSONObject jsonObj;

    ListView listView;
    String id;
    String title,img;
    String uname;


    List<view2> heroList1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewimagedetails);

        listView = (ListView) findViewById(R.id.listView);
        heroList1 = new ArrayList<>();

        Intent i=getIntent();
        Bundle b=i.getBundleExtra("data");
        title=b.getString("title");
        id=b.getString("PropertyID");
        img=b.getString("img");
        SharedPreferences sharedpreferences=getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);
        uname=sharedpreferences.getString("Name","0");


       // Toast.makeText(this,"Title"+uname,Toast.LENGTH_LONG).show();

       // Toast.makeText(this,"Title"+id,Toast.LENGTH_LONG).show();
        loadHeroList();

    }
    private void loadHeroList() {

        RequestQueue queue = Volley.newRequestQueue(viewimagedetails.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d("string1",response);
                        try {

                            JSONArray array = new JSONArray(response);
                            //now looping through all the elements of the json array
                            for (int i = 0; i < array.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject jsonObj = (JSONObject) array.get(i);
                                Log.d("PropertyID",jsonObj.getString("PropertyID"));
                               /* Log.d("AC",jsonObj.getString("AC"));
                                Log.d("Type",jsonObj.getString("Type"));
                                Log.d("SwimmingPool",jsonObj.getString("SwimmingPool"));
                              // Log.d("SwimmingPool", String.valueOf(jsonObj.getInt("SwimmingPool")));
                                Log.d("Garage",jsonObj.getString("Garage"));
                               Log.d("Inverter",jsonObj.getString("Inverter"));
                                Log.d("pic",jsonObj.getString("pic"));
                                Log.d("Rent",jsonObj.getString("Rent"));
                                Log.d("Localities",jsonObj.getString("Localities"));*/
                                view2 hero = new view2(jsonObj.getString("PropertyID"), jsonObj.getString("OwnerID"),jsonObj.getString("Type"),jsonObj.getString("AC"),jsonObj.getString("SwimmingPool"),jsonObj.getString("Garage"),jsonObj.getString("Inverter"),jsonObj.getString("Rent"),jsonObj.getString("Localities"),jsonObj.getString("pic"),uname);
                                heroList1.add(hero);
                               // view2 hero = new view2(jsonObj.getString("PropertyID"),jsonObj.getString("Type"),jsonObj.getString("SwimmingPool"),jsonObj.getString("Garage"),jsonObj.getString("Inverter"),jsonObj.getString("pic"),uname);
                                //heroList1.add(hero);
                            }

                            ListViewAdapter2 adapter = new ListViewAdapter2(heroList1, getApplicationContext());
                            listView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "my error :" + error, Toast.LENGTH_LONG).show();
                Log.i("My error", "" + error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> map = new HashMap<String, String>();
                map.put("pid",id);
                return map;
            }
        };
        queue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {


    }
}
