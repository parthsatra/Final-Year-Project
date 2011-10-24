import java.net.*;
import java.io.*;
import org.apache.http.impl.client.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.*;
import org.apache.http.*;
import org.apache.http.util.*;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.methods.HttpRequestBase;

class XmlUrl
{
	 String getXML(String xmlUrl){     
            String line = null;

            try {
            	//URL u = new URL(xmlUrl);
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpGet httpPost = new HttpGet(xmlUrl);

                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();
                line = EntityUtils.toString(httpEntity);
               
            } catch (UnsupportedEncodingException e) {
                line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
            } catch (MalformedURLException e) {
                line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
            } catch (IOException e) {
                line = "<results status=\"error\"><msg>Can't connect to server</msg></results>";
            }
            //line=line.replaceAll("&", "&amp;");
            System.out.println(line);
            return line;

    }
}