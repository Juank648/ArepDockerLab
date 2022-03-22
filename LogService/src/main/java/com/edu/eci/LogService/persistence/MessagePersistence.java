package com.edu.eci.LogService.persistence;

import com.edu.eci.LogService.model.Message;

import java.util.ArrayList;

public interface MessagePersistence {
    void createMessage(Message message);
    ArrayList<Message> getMessages();
}
