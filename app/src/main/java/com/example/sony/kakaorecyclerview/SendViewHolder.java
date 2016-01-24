package com.example.sony.kakaorecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sony on 2016-01-24.
 */
public class SendViewHolder extends RecyclerView.ViewHolder {
    TextView messageView;
    TextView dateView;
    ImageView iconView;
    SendData data;
    public SendViewHolder(View itemView) {
        super(itemView);
        messageView = (TextView)itemView.findViewById(R.id.text_message);
        iconView = (ImageView)itemView.findViewById(R.id.image_icon);
        dateView = (TextView)itemView.findViewById(R.id.text_date);
    }
    public void setData(SendData data){
        this.data = data;
        messageView.setText(data.message);
        iconView.setImageResource(R.mipmap.ic_launcher);
        dateView.setText(data.date);
    }
}
