package com.example.sony.kakaorecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sony on 2016-01-24.
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<ChattingData> items = new ArrayList<ChattingData>();

    private static final int TYPE_RECIEVE = 0;
    private static final int TYPE_SEND = 1;

    public void add(ChattingData data){
        items.add(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        ChattingData data = items.get(position);
        if(data instanceof RecieveData){
            return TYPE_RECIEVE;
        }
        else {
            return TYPE_SEND;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        switch (viewType){
            case TYPE_RECIEVE:
                view = inflater.inflate(R.layout.view_recieve,parent,false);
                return new RecieveViewHolder(view);
            case TYPE_SEND:
                view = inflater.inflate(R.layout.view_send,parent,false);
                return new SendViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case TYPE_RECIEVE:
                ((RecieveViewHolder)holder).setData((RecieveData)items.get(position));
                return;
            case TYPE_SEND:
                ((SendViewHolder)holder).setData((SendData)items.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
