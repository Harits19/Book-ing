package com.example.book_ing.Adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.book_ing.Fragment.FragmentTantanganSaya;
import com.example.book_ing.Fragment.FragmentTantanganSemua;
import com.example.book_ing.Fragment.FragmentTransaksiPinjam;
import com.example.book_ing.Fragment.FragmentTransaksiTukar;


public class TabLayoutAdapter extends FragmentPagerAdapter {

    private Context myContext;
    private int totalTabs;
    private String Params;

    public TabLayoutAdapter(Context context, FragmentManager fm, int totalTabs, String params) {
        super(fm);
        myContext = context;
        Params = params;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        if(Params.equals("tantangan")){
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
        }else if(Params.equals("transaksi")){
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
        }else{
            return null;
        }
    }
    @Override
    public int getCount() {
        return totalTabs;
    }
}
