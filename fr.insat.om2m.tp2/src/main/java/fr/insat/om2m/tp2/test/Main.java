package fr.insat.om2m.tp2.test;

import java.io.IOException;
/*
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
*/
import org.json.JSONObject;

import fr.insat.om2m.tp2.client.*;

public class Main {

	public static void main(String[] args) {
		
	     Response response = new Response();
	     Client client = new Client();
	     try {
	     response = client.retrieve("http://3.120.244.18:8080/~/in-cse/in-name/TEMPERATURE_SENSORS/DATA/ol","admin:admin");
	     response.getRepresentation();
	     // System.out.println(response.getRepresentation());
	     JSONObject obj = new JSONObject(response.getRepresentation());
		 String con = obj.getJSONObject("m2m:cin").getString("con");
		 System.out.println(con);
	
	     } catch (IOException e1) {
				e1.printStackTrace();
			} finally {
			
			}
}
}