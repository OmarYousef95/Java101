package com.example.java101.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.java101.R;

public class ExampleFragment extends Fragment {

    private static final String ARG_STRING = "argString";
    private static final String ARG_INT = "argInt";

    private String text;
    private int number;


    //steps #4
    public static ExampleFragment newInstance(String text , int number){

        ExampleFragment fragment = new ExampleFragment();
        //steps #4-A
        Bundle args = new Bundle();
        args.putString(ARG_STRING,text);
        args.putInt(ARG_INT,number);
        fragment.setArguments(args);
        return fragment;

    }


    // steps #2-A
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // steps #2-B
        View v = inflater.inflate(R.layout.example_fragment,container,false);

        // steps #2-C
        TextView textView = v.findViewById(R.id.text_view_fragment_example);

        ////steps #4-B
        if (getArguments() != null) {
            text = getArguments().getString(ARG_STRING);
            number = getArguments().getInt(ARG_INT);
        }

        textView.setText(text + number);

        return v;
    }
}
