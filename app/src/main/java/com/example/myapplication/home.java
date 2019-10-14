package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import com.example.myapplication.ahadees.ahadeesfragment;
import com.example.myapplication.qouran.soursfragment;
import com.example.myapplication.radio.radiofragment;
import com.example.myapplication.tasbeeh.tasbeeh;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class home extends AppCompatActivity {


        BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener=new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id=menuItem.getItemId();
                Fragment fragment=null;
                if(id==R.id.qouran){
                    fragment=new soursfragment();

                }else if(id==R.id.ahades){
                    fragment=new ahadeesfragment();

                }else if(id==R.id.tasbeeh){
                    fragment=new tasbeeh();

                }else if(id==R.id.radio){
                    fragment=new radiofragment();

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.containerfragment,fragment).commit();

                return false;
            }
        };
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.home);
            BottomNavigationView navview = (BottomNavigationView) findViewById(R.id.navview);
            navview.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        }

}
