package it.units;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoDBWrapper {
    private static MongoDBWrapper instance = null;
    private MongoClient mongoClient;

    private MongoDBWrapper() {
        try {
            mongoClient = MongoClients.create();
        } catch (Exception e) {
            System.out.println("ERROR!!");
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static MongoDBWrapper getInstance() {
        if (instance == null) {
            instance = new MongoDBWrapper();
        }
        return instance;
    }
    
    
    
}
