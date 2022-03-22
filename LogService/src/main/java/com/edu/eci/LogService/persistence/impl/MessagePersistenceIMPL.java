package com.edu.eci.LogService.persistence.impl;

import com.edu.eci.LogService.model.Message;
import com.edu.eci.LogService.persistence.DBConnection;
import com.edu.eci.LogService.persistence.MessagePersistence;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;

public class MessagePersistenceIMPL implements MessagePersistence {

    public MongoClient mongoClient = new DBConnection().getMongoClient();

    @Override
    public void createMessage(Message message) {
        System.out.println("Se recive un mensaje");
        MongoDatabase database = mongoClient.getDatabase("ArepLab5");
        MongoCollection<Document> collection =database.getCollection("message");
        System.out.println("Se obtiene conexion");
        Document document=new Document();
        document.put("msgContent",message.getMsgContent());
        document.put("date", message.getDate());
        collection.insertOne(document);
    }

    @Override
    public ArrayList<Message> getMessages() {
        ArrayList<Message> messages=new ArrayList<>();
        MongoDatabase database = mongoClient.getDatabase("ArepLab5");
        MongoCollection<Document> collection =database.getCollection("message");
        FindIterable fit = collection.find();
        ArrayList<Document> docs = new ArrayList<Document>();
        fit.into(docs);

        for (Document document:docs) {
            String mensaje= (String) document.get("msgContent");
            Date date= (Date) document.get("date");
            messages.add(new Message(mensaje, date));
        }

        return messages;
    }
}
