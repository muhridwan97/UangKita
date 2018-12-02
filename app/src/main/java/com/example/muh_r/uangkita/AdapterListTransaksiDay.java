package com.example.muh_r.uangkita;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterListTransaksiDay extends RecyclerView.Adapter <AdapterListTransaksiDay.TransaksiViewHolder> {
    LayoutInflater mInflater;
    ArrayList<Transaksi> transaksi;
    Context _context;

    //konstruktor
    public AdapterListTransaksiDay(Context context, ArrayList<Transaksi> transaksi) {
        this.mInflater = LayoutInflater.from(context);
        this.transaksi = transaksi;
        this._context = context;
    }

    @NonNull
    @Override
    public AdapterListTransaksiDay.TransaksiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.activity_item_list_transaksi_day, parent, false);
        return new TransaksiViewHolder(itemView, this);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListTransaksiDay.TransaksiViewHolder holder, int position) {
        Transaksi current = transaksi.get(position);
        // Add the data to the view
        holder.pengeluaran_textView.setText(current.pengeluaran);
        holder.pemasukan_textView.setText(current.pemasukan);
        holder.tanggal_textView.setText(current.tanggal);

    }

    @Override
    public int getItemCount() {
        return transaksi.size();
    }

    class TransaksiViewHolder extends RecyclerView.ViewHolder   {
        TextView pengeluaran_textView, pemasukan_textView, tanggal_textView;
        AdapterListTransaksiDay mAdapter;
        public TransaksiViewHolder(View itemView, AdapterListTransaksiDay adapter) {
            super(itemView);
            pengeluaran_textView = (TextView) itemView.findViewById(R.id.pengeluaran);
            pemasukan_textView = (TextView) itemView.findViewById(R.id.pemasukan);
            tanggal_textView = (TextView) itemView.findViewById(R.id.tanggal);
            this.mAdapter = adapter;
            //telepon_textView.setOnClickListener(this);

        }
    }
}



