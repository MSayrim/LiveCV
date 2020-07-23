package com.example.livecv.ui.Mydoviz;
import android.graphics.Bitmap;

public class Currency {

    String moneyValue;
    Bitmap moneyPicId;

    public Currency(String moneyValue, Bitmap moneyPicId) {
        this.moneyValue = moneyValue;
        this.moneyPicId = moneyPicId;
    }

    public String getMoneyValue() {
        return moneyValue;
    }

    public void setMoneyValue(String moneyValue) {
        this.moneyValue = moneyValue;
    }

    public Bitmap getMoneyPicId() {
        return moneyPicId;
    }

    public void setMoneyPicId(Bitmap moneyPicId) {
        this.moneyPicId = moneyPicId;
    }
}
