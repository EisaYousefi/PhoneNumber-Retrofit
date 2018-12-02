package com.broa.phonbookapp.Django;

import com.broa.phonbookapp.models.MyContacts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PhoneService {

    public static final String    baseUrl ="http://10.0.2.2:8000/";

    @GET("phone")
    Call<List<MyContacts>> getContact();

    @POST("phone/")
    Call<MyContacts> create(@Body MyContacts myContacts);

}
