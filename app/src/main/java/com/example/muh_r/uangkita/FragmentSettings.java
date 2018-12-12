package com.example.muh_r.uangkita;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSettings#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSettings extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    View view;
    CheckBox cbNotif;
    TextView etPersentase;
    Button btnApply;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    public FragmentSettings() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentSettings.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentSettings newInstance(String param1, String param2) {
        FragmentSettings fragment = new FragmentSettings();
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
        view=inflater.inflate(R.layout.fragment_settings, container, false);
        cbNotif=view.findViewById(R.id.cbNotif);
        etPersentase=view.findViewById(R.id.etPersentase);
        btnApply=view.findViewById(R.id.btnApply);
        mPreferences = PreferenceManager.getDefaultSharedPreferences(view.getContext());
        mEditor = mPreferences.edit();
        checkSharedPreferences();
        String checkbox=DataModel.getInstance().getCheckBox();
        String limit=DataModel.getInstance().getLimit();

        if(DataModel.getInstance().getCheckBox().equalsIgnoreCase("True")){
            cbNotif.setChecked(true);
        }else {
            cbNotif.setChecked(false);
        }
        etPersentase.setText(DataModel.getInstance().getLimit());
        btnApply.setOnClickListener(event->{
            if(cbNotif.isChecked()){
                DataModel.getInstance().setCheckBox("True");
                mEditor.putString(getString(R.string.checkbox),"True");
                mEditor.commit();
                mEditor.putString(getString(R.string.limit),etPersentase.getText().toString());
                mEditor.commit();
            }else {
                DataModel.getInstance().setCheckBox("False");
                mEditor.putString(getString(R.string.checkbox),"False");
                mEditor.commit();
                mEditor.putString(getString(R.string.limit),etPersentase.getText().toString());
                mEditor.commit();
            }
            DataModel.getInstance().setLimit(etPersentase.getText().toString());
            Toast.makeText(view.getContext(), "pengaturan tersimpan", Toast.LENGTH_LONG).show();
        });
       // mPreferences = view.PreferenceManager.getDefaultSharedPreferences(this);
        //mPreferences = view.getSharedPreferences("com.example.muh_r.uangkita",Context.MODE_PRIVATE);
        return view;
    }
    private void checkSharedPreferences(){
        String checkbox = mPreferences.getString(getString(R.string.checkbox),"False");
        String limit = mPreferences.getString(getString(R.string.limit),"");

        DataModel.getInstance().setCheckBox(checkbox);
        DataModel.getInstance().setLimit(limit);
    }




}
