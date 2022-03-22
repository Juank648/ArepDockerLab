package com.edu.eci.RoundRobin;

import static spark.Spark.*;

public class RoundRobinApp {

    public static void main(String[] args){

        System.out.println("Hello World from RoundRobinApp!!");

        port(getPort());
        staticFileLocation("/static");
        HTTPClient client=new HTTPClient();
        get("/", (req, res) -> {
            res.redirect("index.html");
            return null;
        });

        get("/messages",(req, res) -> {
            res.status(200);
            res.type("application/json");
            String response=client.getMessages("/messages");
            client.changePort();
            return response;
        });

        post("/messages",(request, response) -> {
            client.postMessage(request.body(),"/messages");
            client.changePort();
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
