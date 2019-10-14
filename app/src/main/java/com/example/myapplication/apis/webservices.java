package com.example.myapplication.apis;


import com.example.myapplication.apis.model.Radiochannlsresponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface  webservices {
    @GET("radios/radio_arabic.json")
    Call<Radiochannlsresponse>getRadiochannels();
}
