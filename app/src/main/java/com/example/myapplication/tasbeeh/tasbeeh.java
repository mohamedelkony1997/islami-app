package com.example.myapplication.tasbeeh;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class tasbeeh extends Fragment implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    ImageView imageView;
  TextView textView;
    int counter = 0;

    public tasbeeh() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_tasbeeh, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinner = view.findViewById(R.id.spinner);
        imageView=view.findViewById(R.id.image);
        textView=view.findViewById(R.id.text);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.tasbeeh, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    String text=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_LONG).show();
        if(text.equals("سبحان الله")) {
            counter=0;
            textView.setText(counter+"");
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    counter++;
                    textView.setText(counter + "");
                    if ((counter + "").equals("33")) {
                        counter = 0;

                    }
                }
            });
        }else if(text.equals("الله اكبر")){
            counter=0;
            textView.setText(counter+"");
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    counter++;
                    textView.setText(counter + "");
                    if ((counter + "").equals("33")) {
                        counter = 0;

                    }
                }
            });
        }else if(text.equals("الحمد لله")){
            counter=0;
            textView.setText(counter+"");
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    counter++;
                    textView.setText(counter + "");
                    if ((counter + "").equals("33")) {
                        counter = 0;

                    }
                }
            });
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}