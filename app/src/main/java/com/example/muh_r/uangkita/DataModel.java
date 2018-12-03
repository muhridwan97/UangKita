package com.example.muh_r.uangkita;

import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataModel {
    private static DataModel instance;
    private DataModel(){}
    private ArrayList<Transaksi> listOfTransaction = new ArrayList<>();

    public static synchronized DataModel getInstance() {
        if (instance == null) {
            instance = new DataModel();
        }
        return instance;
    }
    public String getTotalPengeluaran(){
        int totalPengeluaran=0;
        for (Transaksi pengeluaran : listOfTransaction) {
            if (pengeluaran.jenis_transaksi.equalsIgnoreCase("expense")) {
                totalPengeluaran += (Integer.valueOf(pengeluaran.jumlah_transaksi));
            }
        }
        return (String.valueOf(totalPengeluaran)) ;
    }
    public String getTotalPemasukan(){
        int totalPemasukan=0;
        for (Transaksi pengeluaran : listOfTransaction) {
            if (pengeluaran.jenis_transaksi.equalsIgnoreCase("income")) {
                totalPemasukan += (Integer.valueOf(pengeluaran.jumlah_transaksi));
            }
        }
        return (String.valueOf(totalPemasukan)) ;
    }
    public void setListOfTransaction(Transaksi transaction){
        listOfTransaction.add(transaction);
    }
    public ArrayList<Transaksi> getListOfTransaction (){
        return listOfTransaction;
    }

}
