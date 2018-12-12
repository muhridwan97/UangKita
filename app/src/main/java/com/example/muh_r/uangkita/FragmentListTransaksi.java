package com.example.muh_r.uangkita;


import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Date;

import static android.content.Context.NOTIFICATION_SERVICE;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListTransaksi extends Fragment implements View.OnClickListener {
    RecyclerView mRecyclerView;
    AdapterListTransaksi mAdapter;

    public Date tanggal_transaksi;
    public String jenis_transaksi;
    public String kategori_transaksi;
    public String jumlah_transaksi;
    public String deskripsi;

    View view;
    public FragmentListTransaksi() {
        // Required empty public constructor
    }

    private static FragmentListTransaksi instance;
    public static synchronized FragmentListTransaksi getInstance() {
        if (instance == null) {
            System.out.println("buat intstance");
            instance = new FragmentListTransaksi();
        }
        return instance;
    }

    public static FragmentListTransaksi newInstance(Date tanggal_transaksi, String jenis_transaksi, String kategori_transaksi, String jumlah_transaksi, String deskripsi) {
        //FragmentListTransaksi fragment = new FragmentListTransaksi();
        FragmentListTransaksi fragment = FragmentListTransaksi.getInstance();
        Bundle args = new Bundle();
        args.putSerializable("tanggal", tanggal_transaksi);
        args.putString("jenis", jenis_transaksi);
        args.putString("kategori", kategori_transaksi);
        args.putString("jumlah", jumlah_transaksi);
        args.putString("deskripsi", deskripsi);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    private void notif(){

        double limit = Integer.parseInt(DataModel.getInstance().getTotalPemasukan()) * 0.6;
        double pengeluaran = Integer.parseInt(DataModel.getInstance().getTotalPengeluaran());

        System.out.println("Limit1 :" + limit);
        System.out.println("pengeluaran1 : " + pengeluaran);

        if (pengeluaran >= limit) {
            System.out.println("limit");
            System.out.println("Limit2 :" + limit);
            System.out.println("pengeluaran2:" + pengeluaran);
            NotificationManager mNotifyManager = (NotificationManager) getContext().getSystemService(NOTIFICATION_SERVICE);
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this.getActivity(), "0")
                    .setSmallIcon(R.drawable.ic_home_black_24dp)
                    .setContentTitle("Uang Limit")
                    .setContentText("Uang sudah mencapt limit")
                    .setPriority(NotificationCompat.PRIORITY_HIGH);

            Notification mynotif = mBuilder.build();
            mNotifyManager.notify(0,  mynotif);

        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            tanggal_transaksi = (Date) getArguments().getSerializable("tanggal");
            jenis_transaksi = getArguments().getString("jenis");
            kategori_transaksi = getArguments().getString("kategori");
            jumlah_transaksi = getArguments().getString("jumlah");
            deskripsi = getArguments().getString("deskripsi");
            getArguments().clear();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_transaksi, container, false);
        if(tanggal_transaksi != null){
            DataModel.getInstance().setListOfTransaction(new Transaksi(tanggal_transaksi,jenis_transaksi,kategori_transaksi,jumlah_transaksi,deskripsi));

            double percentLimit = 0.0;
            if (!DataModel.getInstance().getLimit().isEmpty()){
                percentLimit = Integer.parseInt(DataModel.getInstance().getLimit()) * 0.01;
                System.out.println(percentLimit);
            }

            double limit = Integer.parseInt(DataModel.getInstance().getTotalPemasukan()) * percentLimit;
            double pengeluaran = Integer.parseInt(DataModel.getInstance().getTotalPengeluaran());
            System.out.println(limit);

            if (pengeluaran > limit) {
                if (DataModel.getInstance().getCheckBox().equalsIgnoreCase("true")){
                    NotificationManager mNotifyManager = (NotificationManager) getContext().getSystemService(NOTIFICATION_SERVICE);
                    NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this.getActivity(), "0")
                            .setSmallIcon(R.drawable.ic_home_black_24dp)
                            .setContentTitle("Uang Limit")
                            .setContentText("Uang sudah mencapt limit")
                            .setPriority(NotificationCompat.PRIORITY_HIGH);

                    Notification mynotif = mBuilder.build();
                    mNotifyManager.notify(0,  mynotif);
                }
            }
        }

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mAdapter = new AdapterListTransaksi(view.getContext(), DataModel.getInstance().getListOfTransaction());
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}
