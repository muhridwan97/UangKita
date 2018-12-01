package com.example.muh_r.uangkita;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
        View itemView = mInflater.inflate(R.layout.activity_item_kontak, parent, false);
        return new TransaksiViewHolder(itemView, this);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListTransaksi.TransaksiViewHolder holder, int position) {
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

    class TransaksiViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {
        TextView pengeluaran_textView, pemasukan_textView, tanggal_textView;
        AdapterListTransaksi mAdapter;
        public TransaksiViewHolder(View itemView, AdapterListTransaksi adapter) {
            super(itemView);
            pengeluaran_textView = (TextView) itemView.findViewById(R.id.ID_NAMA);
            pemasukan_textView = (TextView) itemView.findViewById(R.id.ID_NAMA);
            tanggal_textView = (TextView) itemView.findViewById(R.id.ID_TELEPON);
            this.mAdapter = adapter;
            //telepon_textView.setOnClickListener(this);

        }

//        @Override
//        public void onClick(View v) {
//            if (v.getId() == R.id.ID_TELEPON) {
//                Log.d("click", "onClick: " + telepon_textView.getText());
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:"+telepon_textView.getText().toString()));
//                _context.startActivity(intent);
//            }
//        }
    }
}




