package com.example.myapplication.radio;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.myapplication.R;
import com.example.myapplication.apis.model.RadiosItem;

import java.util.List;

public class radio_reycleradapeter extends RecyclerView.Adapter<radio_reycleradapeter.viewholder> {
  List<RadiosItem> channls;

    public radio_reycleradapeter(List<RadiosItem> radiosItems) {
        this.channls = radiosItems;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemradiochannels,viewGroup,false);

        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder viewholder, final int i) {
    viewholder.name.setText(channls.get(i).getName());
    if(onplayclicklistenter!=null){
     viewholder.play.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             onplayclicklistenter.onitemclick(i,channls.get(i));
         }
     });
    }if(onstopclicklistenter!=null){
            viewholder.stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    onstopclicklistenter.onitemclick(i,channls.get(i));
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        if (channls==null) return 0;
        return channls.size();
    }

    public void setOnitemclicklistenter(Onitemclicklistenter onitemclicklistenter) {
        this.onitemclicklistenter = onitemclicklistenter;
    }

    Onitemclicklistenter onitemclicklistenter;
    Onitemclicklistenter onplayclicklistenter;
    Onitemclicklistenter onstopclicklistenter;

    public void setOnplayclicklistenter(Onitemclicklistenter onplayclicklistenter) {
        this.onplayclicklistenter = onplayclicklistenter;
    }

    public void setOnstopclicklistenter(Onitemclicklistenter onstopclicklistenter) {
        this.onstopclicklistenter = onstopclicklistenter;
    }

    public void changedata(List<RadiosItem> radiosItems ) {
        this.channls=radiosItems;
        notifyDataSetChanged();
    }

    public interface Onitemclicklistenter{
        void onitemclick(int pos, RadiosItem channls);


    }
    public class viewholder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView play;
        ImageView stop;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            play=itemView.findViewById(R.id.play);
            stop=itemView.findViewById(R.id.stop);

        }
    }
}
