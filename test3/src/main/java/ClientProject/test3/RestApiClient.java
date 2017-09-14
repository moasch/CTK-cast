package ClientProject.test3;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.fasterxml.jackson.core.JsonParser;

import net.sf.json.JSONArray;

import org.json.JSONObject;

public class RestApiClient{
	
	public static void main(String[] args){
		
			try {
		
			Client client = ClientBuilder.newClient();
			
			Response response = client.target("http://data.goteborg.se/BridgeService/v1.0/GetGABOpenedStatus/6d1d9f54-779d-4864-82f6-d5ec91ee751c?format=json").request().get();
			
			if(response == null){
				Response.status(Response.Status.NOT_FOUND).entity("URL not found");
			}
			
			String responseString = response.readEntity(String.class);
			
			JSONObject obj = new JSONObject(responseString);
	
			Boolean bridgeOpen = (Boolean) obj.get("Value");
			
			String tmp = "";

			if(bridgeOpen) {
				tmp = "öppen";
			}else {	
				tmp = "stängd";
			}
			
			System.out.println("Göta Älvbron är för tillfället " + tmp + ".");
			
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		
		
	}
	
	
	
}
