package com.example.muh_r.uangkita;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class FragementListTransaksiDay extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    RecyclerView mRecyclerView;
    AdapterListTransaksiDay mAdapter;
    ArrayList<Transaksi> transaksis = new ArrayList<>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private IHost iHost;
    View view;

    public FragementListTransaksiDay() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragementListTransaksiDay.
     */
    // TODO: Rename and change types and number of parameters
    public static FragementListTransaksiDay newInstance(String param1, String param2) {
        FragementListTransaksiDay fragment = new FragementListTransaksiDay();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragement_list_transaksi_day, container, false);

        DataModel.getInstance().getListOfTransactionGroupByDays().entrySet().forEach(transactionPerDay ->{
            String pengeluaran = transactionPerDay.getValue().get(0);
            String pemasukan = transactionPerDay.getValue().get(1);
            String tanggal = transactionPerDay.getKey();
            transaksis.add(new Transaksi(pengeluaran, pemasukan,tanggal));
        });


        //Transaksi data1 = new Transaksi("Rp 150.000", "Rp 1.000.000","24 OKT");
        //Transaksi data2 = new Transaksi("Rp 50.000", "Rp 100.000","25 OKT");
        //transaksis.add(data1);
        //transaksis.add(data2);

        iHost = (IHost) getActivity();

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mAdapter = new AdapterListTransaksiDay(view.getContext(), transaksis, iHost);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        return view;
    }

}
