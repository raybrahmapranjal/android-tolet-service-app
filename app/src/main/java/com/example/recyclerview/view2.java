package com.example.recyclerview;

public class view2{
    String PropertyID;
    String OwnerID;
    String Type;
    String AC;
    String Garage;
    String SwimmingPool;
    String Inverter;
    String Rent;
    String Localities;
    String img1;

    String un;

    public view2( String PropertyID,String Ow, String t,String ac, String s, String g, String i,String r,String l, String p,String un) {
       // Toast.makeText(getContext(), "dfdsfsd" + response, Toast.LENGTH_SHORT).show();
        //this.id = id;
        this.PropertyID = PropertyID;
        this.OwnerID = Ow;

        this.Type = t;
        this.AC=ac;
        this.Garage = g;
        this.SwimmingPool = s;
        this.Inverter = i;
        this.Rent=r;

        this.Localities=l;
        this.img1 = p;

        this.un = un;
// total=total+amount;
    }
    public view2(String P, String ac,String t, String s, String g, String i,String r,String l, String p) {
        this.PropertyID=P;
         this.AC=ac;
        this.Type = t;
        this.Garage = g;
        this.SwimmingPool = s;
        this.Inverter = i;
        this.Rent=r;
        this.Localities=l;

        this.img1 = p;
// total=total+amount;
}
   // public String getId() { return id; }
    public String getPropertyID() { return PropertyID; }
    public String getOwnerID() { return OwnerID; }
    public String getType() { return Type; }
    public String getAC() { return AC; }
    public String getSwimmingPool() { return SwimmingPool; }
    public String getGarage() { return Garage; }
    public String getInverter() { return Inverter; }
    public String getRent() { return Rent; }
    public String getLocalities() { return Localities; }
    public String getpic() { return img1; }

    public String getun() { return un; }
}