package com.broa.phonbookapp.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.broa.phonbookapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Message_fragment extends Fragment {


    public Message_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_message_fragment, container
                        , false);
        return view;
    }

}
