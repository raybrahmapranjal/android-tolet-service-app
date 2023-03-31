package com.example.recyclerview;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
//import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.recyclerview.R;
import com.example.recyclerview.view;
import com.example.recyclerview.view2;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.Context.MODE_PRIVATE;
import static com.example.recyclerview.dashboard.MyPREFERENCES;

public class ListViewAdapter2 extends ArrayAdapter<view2> implements View.OnClickListener {

    private int mYear, mMonth, mDay, mHour, mMinute;
    //   EditText e1, e2;
    Button search,e1,e2;
    Spinner c;
    JSONArray array1;
    JSONObject jsonObj;

    //the hero list that will be displayed
    private List<view2> heroList1;
    TextView id1;
    TextView Type;
    TextView AC;
    TextView SwimmingPool;
    TextView Garage;
    TextView Inverter;
    TextView Rent;
    TextView Localities;
    TextView date;
    ImageView img1;
    view2 hero;
    Button btn1;
    String itemname;
    String num="1";
    String uname;
    String date1;



    //  ElegantNumberButton numberButton;
   // SharedPreferences sharedpreferences;
    String id;

    //the context object
    String url =  "http://192.168.43.36/tolet/admin1/house/cart.php";
    private Context mCtx;
    public ListViewAdapter2(List<view2> heroList1, Context mCtx) {
        super(mCtx, R.layout.populatelist,heroList1);
        this.heroList1 = heroList1;
        this.mCtx = mCtx;
          //SharedPreferences sharedpreferences=getSharedPreferences(dashboard.MyPREFERENCES,MODE_PRIVATE);
        //  uname=sharedpreferences.getString("Name","0");
         //SharedPreferences sharedpreferences=getSharedPreferences(dashboard.MyPREFERENCES,MODE_PRIVATE);

    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent)

    {

        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View listViewItem = inflater.inflate(R.layout.populatelist3, null, true);

        e1 = (Button) listViewItem.findViewById(R.id.editText);
        e1.setOnClickListener(this);

        id1=(TextView) listViewItem.findViewById(R.id.id1);
        Type = (TextView) listViewItem.findViewById(R.id.Type);
        AC = (TextView) listViewItem.findViewById(R.id.AC);
        // PropertyID = (TextView) listViewItem.findViewById(R.id.PropertyID);
        SwimmingPool = (TextView) listViewItem.findViewById(R.id.SwimmingPool);
        Garage = (TextView) listViewItem.findViewById(R.id.Garage);
        Inverter = (TextView) listViewItem.findViewById(R.id.Inverter);
        Rent = (TextView) listViewItem.findViewById(R.id.Rent);
        Localities = (TextView) listViewItem.findViewById(R.id.Localities);
        date = (TextView) listViewItem.findViewById(R.id.date);
        img1 = (ImageView) listViewItem.findViewById(R.id.img1);
        btn1= (Button) listViewItem.findViewById(R.id.btn1);
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-mm-dd");
        String dateTime= simpleDateFormat.format(calendar.getTime());

        // numberButton=(ElegantNumberButton)listViewItem.findViewById(R.id.elegantNumberButton_quantity);
        //  numberButton.setOnClickListener(new ElegantNumberButton.OnClickListener() {
        //  @Override
        // public void onClick(View view) {
        //  num = numberButton.getNumber();

        //      }
        //    });
        hero = heroList1.get(position);
        // PropertyID.setText(hero.PropertyID+"");
        Type.setText(hero.Type);
        id1.setText(hero.PropertyID);
        AC.setText(hero.AC);
        SwimmingPool.setText(hero.SwimmingPool);
        Garage.setText(hero.SwimmingPool);
        Inverter.setText(hero.Inverter);
        Rent.setText(hero.Rent);
        Localities.setText(hero.Localities);
        date.setText(dateTime);
        Picasso.get().load("http://192.168.43.36/tolet/admin1//house/"+hero.img1).resize(1000,500).into(img1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String datefrom = e1.getText().toString();
                putString("Date1",datefrom);

                id=hero.PropertyID;
                RequestQueue queue = Volley.newRequestQueue(getContext());
                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d("string",response);
                        Toast.makeText(getContext(), "Sucessfully Added!!" + response, Toast.LENGTH_SHORT).show();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getContext(), "my error :" + error, Toast.LENGTH_LONG).show();
                        Log.i("My error", "" + error);
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> map = new HashMap<String, String>();
                        map.put("id",id);
                        //   map.put("num",num);
                        map.put("uname",hero.getun());
                        map.put("Date1",datefrom);
                        return map;
                    }
                };
                queue.add(request);

            }

            private void putString(String date1, String datefrom) {
            }
        });

        return listViewItem;


    }

    @Override
    public void onClick(View v) {

        if (v == e1) {



            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            // dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT)
            DatePickerDialog datePickerDialog = new DatePickerDialog(v.getRootView().getContext(),
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            e1.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
          //  Toast.makeText(v.getContext(),"msg"+e1,Toast.LENGTH_LONG).show();
          //  Log.d("msg","e1");
        }

    }
}