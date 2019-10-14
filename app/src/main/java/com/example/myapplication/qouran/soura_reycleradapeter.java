package com.example.myapplication.qouran;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;


public class soura_reycleradapeter extends RecyclerView.Adapter<soura_reycleradapeter.viewholder> {
    String names[];

    public soura_reycleradapeter(String[] names) {
        this.names = names;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_soura,viewGroup,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder viewholder, final int i) {
    final String name=names[i];
    viewholder.name.setText(name);
    if(onitemclicklistenter!=null){
        viewholder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onitemclicklistenter.onitemclick(i,name);
            }
        });
    }
    }

    @Override
    public int getItemCount() {
        if (names==null) return 0;
        return names.length;
    }

    public void setOnitemclicklistenter(Onitemclicklistenter onitemclicklistenter) {
        this.onitemclicklistenter = onitemclicklistenter;
    }

    Onitemclicklistenter onitemclicklistenter;
  public interface Onitemclicklistenter{
        void onitemclick(int pos, String names);
    }
    public class viewholder extends RecyclerView.ViewHolder{
        TextView name;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);

        }
    }
}
