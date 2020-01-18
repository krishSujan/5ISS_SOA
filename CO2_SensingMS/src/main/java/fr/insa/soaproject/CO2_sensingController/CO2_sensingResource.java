package fr.insa.soaproject.CO2_sensingController;

import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import fr.insat.om2m.tp2.client.Client;
import fr.insat.om2m.tp2.client.Response;

public class CO2_sensingResource {

	public static void main(String[] args) {
		Response response = new Response();
	    Client client = new Client();
	    
	    try {
	    response = client.retrieve("http://3.120.244.18:8080/~/in-cse/in-name/CO2_SENSORS/CONCENTRATION/ol","admin:admin");
	    response.getRepresentation();
	    // System.out.println(response.getRepresentation());
	    JSONObject obj = new JSONObject(response.getRepresentation());
		 String con = obj.getJSONObject("m2m:cin").getString("con");
		 System.out.println(con);

	    } catch (IOException e1) {
				e1.printStackTrace();
			} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			
			}
		
	}
}
