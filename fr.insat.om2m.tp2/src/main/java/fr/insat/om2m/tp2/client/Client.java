package fr.insat.om2m.tp2.client;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Client implements ClientInterface {
	private static final String ORIGIN_HEADER = "X-M2M-Origin";
	private static final String CT_HEADER = "Content-Type";
	private static final String ACCEPT = "accept";
	private static final String JSON = "application/json";

	public Response retrieve(String url, String originator) throws IOException {
		Response response = new Response();
		// Instantiate a new Client
		CloseableHttpClient client = HttpClients.createDefault();
		// Instantiate the correct Http Method
		HttpGet get = new HttpGet(url);
		// add headers
		get.addHeader(ORIGIN_HEADER, originator);
		get.addHeader(ACCEPT, JSON);
		try {
			// send request
			CloseableHttpResponse reqResp = client.execute(get);
			response.setStatusCode(reqResp.getStatusLine().getStatusCode());
			response.setRepresentation(IOUtils.toString(reqResp.getEntity()
					.getContent(), "UTF-8"));
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			client.close();
		}
		// return response
		return response;
	}

	public Response create(String url, String representation, String originator, String type)
			throws IOException {
		Response response = new Response();
		//TODO
		// return response
		return response;
	}

	public Response update(String url, String representation, String originator) {
		// TODO Auto-generated method stub
		return null;
	}

	public Response delete(String url, String originator) {
		// TODO Auto-generated method stub
		return null;
	}

}
