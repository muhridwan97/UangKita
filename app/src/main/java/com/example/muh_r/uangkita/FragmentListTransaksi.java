package com.example.muh_r.uangkita;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListTransaksi extends Fragment implements View.OnClickListener {
    RecyclerView mRecyclerView;
    AdapterListTransaksi mAdapter;
    Button mybutton;
    ArrayList<Transaksi> transaksis = new ArrayList<>();
    View view;
    public FragmentListTransaksi() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list_transaksi, container, false);
        Transaksi data1 = new Transaksi("Rp 150.000", "Rp 1.000.000","24 OKT");
        Transaksi data2 = new Transaksi("Rp 50.000", "Rp 100.000","25 OKT");
        transaksis.add(data1);
        transaksis.add(data2);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mAdapter = new AdapterListTransaksi(view.getContext(), transaksis);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
