package com.example.muh_r.uangkita;

import android.widget.TextView;

public class BackgroundTask  implements Runnable {
    private static BackgroundTask instance;
    TextView textView;
        int pemasukan=0;
        int pengeluaran=0;
        int persetase=0;
        boolean isRunning;

    private BackgroundTask(){}

    public static synchronized BackgroundTask getInstance() {
        if (instance == null) {
            instance = new BackgroundTask();
        }
        return instance;
    }

        public void set(TextView textView,boolean isRunning){
            this.textView = textView;
            this.pemasukan=Integer.parseInt(DataModel.getInstance().getTotalPemasukan());
            this.pengeluaran=Integer.parseInt(DataModel.getInstance().getTotalPengeluaran());
            if (textView.getText().toString() == ""){
                this.persetase = 0;
            } else {
                //this.persetase = (Integer.parseInt(textView.getText().toString())/100)*this.pemasukan;
            }

            this.isRunning=isRunning;
        }
        @Override
        public void run() {
            while (isRunning) {
                if (persetase < pengeluaran){
                    System.out.println("Enabled");
                }
            }
        }

    public void stop(boolean stop){
        this.isRunning = stop;
    }
}
