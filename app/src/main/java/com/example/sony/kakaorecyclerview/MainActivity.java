package com.example.sony.kakaorecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RadioGroup category;
    EditText inputView;
    MyAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        category = (RadioGroup)findViewById(R.id.radio_select);
        inputView = (EditText)findViewById(R.id.edit_message);
        mAdapter = new MyAdapter();
        recyclerView.setAdapter(mAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Button btn = (Button)findViewById(R.id.btn_send);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = category.getCheckedRadioButtonId();
                if(id == R.id.radio_recieve){
                    RecieveData rd = new RecieveData();
                    rd.iconId = R.mipmap.ic_launcher;
                    rd.message = inputView.getText().toString();
                    rd.date = new Date().toString();
                    mAdapter.add(rd);
                }
                else {
                    SendData sd = new SendData();
                    sd.iconId = R.mipmap.ic_launcher;
                    sd.message = inputView.getText().toString();
                    sd.date = new Date().toString();
                    mAdapter.add(sd);
                }
                inputView.setText("");
            }
        });


    }
}
