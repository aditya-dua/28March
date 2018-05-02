package com.adityadua.recyclerviewmaterialdesign28mdemo;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by AdityaDua on 01/05/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private ItemData[] itemData;

    Context context;
    public MyAdapter(ItemData[] itemData) {
        this.itemData = itemData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        context=parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row,null);

        ViewHolder vh = new ViewHolder(view);


        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.textView.setText(itemData[position].getName());
        holder.imageView.setImageResource(itemData[position].getUrl());


        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view,"Clicked on ::",Snackbar.LENGTH_LONG)
                        .setAction("Any Action",null).show();
                Toast.makeText(context, "Toast demo", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return itemData.length;
    }


    public static  class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;
        public ImageView imageView;


        public ViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.textView2);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);

        }
    }


}
