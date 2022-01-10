package com.example.Web03;

public class PRODUCT_TABLE {
    private int PRODUCT_ID;
    private String PRODUCT_NAME;
    private String PRODUCT_DESCRIPTION;
    private int PRODUCT_PRICE;
    private int PRODUCT_STOCK;
    private int PRODUCT_FID;
    private int PRODUCT_CID;
    private String PRODUCT_FILENAME;

    public PRODUCT_TABLE(int PRODUCT_ID, String PRODUCT_NAME, String PRODUCT_DESCRIPTION, int PRODUCT_PRICE, int PRODUCT_STOCK, int PRODUCT_FID, int PRODUCT_CID, String PRODUCT_FILENAME) {
        this.PRODUCT_ID = PRODUCT_ID;
        this.PRODUCT_NAME = PRODUCT_NAME;
        this.PRODUCT_DESCRIPTION = PRODUCT_DESCRIPTION;
        this.PRODUCT_PRICE = PRODUCT_PRICE;
        this.PRODUCT_STOCK = PRODUCT_STOCK;
        this.PRODUCT_FID = PRODUCT_FID;
        this.PRODUCT_CID = PRODUCT_CID;
        this.PRODUCT_FILENAME = PRODUCT_FILENAME;
    }

    public int getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(int PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public String getPRODUCT_NAME() {
        return PRODUCT_NAME;
    }

    public void setPRODUCT_NAME(String PRODUCT_NAME) {
        this.PRODUCT_NAME = PRODUCT_NAME;
    }

    public String getPRODUCT_DESCRIPTION() {
        return PRODUCT_DESCRIPTION;
    }

    public void setPRODUCT_DESCRIPTION(String PRODUCT_DESCRIPTION) {
        this.PRODUCT_DESCRIPTION = PRODUCT_DESCRIPTION;
    }

    public int getPRODUCT_PRICE() {
        return PRODUCT_PRICE;
    }

    public void setPRODUCT_PRICE(int PRODUCT_PRICE) {
        this.PRODUCT_PRICE = PRODUCT_PRICE;
    }

    public int getPRODUCT_STOCK() {
        return PRODUCT_STOCK;
    }

    public void setPRODUCT_STOCK(int PRODUCT_STOCK) {
        this.PRODUCT_STOCK = PRODUCT_STOCK;
    }

    public int getPRODUCT_FID() {
        return PRODUCT_FID;
    }

    public void setPRODUCT_FID(int PRODUCT_FID) {
        this.PRODUCT_FID = PRODUCT_FID;
    }

    public int getPRODUCT_CID() {
        return PRODUCT_CID;
    }

    public void setPRODUCT_CID(int PRODUCT_CID) {
        this.PRODUCT_CID = PRODUCT_CID;
    }

    public String getPRODUCT_FILENAME() {
        return PRODUCT_FILENAME;
    }

    public void setPRODUCT_FILENAME(String PRODUCT_FILENAME) {
        this.PRODUCT_FILENAME = PRODUCT_FILENAME;
    }
}
