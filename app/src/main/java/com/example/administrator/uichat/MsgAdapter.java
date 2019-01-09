package com.example.administrator.uichat;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private List<Msg> msgList;

    public MsgAdapter(List<Msg> msgList) {
        this.msgList = msgList;
    }


    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout leftLayout;

        LinearLayout rightLayout;

        TextView leftMsg;

        TextView rightMsg;

        public ViewHolder(View view) {
            super(view);
            leftLayout = (LinearLayout) view.findViewById(R.id.linearLayout_left);
            rightLayout = (LinearLayout) view.findViewById(R.id.linearLayout_right);
            leftMsg = (TextView) view.findViewById(R.id.tv_left);
            rightMsg = (TextView) view.findViewById(R.id.tv_right);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.msg_item, viewGroup, false);//加载子项布局
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Msg msg = msgList.get(i);//获取List列表中的Msg实例
        if (msg.getType() == Msg.TYPE_RECEIVED) {
            //如果是收到的消息，则显示左边的消息布局，将右边的消息布局隐藏
            viewHolder.leftLayout.setVisibility(View.VISIBLE);//显示左边消息布局
            viewHolder.rightLayout.setVisibility(View.GONE);//隐藏右边消息布局，并且不占屏幕空间
            viewHolder.leftMsg.setText("" + msg.getContent());//将消息内容显示
        } else if (msg.getType() == Msg.TYPE_SEND) {
            //如果是发出的消息，则显示右边的消息布局，将左边的消息布局隐藏
            viewHolder.rightLayout.setVisibility(View.VISIBLE);//显示右边消息布局
            viewHolder.leftLayout.setVisibility(View.GONE);//隐藏左边消息布局
            viewHolder.rightMsg.setText("" + msg.getContent());//将消息内容显示
        }
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }


}
