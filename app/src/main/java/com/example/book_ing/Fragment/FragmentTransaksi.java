package com.example.book_ing.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.book_ing.Adapter.TabLayoutTransaksiAdapter;
import com.example.book_ing.R;
import com.google.android.material.tabs.TabLayout;

public class FragmentTransaksi extends Fragment {

    private TabLayout TabLayoutTransaksi;
    private ViewPager ViewPagerTransaksi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaksi, container, false);
        TabLayoutTransaksi = view.findViewById(R.id.tablayout_transaksi);

        TabLayoutTransaksi.addTab(TabLayoutTransaksi.newTab().setText("Pinjam"));
        TabLayoutTransaksi.addTab(TabLayoutTransaksi.newTab().setText("Tukar"));
        ViewPagerTransaksi= view.findViewById(R.id.viewpager_transaksi);


        TabLayoutTransaksiAdapter adapter = new TabLayoutTransaksiAdapter(getActivity(), getChildFragmentManager(), TabLayoutTransaksi.getTabCount());
        ViewPagerTransaksi.setAdapter(adapter);
        ViewPagerTransaksi.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(TabLayoutTransaksi));

        TabLayoutTransaksi.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ViewPagerTransaksi.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }
}
