package http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

public class SendGetMethod2 {
	
	
    public String sendGet(String url) throws IOException{
    	
    	String result = null;
    	HttpURLConnection conn=null;

        URL urlObject = new URL(url);
        
        conn = (HttpURLConnection)urlObject.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Connection","Keep-Alive");
        conn.setRequestProperty("Accept-Charset","UTF-8");
        conn.setRequestProperty("Cache-Control","no-cache"); //ĳ�õ� �����͸� ������� �ʰ� �Ź� �����κ��� �ٽ� ����
        conn.setRequestProperty("Accept-Charset","application/json");
		conn.setConnectTimeout(10000);
		conn.setReadTimeout(5000);
		conn.setDoInput(true);  // Server ��ſ��� �Է� ������ ���·� ����
		conn.setDoOutput(true); // Server ��ſ��� ��� ������ ���·� ����
		
        conn.connect();

        // Status Code Definitions Http�����ڵ� �����ڵ忡 ����
        // https://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html
        int status = conn.getResponseCode();
        if(status == HttpURLConnection.HTTP_OK || status == HttpURLConnection.HTTP_CREATED || status == HttpURLConnection.HTTP_ACCEPTED){
            BufferedReader br = null;
            StringBuilder sb = null;

			Charset charset = Charset.forName("UTF-8");
			br = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
			sb = new StringBuilder();
            String line;
			while((line =br.readLine())!=null){
			    sb.append(line+"\n");
			}
			br.close();
		    conn.disconnect();
			result = sb.toString();
            
        }
		conn.disconnect();
    	
    	return result;
    	
    }

}
