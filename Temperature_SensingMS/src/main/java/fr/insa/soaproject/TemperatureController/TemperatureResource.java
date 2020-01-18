package fr.insa.soaproject.TemperatureController;

import java.io.IOException;
import java.util.Set;

import javax.xml.bind.JAXB;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RestController;

import fr.insat.om2m.tp2.client.Client;
import fr.insat.om2m.tp2.client.Response;

@RestController
public class TemperatureResource {
	
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
		} catch (JSONException e) {
		e.printStackTrace();
	} finally {
		
		}
	
}
}


