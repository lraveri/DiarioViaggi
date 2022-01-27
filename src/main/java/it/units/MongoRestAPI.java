package it.units;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Sorts;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;
import com.mongodb.client.result.UpdateResult;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;
import org.bson.conversions.Bson;

@Path("/mongojourneys")
public class MongoRestAPI {

    @Context
    HttpServletRequest request;
    
    @Context
    HttpServletResponse response;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJourneys() {
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase journeyDB = mongoClient.getDatabase("journeys");
        MongoCollection<Document> journeyCollection = journeyDB.getCollection("user");
        BasicDBObject query = new BasicDBObject();
        String username = request.getUserPrincipal().getName();
        query.put("username", username);
        List<Document> journeys = journeyCollection.find(query).sort(Sorts.descending("data")).into(new ArrayList<Document>());
        String json = new Gson().toJson(journeys);
        return Response.ok(json).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postJourney(String journeyJsonString) {
        Gson gson = new Gson();
        Journey journey = gson.fromJson(journeyJsonString, Journey.class);
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase journeyDB = mongoClient.getDatabase("journeys");
        MongoCollection<Document> journeyCollection = journeyDB.getCollection("user");
        String username = request.getUserPrincipal().getName();
        Document idMaxDoc = journeyCollection.find().sort(new Document("id", -1)).first();
        int idMax;
        try {
            idMax = idMaxDoc.getInteger("id");
        } catch (Exception e) {
            idMax = 0;
        }
        Document b = new Document();
        b.append("id", idMax + 1)
                .append("data", journey.getData())
                .append("mezzo", journey.getMezzo())
                .append("tappe", journey.getTappe())
                .append("percorso", journey.getPercorso())
                .append("username", username);
        journeyCollection.insertOne(b);
        return Response.status(201).entity(b.toJson()).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putJourney(String journeyJsonString) {
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase journeyDB = mongoClient.getDatabase("journeys");
        MongoCollection<Document> journeyCollection = journeyDB.getCollection("user");
        Gson gson = new Gson();
        Journey journey = gson.fromJson(journeyJsonString, Journey.class);
        Bson filter = eq("id", Integer.parseInt(journey.getId()));
        Bson updateData = set("data", journey.getData());
        Bson updateMezzo = set("mezzo", journey.getMezzo());
        Bson updateTappe = set("tappe", journey.getTappe());
        Bson updatePercorso = set("percorso", journey.getPercorso());
        Bson updateOperations = combine(updateData, updateMezzo, updateTappe, updatePercorso);
        UpdateResult updateResult = journeyCollection.updateOne(filter, updateOperations);
        System.out.println(journeyCollection.find(filter).first().toJson());
        System.out.println(updateResult);
        return Response.status(201).entity(gson.toJson(journey)).build();
    }

}
