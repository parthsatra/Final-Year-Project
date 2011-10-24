import java.io.*;
import java.net.*;

public class UrlGen
{
	String getFile(String name,String type)
	{
		/*String filename=new String();
		try{
			filename="abc.xml";
			File xmldoc = new File(filename);
		 	FileWriter fw= new FileWriter(filename);
		 	BufferedWriter out = new BufferedWriter(fw);
		 	
		 	URL yahoo = new URL("http://www.mime360.com/properties/26852361/1/browseAlama.php?q="+name+"&lang=1&type="+type);
	     	URLConnection yc = yahoo.openConnection();
	     	BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
	     	String inputLine;
	     	while ((inputLine = in.readLine()) != null) 
	     	{
	    		 out.write(inputLine);
	    		 out.write("\n");
	    		 //System.out.println(inputLine);
	     	}
	     	in.close();
	     	out.close();
	     	fw.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return filename;
	}*/
		String msg=null;
		String lang=1+"";
		try{
			msg = "http://www.mime360.com/properties/26852361/1/browseAlama.php?";
			msg += URLEncoder.encode("q", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8");
			msg += "&" + URLEncoder.encode("lang", "UTF-8") + "=" + URLEncoder.encode(lang, "UTF-8");
			msg += "&" + URLEncoder.encode("type", "UTF-8") + "=" + URLEncoder.encode(type, "UTF-8");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return msg;
	}
}