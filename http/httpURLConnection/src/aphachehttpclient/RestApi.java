package aphachehttpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class RestApi {
	
	private static final String charset="UTF-8";
	private static final int timeout=10000;
	private static final String USER_AGENT = "Mozila/5.0";
	
	//payload 는 body 에 담기는 data
	//Parameter : url/folder?test=test
	//Payload : Body 에 담김
	public  String sendData( String httpMethod, String restUrl, String payload) {

		CloseableHttpClient httpclient = HttpClients.createDefault();
		String responseBody = null;
		try {
			// Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				public String handleResponse(final HttpResponse response) throws IOException {
					int status = response.getStatusLine().getStatusCode();
					HttpEntity entity = response.getEntity();
					if ((status >= 200 && status < 300) || status==400) {
						return entity != null ? EntityUtils.toString(entity, charset) : null;
					} else {
						throw new IOException();
					}
				}
			};
			
			if("GET".equalsIgnoreCase(httpMethod)) {
				
				HttpGet httpGet = new HttpGet(restUrl);
				httpGet.addHeader("User-Agent", USER_AGENT);
				RequestConfig requestConfig = RequestConfig.custom()
						  .setSocketTimeout(timeout)
						  .setConnectTimeout(timeout)
						  .setConnectionRequestTimeout(timeout)
						  .build();
				httpGet.setConfig(requestConfig);
				httpGet.addHeader("Content-type", "application/json");	//jsonData를 받아와야할 경우 사용
				responseBody = httpclient.execute(httpGet, responseHandler);
				
			}else if ("POST".equalsIgnoreCase(httpMethod)) {
				
				HttpPost http = new HttpPost(restUrl);
				RequestConfig requestConfig = RequestConfig.custom()
						  .setSocketTimeout(timeout)
						  .setConnectTimeout(timeout)
						  .setConnectionRequestTimeout(timeout)
						  .build();
				http.setConfig(requestConfig);
				if(payload != null) {
					http.setEntity(new StringEntity(payload, charset)); 
				}
				responseBody = httpclient.execute(http, responseHandler);
				
			}else if("PUT".equalsIgnoreCase(httpMethod)) {
				
				HttpPut http = new HttpPut(restUrl);
				RequestConfig requestConfig = RequestConfig.custom()
						  .setSocketTimeout(timeout)
						  .setConnectTimeout(timeout)
						  .setConnectionRequestTimeout(timeout)
						  .build();
				http.setConfig(requestConfig);
				http.setHeader("Accept", "application/json");
				http.setHeader("Content-type", "text/plain; charset="+charset);
				if(payload != null) {
					http.setEntity(new StringEntity(payload, charset));
				}
				responseBody = httpclient.execute(http, responseHandler);
				
			}else if("DELETE".equalsIgnoreCase(httpMethod)) {
				
				HttpDelete http = new HttpDelete(restUrl);
				RequestConfig requestConfig = RequestConfig.custom()
						  .setSocketTimeout(timeout)
						  .setConnectTimeout(timeout)
						  .setConnectionRequestTimeout(timeout)
						  .build();
				http.setConfig(requestConfig);
				responseBody = httpclient.execute(http, responseHandler);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(httpclient!=null) {
				try {
					httpclient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return responseBody;
	}
}
