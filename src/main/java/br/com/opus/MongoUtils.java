package br.com.opus;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import java.net.UnknownHostException;

/**
 * Created by andersonjso on 6/27/18.
 */
public class MongoUtils {

    //TODO: Add this line for use in remote, changing the url
    // MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));

    private static MongoClient mongoClient;

    static {
        mongoClient = new MongoClient();
    }

    public static DB databaseTest = mongoClient.getDB("dpidentification");
    private static Jongo jongo = new Jongo(databaseTest);

    public static MongoCollection classes (){
        return jongo.getCollection("classes");
    }
    public static MongoCollection symptoms (){
        return jongo.getCollection("symptoms");
    }
    public static MongoCollection snippets (){
        return jongo.getCollection("snippets");
    }
}

/*
public class MongoUtils {


}

 */
