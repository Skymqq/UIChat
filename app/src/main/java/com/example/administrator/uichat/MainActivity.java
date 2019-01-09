package com.example.administrator.uichat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList<>();

    private EditText et_msg;

    private Button btn_send;

    private RecyclerView recyclerView;

    private MsgAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//初始化UI控件
        initData();//初始化数据
    }


    private void initView() {
        et_msg = (EditText) findViewById(R.id.et_msg);
        btn_send = (Button) findViewById(R.id.btn_send);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

    }

    private void initData() {
        initMsg();//初始化消息
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MsgAdapter(msgList);
        recyclerView.setAdapter(adapter);
    }

    private void initMsg() {
        Msg msg1 = new Msg("Hello guy", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("Hello Who is that?", Msg.TYPE_SEND);
        msgList.add(msg2);
        Msg msg3 = new Msg("This is Tom. Nice talking to you. ", Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = et_msg.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SEND);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size() - 1);//当有消息时，刷新RecyclerView中的显示
                    recyclerView.scrollToPosition(msgList.size() - 1);//将RecyclerView定位到最后一行
                    et_msg.setText("");//清空输入框中的内容
                }
            }
        });
    }

}
