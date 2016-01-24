package com.example.sony.kakaorecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sony on 2016-01-24.
 */
public class RecieveViewHolder extends RecyclerView.ViewHolder {
    TextView messageView;
    TextView dateView;
    ImageView iconView;
    RecieveData data;
    public RecieveViewHolder(View itemView) {
        super(itemView);
        messageView = (TextView)itemView.findViewById(R.id.text_message);
        iconView = (ImageView)itemView.findViewById(R.id.image_icon);
        dateView = (TextView)itemView.findViewById(R.id.text_date);
    }
    public void setData(RecieveData data){
        this.data = data;
        iconView.setImageResource(R.mipmap.ic_launcher);
        messageView.setText(data.message);
        dateView.setText(data.date);
    }
}
