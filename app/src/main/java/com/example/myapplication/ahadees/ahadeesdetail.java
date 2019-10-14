package com.example.myapplication.ahadees;

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

public class ahadeesdetail extends AppCompatActivity {
    static  int pos;
    String name;
    ArrayList<String> lines;
    RecyclerView recyclerView;
    TextView hadeesname;
    linesrecycleradapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahadeesdetail);
        recyclerView=(RecyclerView)findViewById(R.id.ahadeesdetailrecycler2);
        hadeesname=(TextView)findViewById(R.id.hadeesname);

        pos=getIntent().getIntExtra("pos",-1);


        name=getIntent().getStringExtra("name");
        lines= readsourafromfile(("h")+(pos+1)+".txt");
        hadeesname.setText(name);
        adapter =new linesrecycleradapter(lines);
        layoutManager=new LinearLayoutManager(ahadeesdetail.this);
        recyclerView.setAdapter(adapter);
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
