package utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	public static String post(String url, Map<String, String> param) {

		DefaultHttpClient client = new DefaultHttpClient();
		
        HttpPost httpost = new HttpPost(url);
        httpost.setHeader("Content-Type", "text/json; charset=UTF-8");
        List<NameValuePair> nvps = new ArrayList <NameValuePair>();  
          
        Set<String> keySet = param.keySet();  
        for(String key : keySet) {  
            nvps.add(new BasicNameValuePair(key, param.get(key)));  
        }

        try {  
            httpost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
            HttpResponse response = client.execute(httpost);
		    HttpEntity entity = response.getEntity();
		    System.out.println("status:" + response.getStatusLine());
		    if (entity != null) return EntityUtils.toString(entity);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  
        } catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		return null;
	}
	
	public static String post(String url, String param) {

		DefaultHttpClient client = new DefaultHttpClient();
		
        HttpPost httpost = new HttpPost(url);
        httpost.setHeader("Content-Type", "text/plain; charset=UTF-8");
          
        try {  
            httpost.setEntity(new StringEntity(param, "UTF-8"));
            HttpResponse response = client.execute(httpost);
		    HttpEntity entity = response.getEntity();
		    System.out.println("status:" + response.getStatusLine());
		    if (entity != null) return EntityUtils.toString(entity);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  
        } catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		return null;
	}
}
