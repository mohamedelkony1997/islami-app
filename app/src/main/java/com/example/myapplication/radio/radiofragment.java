package com.example.myapplication.radio;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;


import com.example.myapplication.R;
import com.example.myapplication.apis.Apimanger;
import com.example.myapplication.apis.model.Radiochannlsresponse;
import com.example.myapplication.apis.model.RadiosItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class radiofragment extends Fragment {


    public radiofragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.activity_radiofragmenty, container, false);
    }
RecyclerView recyclerView;
radio_reycleradapeter adapter;
RecyclerView.LayoutManager layoutManager;
View progressbar;



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            recyclerView=view.findViewById(R.id.reclerview);
            progressbar=view.findViewById(R.id.progress);
            getradiochannls();
            init();



    }
    public void  init(){
        adapter=new radio_reycleradapeter(null);
        layoutManager=new LinearLayoutManager( getContext(),RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        SnapHelper snapHelper=new PagerSnapHelper();

        snapHelper.attachToRecyclerView(recyclerView);
        adapter.setOnplayclicklistenter(new radio_reycleradapeter.Onitemclicklistenter() {
            @Override
            public void onitemclick(int pos, RadiosItem channls) {
                playchannel(channls.getRadioUrl());


            }
        });
        adapter.setOnstopclicklistenter(new radio_reycleradapeter.Onitemclicklistenter() {
            @Override
            public void onitemclick(int pos, RadiosItem channls) {
stopchannel();
    }
});

    }
    MediaPlayer mediaPlayer;
    public  void  playchannel(String url){
        stopchannel();
            mediaPlayer=new MediaPlayer();
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });

        }catch (Exception  e){
            e.printStackTrace();
            Toast.makeText(getContext(),"cannot play",Toast.LENGTH_LONG).show();

        }

    }
    public  void  stopchannel() {
        if(mediaPlayer==null)return;
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer=null;
    }



        public void getradiochannls(){
     Apimanger.getapis().getRadiochannels().enqueue(new Callback<Radiochannlsresponse>() {
         @Override
         public void onResponse(Call<Radiochannlsresponse> call, Response<Radiochannlsresponse> response) {
             List<RadiosItem> radiosItems=response.body().getRadios();
             adapter.changedata(radiosItems);
             progressbar.setVisibility(View.GONE);
         }

         @Override
         public void onFailure(Call<Radiochannlsresponse> call, Throwable t) {
             Toast.makeText(getContext(),t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
             progressbar.setVisibility(View.GONE);
         }
     });
 }

}


