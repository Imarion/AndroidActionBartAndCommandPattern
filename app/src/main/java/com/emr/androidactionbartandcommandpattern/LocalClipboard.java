package com.emr.androidactionbartandcommandpattern;

/**
 * Created by emr on 2017/04/07.
 */

public class LocalClipboard {
    private static LocalClipboard mClipboard = null;
    private        String         mData      = "";

    private LocalClipboard() {

    }

    public static LocalClipboard getInstance() {
        if (mClipboard == null) {
            mClipboard = new LocalClipboard();
        }
        return mClipboard;
    }

    public String getmData() {
        return mData;
    }

    public void setmData(String mData) {
        this.mData = mData;
    }

}
