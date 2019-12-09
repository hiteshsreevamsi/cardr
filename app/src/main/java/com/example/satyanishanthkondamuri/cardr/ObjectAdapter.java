package com.example.satyanishanthkondamuri.cardr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by satyanishanthkondamuri on 05/06/18.
 */

public class ObjectAdapter extends RecyclerView.Adapter<ObjectAdapter.ViewHolder> {
    ViewHolder holder;
    View v;
    public Context mContext;

    public int images[]= { R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h
            ,R.drawable.i,
            R.drawable.j,
            R.drawable.k,
            R.drawable.l
    };

    public ObjectAdapter(Context context)
    {
       mContext =context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder
            (@NonNull ViewGroup parent,
             int viewType) {

        RecyclerView.LayoutManager lm = MainActivity.Rv.getLayoutManager();
        GridLayoutManager glm = (GridLayoutManager) lm;
        if(viewType == 6)
        {


            v= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout,parent, false);

            holder = new ViewHolder(v,1);



        }

        else if(viewType == 1) {


            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.object, parent, false);

            holder = new ViewHolder(v);

        }


        return holder;
    }

    @Override
    public void
    onBindViewHolder
            (@NonNull ViewHolder holder, int position) {


       if(position != 6) {
           holder.image.setImageResource(images[position]);
           holder.i.setImageResource(R.drawable.a);
       }

                 // Log.e("app",String.valueOf(holder.getAdapterPosition()));
    }

    @Override
    public int getItemViewType(int position){int viewtype=1;
        if(position==6){
            viewtype =6;
        }
        return viewtype;
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

           public  ImageView image;
           public  ImageView i;
        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
               i = itemView.findViewById(R.id.imagel);
        }

        public ViewHolder(View v,int i)
        {
            super(v);

        }



    }
}
