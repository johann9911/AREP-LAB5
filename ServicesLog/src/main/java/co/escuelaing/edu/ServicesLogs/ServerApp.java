package co.escuelaing.edu.ServicesLogs;


import static spark.Spark.*;

import java.net.UnknownHostException;

import com.google.gson.Gson;

import co.escuelaing.edu.persistence.ConnectionDBMongo;
public class ServerApp {
    
    public static void main(String... args) throws UnknownHostException{
          port(getPort());
          ConnectionDBMongo connection = new ConnectionDBMongo();
          
          get("/message", (req,res) -> {
        	  Object result;
        	  try {
        		  res.status(200);
            	  res.type("application/json");
            	  result =new Gson().toJson(connection.getMessage());
        	  } catch (Exception e) {
                  res.status(500);
                  result = e.getMessage();
              }
              return result;
          });
          post("/message", (req,res) -> {
        	  Object result;
        	  try {
        		  res.status(201);
            	  res.type("application/json");
            	  result = connection.addMenssage(req.body());
        	  } catch (Exception e) {
                  res.status(500);
                  result = e.getMessage();
        	  }
        	  return result;
          });
    }
    
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 8001;
    }
}