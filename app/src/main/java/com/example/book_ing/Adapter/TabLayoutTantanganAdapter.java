package com.example.book_ing.Adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.book_ing.Fragment.FragmentTantanganSaya;
import com.example.book_ing.Fragment.FragmentTantanganSemua;
import com.example.book_ing.Fragment.FragmentTransaksiPinjam;
import com.example.book_ing.Fragment.FragmentTransaksiTukar;


public class TabLayoutTantanganAdapter extends FragmentPagerAdapter {

    private Context myContext;
    private int totalTabs;

    public TabLayoutTantanganAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 1:
                FragmentTantanganSaya fragmentTantanganSaya = new FragmentTantanganSaya();
                return fragmentTantanganSaya;
            case 0:
                FragmentTantanganSemua fragmentTantanganSemua = new FragmentTantanganSemua();
                return fragmentTantanganSemua;
            default:
                return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}
