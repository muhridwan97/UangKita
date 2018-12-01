package com.example.muh_r.uangkita;

import java.util.Date;

public class Transaksi {
    public String pengeluaran,pemasukan;
    public String tanggal;

    private Date tangga_transaksil;
    private String jenis_transaksi;
    private String kategori_transaksi;
    private String jumlah_transaksi;
    private String deskripsi;

    public Transaksi (String pengeluaran, String pemasukan, String tanggal){
        this.pengeluaran = pengeluaran;
        this.pemasukan = pemasukan;
        this.tanggal = tanggal;
    }

    public Transaksi (Date tangga_transaksil, String jenis_transaksi, String kategori_transaksi, String jumlah_transaksi, String deskripsi){
        this.tangga_transaksil = tangga_transaksil;
        this.jenis_transaksi = jenis_transaksi;
        this.kategori_transaksi = kategori_transaksi;
        this.jumlah_transaksi = jumlah_transaksi;
        this.deskripsi = jumlah_transaksi;
    }

}
