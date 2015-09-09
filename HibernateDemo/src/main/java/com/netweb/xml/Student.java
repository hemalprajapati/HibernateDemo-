package com.netweb.xml;

import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Student {

	public static void main(String sp[]){

		// Since 2.10.0, uses MongoClient
		try {
/*			MongoClient mongo = new MongoClient( "localhost" , 27017 );
			System.out.println("Connected To Mongo DB");
			DB db = mongo.getDB("MyMongoDB");
			DBCollection table = db.getCollection("UserMaster");
			
			
			   
			 * Insert a new record in table 
			 * 
		
			BasicDBObject document = new BasicDBObject();
			document.put("name", "Test123456789");
			document.put("age", 26);
			document.put("createdDate", new Date());
			table.insert(document);
			
			
			
			*//**** Find and display ****//*
			
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("age", 26);

			DBCursor cursor = table.find(searchQuery);

			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
			
			*/
			
			MongoClient clientObj=new MongoClient("localhost",27017);
			DB mongoDB=clientObj.getDB("MyMongoDB");
			DBCollection cartMaster=mongoDB.getCollection("CartHeader");
			DBCollection userMaster=mongoDB.getCollection("UserMaster");
			
			
			/*BasicDBObject cartHeader=new BasicDBObject();
			cartHeader.put("userId", "Hemal");
			cartHeader.put("PONumber", "SecondCart");
			cartHeader.put("StartDate", new Date());
			
			cartMaster.insert(cartHeader);*/
			
			BasicDBObject searchQuery=new BasicDBObject();
			searchQuery.put("age",26);
			DBCursor cursor=userMaster.find(searchQuery);
			
			while(cursor.hasNext()){
				BasicDBObject searchQuery2=new BasicDBObject();
				DBObject currentCursor=cursor.next();
				System.out.println("currentCursor==="+currentCursor);
				searchQuery2.put("userId",currentCursor.get("name"));
				DBCursor innterCursor=cartMaster.find(searchQuery2);
				while(innterCursor.hasNext()){
					System.out.println("CART INFO==");
					System.out.println(innterCursor.next());
				}	
				
			}
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
