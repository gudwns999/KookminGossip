package com.gudwns999.kookmingossip.Gossip;

import android.graphics.drawable.Drawable;

import java.util.Comparator;

/**
 * Created by Kim on 2016-12-02.
 */

public class ListData {
    public Drawable mIcon;
    public String nick;
    public String mTitle;
    public String mData;
    public String gender;
    public String state;
    public String major;

    //알파벳 이름으로 정렬
    public static final Comparator<ListData> ALPHA_COMPARATOR = new Comparator<ListData>() {
        @Override
        public int compare(ListData lhs, ListData rhs) {
            return 0;
        }
    };
}
