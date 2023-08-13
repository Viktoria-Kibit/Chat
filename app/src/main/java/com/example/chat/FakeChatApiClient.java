package com.example.chat;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FakeChatApiClient  implements ChatApiClient{

    @Override
    public void registerUser(String username, String password, Consumer<String> callback) {
        callback.accept("Registration successful");
    }

    @Override
    public void authenticateUser(String username, String password, Consumer<String> callback) {
        callback.accept("Authentication successful");
    }

    @Override
    public void sendMessage(String message, Consumer<String> callback) {
        callback.accept("Message sent successfully");
    }

    @Override
    public void getOnlineUsers(Consumer<List<String>> callback) {
        List<String> onlineUsers = Arrays.asList("user1", "user2", "user3");
        callback.accept(onlineUsers);
    }
}
