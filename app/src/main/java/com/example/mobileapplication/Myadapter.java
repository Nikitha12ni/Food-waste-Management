package com.example.mobileapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {

        Context context;
        ArrayList<user> list;

    public Myadapter(Context context, ArrayList<user> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
        @Override
        public Myadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
             return new MyViewHolder(v);
    }

        @Override
        public void onBindViewHolder(@NonNull Myadapter.MyViewHolder holder, int position) {
           user usr=list.get(position);
           holder.tof.setText(usr.getTof());
           holder.add.setText(usr.getAdd());
           holder.mno.setText(usr.getMno());
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        public static class MyViewHolder extends RecyclerView.ViewHolder {
       TextView tof,add,mno;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tof=itemView.findViewById(R.id.tvfirstname);
            add=itemView.findViewById(R.id.adr);
            mno=itemView.findViewById(R.id.mobi);
        }
    }
}
