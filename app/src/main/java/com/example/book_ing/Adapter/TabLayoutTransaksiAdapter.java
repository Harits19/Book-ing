package com.example.book_ing.Adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.book_ing.Fragment.FragmentTransaksiPinjam;
import com.example.book_ing.Fragment.FragmentTransaksiTukar;


public class TabLayoutTransaksiAdapter extends FragmentPagerAdapter {

    private Context myContext;
    private int totalTabs;

    public TabLayoutTransaksiAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FragmentTransaksiPinjam fragmentTransaksiPinjam = new FragmentTransaksiPinjam();
                return fragmentTransaksiPinjam;
            case 1:
                FragmentTransaksiTukar fragmentTransaksiTukar = new FragmentTransaksiTukar();
                return fragmentTransaksiTukar;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}
