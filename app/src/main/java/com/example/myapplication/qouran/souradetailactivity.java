package com.example.myapplication.qouran;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class souradetailactivity extends AppCompatActivity {
  static  int pos;
  String name;
  ArrayList<String> verses;
  RecyclerView recyclerView;
  TextView souraname;

    versesrecycleradapter versesrecycleradapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_souradetailactivity);
        recyclerView=(RecyclerView)findViewById(R.id.souradetailrecycler);
        souraname=(TextView)findViewById(R.id.souraname);

        pos=getIntent().getIntExtra("pos",-1);


        name=getIntent().getStringExtra("name");
       verses= readsourafromfile((pos+1)+".txt");
        souraname.setText(name);
       versesrecycleradapter =new versesrecycleradapter(verses);
      layoutManager=new LinearLayoutManager(souradetailactivity.this);
      recyclerView.setAdapter(versesrecycleradapter);
      recyclerView.setLayoutManager(layoutManager);






    }
    public ArrayList<String> readsourafromfile(String filename){
        BufferedReader reader = null;
        ArrayList<String> allvars=new ArrayList<>();
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(filename), "UTF-8"));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {

               allvars.add(mLine);

            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }
return allvars;
    }
}
