package com.example.muh_r.uangkita;


import android.support.v4.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Date;

public class Uang_Kita_Main extends AppCompatActivity implements IHost{

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fm = getSupportFragmentManager();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_add_transactions:
                    fm.beginTransaction().replace(R.id.placeholder, new Add()).commit();
                    return true;
                case R.id.navigation_list_transactions:
                    fm.beginTransaction().replace(R.id.placeholder, FragmentListTransaksi.getInstance()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uang__kita__main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void sendData(Date tangga_transaksil, String jenis_transaksi, String kategori_transaksi, String jumlah_transaksi, String deskripsi) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentListTransaksi fragment2 = FragmentListTransaksi.newInstance(tangga_transaksil, jenis_transaksi,  kategori_transaksi,  jumlah_transaksi,  deskripsi);
        fm.beginTransaction().replace(R.id.placeholder, fragment2).commit();
    }
}
