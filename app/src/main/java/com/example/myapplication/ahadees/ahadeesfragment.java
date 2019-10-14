package com.example.myapplication.ahadees;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.R;
import com.example.myapplication.constant;

public class ahadeesfragment extends Fragment {
    RecyclerView recyclerView;
    ahadeesrecycleradapter adapter;
    RecyclerView.LayoutManager layoutManager;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.activity_ahadeesfragment,container,false);
        recyclerView=view.findViewById(R.id.recyclerview2);


        adapter=new ahadeesrecycleradapter(constant.Arahadees);
        adapter.setOnitemclicklistenter(new ahadeesrecycleradapter.Onitemclicklistenter() {
            @Override
            public void onitemclick(int pos, String names) {
                Intent intent=new Intent(getActivity(),ahadeesdetail.class);
                intent.putExtra("pos",pos);
                intent.putExtra("name",names);
                startActivity(intent);

            }


        });


        layoutManager=new GridLayoutManager(getContext() ,3,RecyclerView.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        return view;

    }
}
