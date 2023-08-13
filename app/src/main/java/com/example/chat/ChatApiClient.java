package com.example.chat;

import java.util.List;
import java.util.function.Consumer;

public interface  ChatApiClient {
    void registerUser(String username, String password, Consumer<String> callback);
    void authenticateUser(String username, String password, Consumer<String> callback);
    void sendMessage(String message, Consumer<String> callback);
    void getOnlineUsers(Consumer<List<String>> callback);

}
