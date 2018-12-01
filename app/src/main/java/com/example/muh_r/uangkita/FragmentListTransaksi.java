package com.example.muh_r.uangkita;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListTransaksi extends Fragment implements View.OnClickListener {

    View view;
    public FragmentListTransaksi() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list_transaksi, container, false);

        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
