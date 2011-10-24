import java.net.*;
import java.io.*;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.*;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

class RESTClient
{
	private String url;
	String arr[];
	int type;
	String line;
	RESTClient(String u, String method, String arr[], int type)
	{
		line=null;
		this.arr=arr;
		this.type=type;
		url=u;
		if(method.equals("Get"))
		{
			getRequest();
		}
		else if(method.equals("Post"))
		{
			postRequest();
		}
		else if(method.equals("Put"))
		{
			putRequest();
		}
		else if(method.equals("Delete"))
		{
			deleteRequest();
		}
	}
	void getRequest()
	{
		try{
			url += URLEncoder.encode("q", "UTF-8") + "=" + URLEncoder.encode(arr[0], "UTF-8");
			url += "&" + URLEncoder.encode("lang", "UTF-8") + "=" + URLEncoder.encode(arr[1], "UTF-8");
			url += "&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(arr[2], "UTF-8");
			DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpPost = new HttpGet(url);
               
            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            line = EntityUtils.toString(httpEntity);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void postRequest()
	{
		try {
	        URL url;
	        URLConnection urlConnection;
	        
	        // Build request body
	        String body =
	        "q=" + URLEncoder.encode(arr[0], "UTF-8") +
	        "&lang=" + URLEncoder.encode(arr[1], "UTF-8")+
	        "&type=" + URLEncoder.encode(arr[2], "UTF-8");
	 
	        // Create connection
	        url = new URL(this.url);
	        urlConnection = url.openConnection();
	        ((HttpURLConnection)urlConnection).setRequestMethod("POST");
	        urlConnection.setDoInput(true);
	        urlConnection.setDoOutput(true);
	        urlConnection.setUseCaches(false);
	        urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
	        urlConnection.setRequestProperty("Content-Length", ""+ body.length());
	 
	        //Send request
	        DataOutputStream wr = new DataOutputStream (
	                    urlConnection.getOutputStream ());
	        wr.writeBytes (body);
	        wr.flush ();
	        wr.close ();

	        //Get Response	
	        InputStream is = urlConnection.getInputStream();
	        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	        String line;
	        StringBuffer response = new StringBuffer(); 
	        while((line = rd.readLine()) != null) {
	          response.append(line);
	          response.append('\r');
	        }
	        rd.close();
	        this.line = response.toString();
	        
	    }
	    catch(Exception ex) {
	        System.out.println("Exception cought:\n"+ ex.toString());
	    }
	}
	void putRequest()
	{
		try{
			URL url = new URL(this.url);
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("PUT");
			OutputStreamWriter out = new OutputStreamWriter(
			    httpCon.getOutputStream());
			out.write("Resource content");
			out.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void deleteRequest()
	{
		try{
			URL url = new URL(this.url);
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestProperty(
			    "Content-Type", "application/x-www-form-urlencoded" );
			httpCon.setRequestMethod("DELETE");
			httpCon.connect();
			int responseCode = httpCon.getResponseCode();	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	String getResponse()
	{
		return line;
	}
}