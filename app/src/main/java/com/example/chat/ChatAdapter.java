package com.example.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ChatAdapter extends ArrayAdapter<ChatMessage> {
    private Context context;
    private List<ChatMessage> chatMessages;

    public ChatAdapter(Context context, List<ChatMessage> chatMessages) {
        super(context, 0, chatMessages);
        this.context = context;
        this.chatMessages = chatMessages;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.chat_item, parent, false);
        }

        ChatMessage message = chatMessages.get(position);

        TextView senderTextView = convertView.findViewById(R.id.senderTextView);
        senderTextView.setText(message.getSender());

        TextView messageTextView = convertView.findViewById(R.id.messageTextView);
        messageTextView.setText(message.getMessage());

        TextView timeTextView = convertView.findViewById(R.id.timeTextView);
        timeTextView.setText(message.getTime());

        return convertView;
    }
}
