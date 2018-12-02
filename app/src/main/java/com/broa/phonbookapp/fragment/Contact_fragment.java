package com.broa.phonbookapp.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.broa.phonbookapp.Django.PhoneService;
import com.broa.phonbookapp.Django.RetrofitClient;
import com.broa.phonbookapp.MyAdaptorRecycler;
import com.broa.phonbookapp.R;
import com.broa.phonbookapp.models.MyContacts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class Contact_fragment extends Fragment {


    public Contact_fragment() {
        // Required empty public constructor
    }
    RecyclerView recyclerView;
    MyAdaptorRecycler myAdaptorRecycler;
    Retrofit retrofit;
    PhoneService phoneService;
    ImageView img_call,img_sms;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.
                inflate(R.layout.fragment_contact_fragment, container, false);

        img_call = view.findViewById(R.id.img_call);
        img_sms  = view.findViewById(R.id.img_sms);

        recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);


        retrofit     = RetrofitClient.getInsrtanc();
        phoneService = retrofit.create(PhoneService.class);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
     Call<List<MyContacts>> listCall = phoneService.getContact();
        listCall.enqueue(new Callback<List <MyContacts>>() {
            @Override
            public void onResponse(Call <List <MyContacts>> call, Response<List <MyContacts>> response) {

                List <MyContacts> modelsList = response.body();
                myAdaptorRecycler =
                        new MyAdaptorRecycler(getActivity(),modelsList);
                recyclerView.setAdapter(myAdaptorRecycler);
                Toast.makeText(getActivity(), "تعداد مخاطبین موجود : " + myAdaptorRecycler.getItemCount() + "   نفرند", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call <List <MyContacts>> call, Throwable t) {
                Toast.makeText(getActivity(), t.toString(), Toast.LENGTH_SHORT).show();


            }

        });



    }


}
