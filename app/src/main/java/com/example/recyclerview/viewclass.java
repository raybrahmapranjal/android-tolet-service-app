package com.example.recyclerview;

import android.util.Log;

/**
 * Created by lenovo on 31-03-2018.
 */
public class viewclass {


    // public String img1;
    String PType_ID;
   String P_Type;
    String img1;

    // public democlass(String subject, String d, String a)
    public viewclass( String pi, String pt,

                      String img) {

        this.PType_ID = pi;
        this.P_Type = pt;

        this.img1 = img;
        Log.d("name2",img);

    }


    public String getPType_ID() { return PType_ID;   }

    public String getP_Type() { return P_Type;   }

    public String getImage() { return img1;   }



}

