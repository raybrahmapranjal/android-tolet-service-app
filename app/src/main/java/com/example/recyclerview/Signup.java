package com.example.recyclerview;


import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity implements View.OnClickListener {
    EditText username,password,name,address,phone,email;
    private int mYear, mMonth, mDay, mHour, mMinute;
    Button save1;

    String url = "http://192.168.43.36/Android/signup.php/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        username=(EditText)findViewById(R.id.editText1);
        password=(EditText)findViewById(R.id.editText2);
        name=(EditText)findViewById(R.id.editText3);
        address=(EditText)findViewById(R.id.editText4);
        phone=(EditText)findViewById(R.id.editText5);
        email=(EditText)findViewById(R.id.editText6);

        save1 = (Button) findViewById(R.id.button4);
        save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String user = username.getText().toString();
                final String pass= password.getText().toString();
                final String name1= name.getText().toString();
                final String email1=email.getText().toString();
                final String phone1=phone.getText().toString();
                final String address1=address.getText().toString();


                RequestQueue queue = Volley.newRequestQueue(Signup.this);
                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override

                    public void onResponse(String response) {
                        Log.d("response",response);
                        Toast.makeText(Signup.this, "added" + response, Toast.LENGTH_SHORT).show();
                        Log.i("My success", "" + response);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //Log.d("response",response);
                        Toast.makeText(Signup.this, "my error :" + error, Toast.LENGTH_LONG).show();
                        Log.i("My error", "" + error);
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> map = new HashMap<String, String>();
                        map.put("username",user);
                        map.put("password",pass);
                        map.put("name",name1);

                        map.put("address",address1);
                        map.put("phone",phone1);
                        map.put("email",email1);
                        return map;
                    }
                };
                queue.add(request);

            }
        });


    }


    @Override
    public void onClick(View v) {

    }
}
