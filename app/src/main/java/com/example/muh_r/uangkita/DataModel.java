package com.example.muh_r.uangkita;

import android.icu.text.SimpleDateFormat;
import android.util.Log;

import java.text.ParseException;
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

    public Map<String, List<String>> getListOfTransactionGroupByDays (){
        Map<String, List<String>> listOfTransactionGroupByDay = new HashMap<>();

        int temp_income = 0;
        int temp_expense = 0;

        for (Transaksi transaction : getListOfTransaction()) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MMM/yyyy");

            String temp_date = format.format(transaction.tangga_transaksil);
            Log.d("Tanggal", temp_date);

            List<String> expanse_income = new ArrayList<>();
            if (!listOfTransactionGroupByDay.containsKey(temp_date)) {
                temp_income = 0;
                temp_expense = 0;
                if (transaction.jenis_transaksi.equalsIgnoreCase("income")) {
                    temp_income = Integer.parseInt(transaction.jumlah_transaksi);
                }
                if (transaction.jenis_transaksi.equalsIgnoreCase("expense")) {
                    temp_expense = Integer.parseInt(transaction.jumlah_transaksi);
                }
                expanse_income.add(String.valueOf(temp_expense)); //index 0
                expanse_income.add(String.valueOf(temp_income)); //index 1
                listOfTransactionGroupByDay.put(temp_date, expanse_income);

            } else if (listOfTransactionGroupByDay.containsKey(temp_date)) {

                if (transaction.jenis_transaksi.equalsIgnoreCase("income")) {
                    temp_income = Integer.parseInt(transaction.jumlah_transaksi) +
                            Integer.parseInt(listOfTransactionGroupByDay.get(temp_date).get(1));
                }
                if (transaction.jenis_transaksi.equalsIgnoreCase("expense")) {
                    temp_expense = Integer.parseInt(transaction.jumlah_transaksi) +
                            Integer.parseInt(listOfTransactionGroupByDay.get(temp_date).get(0));
                    ;
                }
                expanse_income.add(String.valueOf(temp_expense)); //index 0
                expanse_income.add(String.valueOf(temp_income)); //index 1
                listOfTransactionGroupByDay.remove(temp_date);
                listOfTransactionGroupByDay.put(temp_date, expanse_income);

            }

        }

        return listOfTransactionGroupByDay;
    }

}
