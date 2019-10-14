package com.example.myapplication.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Apimanger {
   private static Retrofit retrofit;
   private  static  Retrofit getInstance(){
       if(retrofit==null){
         retrofit=  new Retrofit.Builder()
                 .baseUrl("http://api.mp3quran.net/")
                 .addConverterFactory(GsonConverterFactory.create())
                 .build();

       }
       return retrofit;
   }
   public  static  webservices getapis(){
        return    getInstance().create(webservices.class);
   }
}
