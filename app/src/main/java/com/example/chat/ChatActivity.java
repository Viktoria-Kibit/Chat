package com.example.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ChatActivity extends AppCompatActivity {

    private ListView chatListView;
    private ChatAdapter chatAdapter;
    private List<ChatMessage> chatMessages;
    private EditText messageEditText;
    private Button sendButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatListView = findViewById(R.id.chatListView);
        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);

        chatMessages = new ArrayList<>();
        chatMessages.add(new ChatMessage("Василь", "Привіт, як справи?", "12:30 PM"));
        chatMessages.add(new ChatMessage("Оксана", "Привіт, все добре, дякую!", "12:35 PM"));
        chatMessages.add(new ChatMessage("Василь", "Чудово! Давай зустрінемось сьогодні ввечері?", "12:40 PM"));

        chatAdapter = new ChatAdapter(this, chatMessages);
        chatListView.setAdapter(chatAdapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });

    }

    private void sendMessage() {
        String messageText = messageEditText.getText().toString();
        String sender = "Василь"; // Логін користувача, який залогінений

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        String time = sdf.format(new Date());

        ChatMessage message = new ChatMessage(sender, messageText, time);

        chatMessages.add(message);

        chatAdapter.notifyDataSetChanged();

        messageEditText.setText("");
    }


}