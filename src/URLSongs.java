import java.util.*;
import java.io.*;
import java.net.*;

class URLSongs
{
	String getFile(String title,int lang,int id)
	{
		System.out.println(title+" "+id);
		String filename=new String();
		try{
			filename="def.xml";
			File xmldoc = new File(filename);
		 	FileWriter fw= new FileWriter(filename);
		 	BufferedWriter out = new BufferedWriter(fw);
		 	String msg = "http://www.mime360.com/properties/26852361/1/searchEngine.php?q="+title+"&lang="+lang+"&id="+id;
		 	System.out.println(msg);
		 	URL songs = new URL(msg);
	     	URLConnection yc = songs.openConnection();
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
		System.out.println("Xml Parser");
		return filename;
	}
}