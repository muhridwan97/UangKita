package com.example.muh_r.uangkita;

import android.widget.TextView;

public class BackgroundTask  implements Runnable {


        TextView textView;
        int pemasukan=0;
        int pengeluaran=0;
        int persetase=0;
        boolean isRunning;

        public BackgroundTask(TextView textView,boolean isRunning){

            this.textView = textView;
            this.pemasukan=Integer.parseInt(DataModel.getInstance().getTotalPemasukan());
            this.pengeluaran=Integer.parseInt(DataModel.getInstance().getTotalPengeluaran());
            this.persetase= (Integer.parseInt(textView.getText().toString())/100)*this.pemasukan;
            this.isRunning=isRunning;
        }
        @Override
        public void run() {
            while (isRunning) {
                if (persetase<pengeluaran){
                    
                }
            }
        }


}
