package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.recyclerview.ListViewAdapter3;
import com.example.recyclerview.viewclass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class viewexpense extends AppCompatActivity {

    private static final String JSON_URL = "http://192.168.43.36/tolet/admin1/house/read_ptype.php";
    ListView listView;
    String id;
    String title,img;
    List<viewclass> heroList3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewexpense);
        //initializing listview and hero list
        listView = (ListView) findViewById(R.id.listView);
        heroList3 = new ArrayList<>();
        Intent i=getIntent();
        Bundle b=i.getBundleExtra("data");
        title=b.getString("title");
        id=b.getString("id");
        img=b.getString("img");

        loadHeroList();
    }
    private void loadHeroList() {

        RequestQueue queue = Volley.newRequestQueue(viewexpense.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            Log.d("string",response);
                            JSONArray array = new JSONArray(response);

                            //now looping through all the elements of the json array
                            for (int i = 0; i < array.length(); i++) {
                                //getting the json object of the particular index inside the array
                                JSONObject jsonObj = (JSONObject) array.get(i);
                                Log.d("name1",jsonObj.getString("image")+":"+jsonObj.getString("P_Type")+":"+jsonObj.getString("PType_ID"));
                                viewclass hero = new viewclass(jsonObj.getString("PType_ID"), jsonObj.getString("P_Type"),

                                        jsonObj.getString("image"));
                                Log.d("name3","msg");

                                heroList3.add(hero);
                            }

                            ListViewAdapter3 adapter = new ListViewAdapter3(heroList3, getApplicationContext());
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
                map.put("id",id);
                return map;
            }
        };
        queue.add(stringRequest);
    }
}
