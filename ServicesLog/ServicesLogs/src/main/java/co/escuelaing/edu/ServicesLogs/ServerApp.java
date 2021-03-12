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
        	  res.status(200);
        	  res.type("application/json");
        	  return new Gson().toJson(connection.getMessage());
          });
          post("/message", (req,res) -> {
        	  return connection.addMenssage(req.body());
          });
    }
    
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 8001;
    }
}