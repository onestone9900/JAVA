package http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;

public class HttpPostMethod2 {
	
	
	public String sendPost(String url, String body) throws MalformedURLException, IOException {
    	
    	
    	
    	//urlSetting(!)
    	URL urlObject = null;
		try {
			urlObject = new URL(url);
		} catch (MalformedURLException e) {
			throw e;
		}
		
		//openConnection 생성
    	HttpURLConnection conn=null;
    	try {
			conn = (HttpURLConnection)urlObject.openConnection();
		} catch (IOException e) {
			System.err.println("caste openConnection to HttpURLConnection Error");
			e.printStackTrace();
		}finally {
	        if(conn!=null) {
	        	conn.disconnect();	
	        }
		}
		
    	//connection Setting(변하는 부분)
    	try {
			conn.setRequestMethod("POST");
		} catch (ProtocolException e) {
			e.printStackTrace();
			throw new IOException();
		}finally {
	        if(conn!=null) {
	        	conn.disconnect();	
	        }
		}
    	conn.setRequestProperty("User-Agent", "application/x-www-form-urlencoded");
    	conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
    	//conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
    	conn.setConnectTimeout(10000);
    	conn.setReadTimeout(5000);
    	conn.setDoInput(true);  // Server 통신에서 입력 가능한 상태 (default = true)
    	//conn.setDoOutput(true); // Server 통신에서 출력 가능한 상태 (default = true)
    	
    	DataOutputStream wr=null;
        try {
			wr = new DataOutputStream(conn.getOutputStream());
			wr.writeBytes(body);
			wr.flush();
			wr.close();
		} catch (IOException e) {
			System.err.println("new DataOutputStream Error");
			e.printStackTrace();
		}finally {
			if(wr!=null) {
				try {
					wr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	        if(conn!=null) {
	        	conn.disconnect();	
	        }
		}
		
        // Status Code Definitions Http상태코드 상태코드에 따른
        // https://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html
        int status = 0;
		try {
			status = conn.getResponseCode();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}finally {
	        if(conn!=null) {
	        	conn.disconnect();	
	        }
		}
		
		//read Data
    	String result = null;
        if(status == HttpURLConnection.HTTP_OK || status == HttpURLConnection.HTTP_CREATED || status == HttpURLConnection.HTTP_ACCEPTED){
            BufferedReader br = null;
            StringBuilder sb = null;
			Charset charset = Charset.forName("UTF-8");
			try {
				br = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
				sb = new StringBuilder();
				String line;
				while((line =br.readLine())!=null){
				    sb.append(line+"\n");
				}
				br.close();
				result = sb.toString();
			} catch (IOException e) {
				throw e;
			}finally {
				if(br!=null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					} finally {
				        if(conn!=null) {
				        	conn.disconnect();	
				        }
					}
				}
		        if(conn!=null) {
		        	conn.disconnect();	
		        }
			}
	
        }

        conn.disconnect();	

    	return result;
    	
    }

}
