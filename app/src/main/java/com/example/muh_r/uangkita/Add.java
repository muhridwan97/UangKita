package com.example.muh_r.uangkita;

import android.app.DatePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Add.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Add#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Add extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView _tv_date, _tv_total_transactions;
    private Spinner _cmb_transaction;
    private Spinner _cmb_category;

    private OnFragmentInteractionListener mListener;

    public Add() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Add.
     */
    // TODO: Rename and change types and number of parameters
    public static Add newInstance(String param1, String param2) {
        Add fragment = new Add();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_add, container, false);

        combobox(rootView);
        datePicker(rootView);
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    // TODO: Update list
    private void combobox(View view){
        _cmb_transaction = (Spinner) view.findViewById(R.id._cmb_transactions);
        _cmb_category = (Spinner) view.findViewById(R.id._cmb_category);

        List<String> transactions = new ArrayList<String>();
        transactions.add("Expense");
        transactions.add("Income");

        List<String> categories = new ArrayList<String>();
        categories.add("Food");
        categories.add("Drink");

        ArrayAdapter<String> dataTransaction = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, transactions);
        ArrayAdapter<String> dataCategory = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, categories);

        dataTransaction.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataCategory.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        _cmb_transaction.setAdapter(dataTransaction);
        _cmb_category.setAdapter(dataCategory);
    }

    private void datePicker (View view){
        final Calendar myCalendar = Calendar.getInstance();

        _tv_date= view.findViewById(R.id._tv_date);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                _tv_date.setText(sdf.format(myCalendar.getTime()));
            }

        };
        final FragmentActivity activity = this.getActivity();
        _tv_date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(activity, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
}
