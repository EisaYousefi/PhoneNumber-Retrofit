package com.broa.phonbookapp.fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.broa.phonbookapp.AddContactActivity;
import com.broa.phonbookapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class New_contact_fragment extends Fragment {


    public New_contact_fragment() {
        // Required empty public constructor
    }

    ImageView imageView ;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_contact_fragment, container, false);


        imageView      = view.findViewById(R.id.img_add_new_contact);



        return  view;   }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                // builder.setTitle("محض اطلاع...");
                builder.setMessage("آیامیخواهید یک مخاطب جدید اضافه کنید؟");
                LayoutInflater inflater = getLayoutInflater();
                View view = inflater.inflate(R.layout.dialog, null);
                builder.setView(view);

                builder.setPositiveButton("بله", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(),AddContactActivity.class);
                        startActivity(intent);



                    }
                });
                builder.setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        // Toast.makeText(LibreryHomeActivity.this, "ذخیره نشد", Toast.LENGTH_SHORT).show();
//                        toastCustomer(" --اطلاعات ذخیره نشد--");
                    }
                });
                builder.show();

                           }
        });
    }


}
