package co.escuelaing.edu.persistence;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import co.escuelaing.edu.model.Message;

public class ConnectionDBMongo {
	MongoClientURI uri;
	private MongoClient mongo;
	public ConnectionDBMongo() throws UnknownHostException {
		
		mongo = new MongoClient("35.172.193.175",27017);
	}
	public String addMenssage(String bodyMessage) {
		MongoDatabase db = mongo.getDatabase("ServiceLog");
		MongoCollection<Document> collection = db.getCollection("Message");
		Document document = new Document();
		Message message = new Message(bodyMessage);
		document.put("description", message.getDescription());
		document.put("date", message.getDate());
		collection.insertOne(document);

		return document.toJson();
	}
	public List<Message> getMessage() {
		String description;
		Date date;
		List<Message> messages = new ArrayList<>();
		MongoDatabase db = mongo.getDatabase("ServiceLog");
		MongoCollection<Document> collection = db.getCollection("Message");
		
		FindIterable<Document> iterable = collection.find().sort(new BasicDBObject("date", -1)).limit(10);
		
		ArrayList<Document> docs = new ArrayList<>();
		iterable.into(docs);
		for (Document document : docs) {
			description = (String) document.get("description");
            date = (Date) document.get("date");
            messages.add(new Message(description, date));
        }
		return messages;
	}

}
