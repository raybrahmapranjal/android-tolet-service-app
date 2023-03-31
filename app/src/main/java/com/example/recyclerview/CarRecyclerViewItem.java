package com.example.recyclerview;

public class CarRecyclerViewItem {

        private String carName;

      private int carImageId;
      private int cardid;

    public CarRecyclerViewItem(String carName, int carImageId, int cardid) {
        this.carName= carName;
        this.carImageId = carImageId;
        this.cardid=cardid;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarImageId() {
        return carImageId;
    }

    public void setCarImageId(int carImageId) {
        this.carImageId = carImageId;
    }

    public int getCardid() {
        return cardid;
    }

    public void setCardid(int cardid) {
        this.cardid = cardid;
    }
}
