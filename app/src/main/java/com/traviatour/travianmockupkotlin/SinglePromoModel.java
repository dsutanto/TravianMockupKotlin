package com.traviatour.travianmockupkotlin;

/**
 * Created by rog on 03-Sep-17.
 */

public class SinglePromoModel {

    private String mPromoName;
    private int mPromoImage;
    private String mPromoTag;

    public SinglePromoModel(String PromoName, int PromoImage, String PromoTag) {
        mPromoName = PromoName;
        mPromoImage = PromoImage;
        mPromoTag = PromoTag;
    }

    public String getPromoName() {
        return mPromoName;
    }
    public int getPromoDrawable() {
        return mPromoImage;
    }
    public String getPromoTag() {
        return mPromoTag;
    }
}
