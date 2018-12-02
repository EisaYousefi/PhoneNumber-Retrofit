package com.broa.phonbookapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.broa.phonbookapp.fragment.Contact_fragment;
import com.broa.phonbookapp.models.MyContacts;

import java.util.List;

public class MyAdaptorRecycler  extends RecyclerView.Adapter<MyAdaptorRecycler.MyViewHolder> {
    Context context;
    List<MyContacts> myContactsList;

    public MyAdaptorRecycler(Context context, List <MyContacts> myContactsList) {
        this.context = context;
        this.myContactsList = myContactsList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyContacts myContacts = myContactsList.get(position);
        holder.information(myContacts);

    }

    @Override
    public int getItemCount() {
        return myContactsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name , tv_tel;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_tel  = itemView.findViewById(R.id.tv_tel);
            imageView = itemView.findViewById(R.id.img_pic);

        }

        public void information(MyContacts myContacts) {
            tv_name.setText(myContacts.getName());
            tv_tel.setText(myContacts.getTel());
           // imageView.setImageResource(myContacts.getImg());
        }
    }
}
