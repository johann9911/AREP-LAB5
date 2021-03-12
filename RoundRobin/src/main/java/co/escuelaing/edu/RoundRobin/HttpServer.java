package co.escuelaing.edu.RoundRobin;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class HttpServer {
	private String[] ports = { ":8001", ":8002", ":8003" };
	private int numServer = 0;
	private String url = "http://localhost";

	public String addMessage(String message) throws UnirestException {
		String urlSend = url+ports[numServer]+"/message";
		HttpResponse<String> response = Unirest.post(urlSend)
				      .body(message)
				      .asString();
		System.out.println("Petición POST de "+url+ports[numServer]);
		//changeServer();
		return response.getBody();
	}
	
	public String getMessages() throws UnirestException {
		String urlSend = url+ports[numServer]+"/message";
		
		HttpResponse<String> response = Unirest.get(urlSend)
			      .asString();
		System.out.println("Petición GET de "+url+ports[numServer]);
		//changeServer();
		return response.getBody();
	}
	private void changeServer() {
		numServer +=1;
		if(numServer>(ports.length-1)) {
			numServer=0;
		}
		
	}

}
