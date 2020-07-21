package com.example.past_year_paper;
import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;
    public MyAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                boards homeFragment = new boards();
                return homeFragment;
            case 1:
                onlinetest movieFragment = new onlinetest();
                return movieFragment;
            case 2:
                datesheet date = new datesheet();
                return date;
            case 3:
                resultdatails result = new resultdatails();
                return result;
            case 4:
                resultline resultl = new resultline();
                return resultl;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {
        return totalTabs;
    }
}


