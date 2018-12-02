package com.example.muh_r.uangkita;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterListTransaksi extends RecyclerView.Adapter <AdapterListTransaksi.TransaksiViewHolder> {
    LayoutInflater mInflater;
    ArrayList<Transaksi> transaksi;
    Context _context;

    //konstruktor
    public AdapterListTransaksi(Context context, ArrayList<Transaksi> transaksi) {
        this.mInflater = LayoutInflater.from(context);
        this.transaksi = transaksi;
        this._context = context;
    }

    @NonNull
    @Override
    public AdapterListTransaksi.TransaksiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.activity_item_list_transaksi, parent, false);
        return new TransaksiViewHolder(itemView, this);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListTransaksi.TransaksiViewHolder holder, int position) {
        Transaksi current = transaksi.get(position);
        if(current.tangga_transaksil != null) {
            holder._tv_tanggal.setText(current.tangga_transaksil.toString());
            holder._tv_kategori.setText(current.kategori_transaksi);
            holder._tv_deskripsi.setText(current.deskripsi);
            holder._tv_jumlah.setText(current.jumlah_transaksi);
        }
    }

    @Override
    public int getItemCount() {
        return transaksi.size();
    }

    class TransaksiViewHolder extends RecyclerView.ViewHolder   {
        AdapterListTransaksi mAdapter;
        TextView _tv_jumlah, _tv_kategori, _tv_tanggal, _tv_deskripsi;
        public TransaksiViewHolder(View itemView, AdapterListTransaksi adapter) {
            super(itemView);

            _tv_tanggal = itemView.findViewById(R.id._tv_tanggal);
            _tv_kategori = itemView.findViewById(R.id._tv_kategori);
            _tv_deskripsi = itemView.findViewById(R.id._tv_deskripsi);
            _tv_jumlah = itemView.findViewById(R.id._tv_jumlah);

            this.mAdapter = adapter;
        }
    }
}




