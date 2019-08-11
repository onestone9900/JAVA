package aphachehttpclient.module;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class RestApi {
		
	private String charsetType = "UTF-8";
	public  String request(String targetURL, String httpMethod) {

		String result = "";
		
		try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
			
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				public String handleResponse(final HttpResponse response) throws IOException {
					
					int status = response.getStatusLine().getStatusCode();
					HttpEntity entity = response.getEntity();
					if ((status >= 200 && status < 300) || status==400) {
						return entity != null ? EntityUtils.toString(entity, charsetType) : null;
					} else {
							throw new IOException();
					}
				}
				
			};
			
			if ("POST".equalsIgnoreCase(httpMethod)) {
				HttpPost http = new HttpPost(targetURL);

			}else if("PUT".equalsIgnoreCase(httpMethod)) {
				HttpPut http = new HttpPut(targetURL);

			}else if("DELETE".equalsIgnoreCase(httpMethod)) {
				HttpDelete http = new HttpDelete(targetURL);
				
			}else if("GET".equalsIgnoreCase(httpMethod)){
				HttpGet http = new HttpGet(targetURL);
				result = httpClient.execute(http, responseHandler);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
