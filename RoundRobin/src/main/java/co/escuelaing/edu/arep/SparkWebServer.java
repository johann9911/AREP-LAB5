package co.escuelaing.edu.arep;


import static spark.Spark.*;
public class SparkWebServer {
    
    public static void main(String... args){
          port(getPort());
          
          HttpServer server = new HttpServer();
          
          staticFiles.location("/static");
          get("/", (req,res) -> {
        	  res.redirect("/index.html");
        	  return "";
          });
          get("/logs", (req,res) -> {
        	  res.status(200);
              res.type("application/json");
        	  Object r = server.getMessages();
        	  return r;
          });
          
          post("/logs", (req,res) -> {
        	  res.status(201);
        	  server.addMessage(req.body());
        	  return "";
          });
    }
    
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
    
}