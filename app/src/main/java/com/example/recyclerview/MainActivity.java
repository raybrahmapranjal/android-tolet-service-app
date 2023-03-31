package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;



import com.example.recyclerview.dashboard;

import java.util.HashMap;
import java.util.Map;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText username, password;
    Button b1, b2;
    TextView t3;
    String un, pa;
    String url = "http://192.168.43.36/Android/login.php";//this is the url of the php code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        b1 = (Button) findViewById(R.id.button);
        // b2=(Button) findViewById(R.id.btn2);
        t3 = (TextView) findViewById(R.id.rel1);
        b1.setOnClickListener(this);
        t3.setOnClickListener(this);

    }

    @Override
    public void onClick(final View v) {
        if (v.getId() == R.id.button) {
            final String uname = username.getText().toString();
            final String pass = password.getText().toString();
            RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
            StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equalsIgnoreCase("Logged IN")) {
                        Intent intentBundle1 = new Intent(MainActivity.this, dashboard.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("username", uname);

                        intentBundle1.putExtra("data", bundle);
                        startActivity(intentBundle1);



                    } else {
                        Toast.makeText(MainActivity.this, "dfdsfsd" + response, Toast.LENGTH_SHORT).show();
                        Log.i("My success", "" + response);
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(MainActivity.this, "my error :" + error, Toast.LENGTH_LONG).show();
                    Log.i("My error", "" + error);
                }
            }) {
                class dashboard {
                }

                @Override
                protected Map<String, String> getParams() throws AuthFailureError {

                    Map<String, String> map = new HashMap<String, String>();
                    map.put("username", uname);
                    map.put("password", pass);

                    return map;
                }
            };
            queue.add(request);

        }

        if (v.getId() == R.id.rel1)

    {
        Intent intent = new Intent(MainActivity.this, Signup.class);
        startActivity(intent);
    }
}
}

