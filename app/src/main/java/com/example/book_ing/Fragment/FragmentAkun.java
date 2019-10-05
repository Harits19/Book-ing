package com.example.book_ing.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.book_ing.Activity.ActivityTambahKoleksiBuku;
import com.example.book_ing.Adapter.BukuAdapter;
import com.example.book_ing.OtherClass.Buku;
import com.example.book_ing.R;
import com.example.book_ing.Welcome.ActivityWelcome;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;

import java.util.ArrayList;

public class FragmentAkun extends Fragment {

        private ArrayList<Buku> ListBukuKoleksi;
        private TextView ButtonTambahKoleksi;
        private RecyclerView RecyclerviewKoleksiBuku;
        Button logout;
        TextView nama;
        View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_akun, container, false);

        nama = view.findViewById(R.id.textview_nama_pengguna);
        RecyclerviewKoleksiBuku = view.findViewById(R.id.recyclerview_koleksi_buku_akun);
        ButtonTambahKoleksi = view.findViewById(R.id.button_tambah_koleksi);

        ButtonTambahKoleksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity() , ActivityTambahKoleksiBuku.class));

            }
        });

        addListBukuKoleksi();
        BukuAdapter myAdapter = new BukuAdapter(ListBukuKoleksi);
        RecyclerviewKoleksiBuku.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        RecyclerviewKoleksiBuku.setAdapter(myAdapter);
        logout = view.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserSignOutFunction();

            }
        });
        String name;
        if(savedInstanceState == null) {
            Bundle extras = getActivity().getIntent().getExtras();
            if(extras == null) {
                name = null;
            }
            else {
                name = extras.getString("displayName");
            }
        }
        else{
            name = (String) savedInstanceState.getSerializable("displayName");
        }
        nama.setText(name);
        return view;
    }

    private void addListBukuKoleksi() {

         ListBukuKoleksi = new ArrayList<>();
        ListBukuKoleksi.add(new Buku("AA", "Rp 20.000", getActivity().getDrawable(R.drawable.buku)));
        ListBukuKoleksi.add(new Buku("BB", "Rp 20.000", getActivity().getDrawable(R.drawable.buku1)));
        ListBukuKoleksi.add(new Buku("CC", "Rp 20.000", getActivity().getDrawable(R.drawable.buku2)));
    }



    public void UserSignOutFunction() {

        // Sing Out the User.
        ActivityWelcome.firebaseAuth.signOut();

        Auth.GoogleSignInApi.signOut(ActivityWelcome.googleApiClient).setResultCallback(
                new ResultCallback() {
                    @Override
                    public void onResult(@NonNull Result result) {
                        // Write down your any code here which you want to execute After Sign Out.

                        // Printing Logout toast message on screen.
//                        Toast.makeText(FragmentAkun.this, "Logout Successfully", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getActivity(), ActivityWelcome.class);
                        startActivity(i);
                    }


                });

        // After logout Hiding sign out button.
//        SignOutButton.setVisibility(View.GONE);

        // After logout setting up email and name to null.
//        LoginUserName.setText(null);
//        LoginUserEmail.setText(null);

        // After logout setting up login button visibility to visible.
//        signInButton.setVisibility(View.VISIBLE);
    }

}
