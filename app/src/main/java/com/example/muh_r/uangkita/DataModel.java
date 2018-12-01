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

    private Map<Date, List<String>> listOfTransactions = new HashMap<>();

    public static synchronized DataModel getInstance() {
        if (instance == null) {
            instance = new DataModel();
        }
        return instance;
    }

    public void setListOfTransactions(Date tanggal, String jenis_transaksi, String kategori_transaksi, String jumlah_transaksi, String deskripsi){
        List<String> classAttribute = new ArrayList<>();
        classAttribute.add(jenis_transaksi);
        classAttribute.add(kategori_transaksi);
        classAttribute.add(jumlah_transaksi);
        classAttribute.add(deskripsi);
        listOfTransactions.put(tanggal, classAttribute);
    }

    public void debug(){
        for (Map.Entry<Date, List<String>> transaction : listOfTransactions.entrySet()) {
            for (String tr : transaction.getValue()) {
                System.out.println(tr);
            }
        }
        listOfTransactions.clear();

    }
}
