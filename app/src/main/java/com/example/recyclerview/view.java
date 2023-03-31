package com.example.recyclerview;

public class view {
   int PropertyID;
    String OwnerID;
    String PType_ID;
    String Type;
    String Rent;

    String Garage;
    String SwimmingPool;
    String Inverter;
    String img1;

    String Localities;
    // String img1;

// Integer total=0;

    public view(Integer PropertyID,  String OwnerID,String PT, String t, String r, String s, String g, String i, String l, String p) {
        this.PropertyID = PropertyID;

        this.OwnerID = OwnerID;
        this.PType_ID = PT;
        this.Type = t;
        this.Rent = r;

        this.Garage = g;
        this.SwimmingPool = s;
        this.Inverter = i;
        this.Localities = l;
        this.img1 = p;
// total=total+amount;
    }

    public Integer getPropertyID() {
        return PropertyID;
    }




    public String getOwnerID() {
        return OwnerID;
    }
    public String getPType_ID() { return PType_ID;}


    public String getType() { return Type;

    }

    public String getRent() {
        return Rent;
    }



    public String getSwimmingPool() {
        return SwimmingPool;
    }

    public String getGarage() {
        return Garage;
    }

    public String getInverter() {
        return Inverter;
    }

    public String getLocalities() {
        return Localities;
    }

  public String getpic() {
       return img1;
    }
}