import java.util.*;
import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.*;


class XMLParser
{
	String file;
	XMLParser(String name,String type)
	{
		file=new String();
		/*if(name.equals("System of a down"))
			file="C:\\mca21\\vipul\\src\\sample3.xml";
		else if(name.equals("Metallica"))
			file="C:\\mca21\\vipul\\src\\sample.xml";
		else if(name.equals("G Unit"))
			file="C:\\mca21\\vipul\\src\\sample2.xml";*/
		/*String url=null;
		UrlGen doc=new UrlGen();
		url=doc.getFile(name,type);
		XmlUrl xu = new XmlUrl();
		file=xu.getXML(url);*/
		String url = "http://www.mime360.com/properties/26852361/1/browseAlama.php?";
		String arr[]=new String [3];
		arr[0]=name;
		arr[1]="1";
		arr[2]=type;
		RESTClient r = new RESTClient(url,"Get",arr,0);
		file = r.getResponse();
	}
	XMLParser(String filename)
	{
		file=filename;
	}
	ArrayList parse()
	{
		DOMParser dp= new DOMParser();
		dp.parseXmlFile(file);
		dp.parseDocument();
		ArrayList album=dp.printData();
		return album;
	}
}

class DOMParser
{
	Document dom;
	ArrayList<Albums> myEmpls;
	DOMParser()
	{
		myEmpls=new ArrayList<Albums>();
		//parseXmlFile(filename);
		//parseDocument();
		//printData();
	}
	void parseXmlFile(String filename){
		//get the factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {

			//Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();

			//parse using builder to get DOM representation of the XML file
			InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(filename));
			dom = db.parse(is);


		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	void parseDocument(){
		//get the root element
		Element docEle = dom.getDocumentElement();

		//get a nodelist of elements
		NodeList nl = docEle.getElementsByTagName("other_result");
		if(nl != null && nl.getLength() > 0) {
			for(int i = 0 ; i < nl.getLength();i++) {

				//get the Albums element
				Element el = (Element)nl.item(i);

				//get the Albums object
				Albums e = getAlbums(el,docEle);

				//add it to list
				myEmpls.add(e);
			}
		}
	}
	
	/**
	 * I take an Albums element and read the values in, create
	 * an Albums object and return it
	 */
	private Albums getAlbums(Element empEl,Element docEle) {

		//for each <Albums> element get text or int values of
		//name ,id, age and name
		/*String artist_name=new String();
		int artist_id=0;
		NodeList n2 = docEle.getElementsByTagName("Artist");
		if(n2 != null && n2.getLength() > 0) {
			//for(int i = 0 ; i < n2.getLength();i++) {
				Element e2=(Element)n2.item(0);
				artist_name= e2.getAttribute("name");
				artist_id=Integer.parseInt(e2.getAttribute("id"));
			//}
		}
		//String name = getTextValue(empEl,"Artist");
		String movie = getTextValue(empEl,"Movie");
		String image = getTextValue(empEl,"Image");*/
		
		int id = Integer.parseInt(empEl.getAttribute("id")); 
		String title = empEl.getAttribute("title");
		int song_count = Integer.parseInt(empEl.getAttribute("song_count"));
		int image_id = Integer.parseInt(empEl.getAttribute("img_id"));
		String type=new String();
		if(song_count==-1)
		{
			type="Artist";
		}
		else
		{
			type="album";
		}
		//Create a new Albums with the value read from the xml nodes
		Albums e = new Albums(title,song_count,image_id,id,type);

		return e;
	}


	/**
	 * I take a xml element and the tag name, look for the tag and get
	 * the text content
	 * i.e for <Albums><name>John</name></Albums> xml snippet if
	 * the Element points to Albums node and tagName is 'name' I will return John
	 */
	private String getTextValue(Element ele, String tagName) {
		String textVal = null;
		NodeList nl = ele.getElementsByTagName(tagName);
		if(nl != null && nl.getLength() > 0) {
			Element el = (Element)nl.item(0);
			textVal = el.getFirstChild().getNodeValue();
		}

		return textVal;
	}


	/**
	 * Calls getTextValue and returns a int value
	 */
	private int getIntValue(Element ele, String tagName) {
		//in production application you would catch the exception
		return Integer.parseInt(getTextValue(ele,tagName));
	}
	
	ArrayList printData(){
		return myEmpls;
	/*	System.out.println("No of Albumss '" + myEmpls.size() + "'.");

		Iterator it = myEmpls.iterator();
		while(it.hasNext()) {
			Albums e = (Albums)it.next();
			e.print();
		}*/
	}
}
