package com.example.muh_r.uangkita;

import java.util.Date;

public interface IHost {
    void sendData(Date tangga_transaksil, String jenis_transaksi, String kategori_transaksi, String jumlah_transaksi, String deskripsi);
}