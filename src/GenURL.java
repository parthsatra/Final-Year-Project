import java.net.*;

class GenURL
{
	String getURL(String title, int lang, int id)
	{
		String msg=null;
		String lang1 = Integer.toString(lang);
		String id1 = Integer.toString(id);
		try{
			msg = "http://www.mime360.com/properties/26852361/1/searchEngine.php?";
			msg += URLEncoder.encode("q", "UTF-8") + "=" + URLEncoder.encode(title, "UTF-8");
			msg += "&" + URLEncoder.encode("lang", "UTF-8") + "=" + URLEncoder.encode(lang1, "UTF-8");
			msg += "&" + URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(id1, "UTF-8");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return msg;
	}
}