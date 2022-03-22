package com.edu.eci.LogService.persistence;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class DBConnection {
    public MongoClientURI uri;
    public MongoClient mongoClient;

    public DBConnection() {
        uri = new MongoClientURI(
                "mongodb+srv://Juank648:pwtqXPYKf48Tn@datamongodbieti.7hrpn.mongodb.net/ArepLab5?retryWrites=true&w=majority");

        mongoClient = new MongoClient(uri);
    }

    public MongoClientURI getUri() {
        return uri;
    }

    public void setUri(MongoClientURI uri) {
        this.uri = uri;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public void setMongoClient(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }
}
