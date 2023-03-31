package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Menu;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {

    private AppBarConfiguration mAppBarConfiguration;
    private List<CarRecyclerViewItem> cardItemList = null;
    String uname;
    //apply sharedpreferences
    SharedPreferences sharedpreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    FloatingActionButton flt;

    @Override    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
               setTitle("TO LET");
               //sharedpreferences
        Intent i = getIntent();
        Bundle b = i.getBundleExtra("data");
        uname = b.getString("username");
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("Name",uname);
        editor.commit();

       // Toast.makeText(this,"Title"+uname,Toast.LENGTH_LONG).show();

                initializeCarItemList();
        RecyclerView carRecyclerView = (RecyclerView)findViewById(R.id.card_view_recycler_list);
                GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
               carRecyclerView.setLayoutManager(gridLayoutManager);
                CarRecyclerViewDataAdapter carDataAdapter = new CarRecyclerViewDataAdapter(cardItemList);
                carRecyclerView.setAdapter(carDataAdapter);
    }



    private void initializeCarItemList() {
        if (cardItemList == null) {
            cardItemList = new ArrayList<CarRecyclerViewItem>();
           cardItemList.add(new CarRecyclerViewItem("2BHK", R.drawable.image1, 1));
            cardItemList.add(new CarRecyclerViewItem("4BHK", R.drawable.image2, 2));
            cardItemList.add(new CarRecyclerViewItem("Single", R.drawable.image3, 3));
            cardItemList.add(new CarRecyclerViewItem("3BHK", R.drawable.image4, 4));
            cardItemList.add(new CarRecyclerViewItem("Independent", R.drawable.image5, 5));
            cardItemList.add(new CarRecyclerViewItem("5HK", R.drawable.image6, 6));
        }
        else
        { cardItemList = new ArrayList<CarRecyclerViewItem>();
            cardItemList.add(new CarRecyclerViewItem("2BHK", R.drawable.image1, 1));
            cardItemList.add(new CarRecyclerViewItem("4BHK", R.drawable.image2, 2));
            cardItemList.add(new CarRecyclerViewItem("Single", R.drawable.image3, 3));
            cardItemList.add(new CarRecyclerViewItem("3BHK", R.drawable.image2, 4));
            cardItemList.add(new CarRecyclerViewItem("Independent", R.drawable.image2, 5));
           cardItemList.add(new CarRecyclerViewItem("5BHK", R.drawable.image1, 6));

        }


    }
    @Override    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override    public boolean onCreateOptionsMenu(Menu menu) {
              getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override    public boolean onOptionsItemSelected(MenuItem item) {

                              int id = item.getItemId();

                              if (id == R.id.action_settings) {
        return true;
    }

        return super.onOptionsItemSelected(item);
}
    //check whether the internet is available or not
        private boolean isNetworkAvailable() {
    ConnectivityManager connectivityManager
            = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
                }


    @SuppressWarnings("StatementWithEmptyBody")
@Override    public boolean onNavigationItemSelected(MenuItem item) {
    int id = item.getItemId();
        Boolean stat=isNetworkAvailable();
        if(stat==true) {
                  if (id == R.id.aq) {
                       Intent intent = new Intent(dashboard.this, CardViewActivity.class);
        startActivity(intent);

        }
                  else if (id == R.id.view1) {
       Intent intent=new Intent(dashboard.this,viewexpense.class);
        startActivity(intent);
        } else if (id == R.id.vd) {
        //Intent intent=new Intent(MainActivity.this,viewexpense.class);
                      //  Intent intent = new Intent(dashboard.this, Realtime.class);
             //          startActivity(intent);
        } else if (id == R.id.sd) {
        //Intent intent=new Intent(dashboard.this,offices.class);              // startActivity(intent);
        }
        }
        else        {
                Intent int1=new Intent(this,nonet.class);
        startActivity(int1);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
        }
        }