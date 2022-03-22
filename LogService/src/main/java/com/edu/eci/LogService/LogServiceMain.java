package com.edu.eci.LogService;

import com.edu.eci.LogService.model.Message;
import com.edu.eci.LogService.persistence.impl.MessagePersistenceIMPL;
import com.google.gson.Gson;

import static spark.Spark.*;

public class LogServiceMain {

    public static void main(String[] args){

        System.out.println("Hello World");

        MessagePersistenceIMPL messagePersistence= new MessagePersistenceIMPL();
        port(getPort());

        get("/messages",(request, response) -> {
            response.status(200);
            response.type("application/json");
            return new Gson().toJson(messagePersistence.getMessages());
        });

        post("/messages",(request, response) -> {
            Message msg = new Message(request.body());
            messagePersistence.createMessage(msg);
            return "";
        });

    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}

