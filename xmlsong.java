import java.util.*;
import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.*;


class XmlSong
{
	String file;
	XmlSong(String title,int id)
	{
		System.out.println(title+id);
		file=new String();
		/*if(name.equals("System of a down"))
			file="C:\\mca21\\vipul\\src\\sample3.xml";
		else if(name.equals("Metallica"))
			file="C:\\mca21\\vipul\\src\\sample.xml";
		else if(name.equals("G Unit"))
			file="C:\\mca21\\vipul\\src\\sample2.xml";*/
		//URLSongs doc=new URLSongs();
		String msg=null;
		int lang=1;
		GenURL gu = new GenURL();
		msg = gu.getURL(title, lang, id);
		System.out.println(msg);
		XmlUrl xu=new XmlUrl();
		file=xu.getXML(msg);
		//file=doc.getFile(title,lang,id);
	}
	ArrayList parse()
	{
		DOMParser2 dp= new DOMParser2();
		dp.parseXmlFile(file);
		int i = dp.parseDocument();
		if(i==0)
		{
			XMLParser xp = new XMLParser(file);
			ArrayList <Albums>temp = xp.parse();
			Albums aa = (Albums)temp.get(0);
			String t = aa.title;
			int id = aa.id;
			XmlSong xs = new XmlSong(t,id);
			ArrayList sss = xs.parse();
			return sss;
		}
		else
		{
			ArrayList album=dp.printData();
			return album;
		}
		
	}
}

class DOMParser2
{
	int album_count=0;
	int artist_count=0;
	Document dom;
	String file;
	ArrayList<Songs> myEmpls;
	DOMParser2()
	{
		myEmpls=new ArrayList<Songs>();
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
            //doc = db.parse(is); 
			dom = db.parse(is);
			file=filename;

		}catch(ParserConfigurationException pce) {
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	int parseDocument(){
		//get the root element
		Element docEle = dom.getDocumentElement();
		ArrayList <Albums> temp;
		//get a nodelist of elements
		NodeList nl = docEle.getElementsByTagName("song");
		if(nl != null && nl.getLength() > 0) {
			for(int i = 0 ; i < nl.getLength();i++) {

				//get the Albums element
				Element el = (Element)nl.item(i);

				//get the Albums object
				Songs e = getAlbums(el,docEle);
				e.print();
				//add it to list
				myEmpls.add(e);
			}
			return 1;
		}
		else
		{
			System.out.println("No Songs Found");
			return 0;
			
		}
	}
	
	/**
	 * I take an Albums element and read the values in, create
	 * an Albums object and return it
	 */
	private Songs getAlbums(Element empEl,Element docEle) {

		String title = empEl.getAttribute("title");
		int album_count1 = Integer.parseInt(empEl.getAttribute("album_count"));
		int artist_count1 = Integer.parseInt(empEl.getAttribute("artist_count"));
		int id = Integer.parseInt(empEl.getAttribute("id"));
		int length = Integer.parseInt(empEl.getAttribute("length"));
		Albums at[]=new Albums[artist_count1];
		Albums al[]=new Albums[album_count1];
		String language=empEl.getAttribute("lang");
		int lang=0;
		if(language.equals(""))
		{
			lang=1;
		}
		else
		{
			lang=Integer.parseInt(language);
		}
		//System.out.println(artist_count1);
		//for each <Albums> element get text or int values of
		//name ,id, age and name
		String name=new String();
		int artist_id=0;
		NodeList n2 = empEl.getElementsByTagName("artist");
		if(n2 != null && n2.getLength() > 0) {
			System.out.println(n2.getLength());
			//for(int i = 0,j = artist_count ; j < (artist_count+artist_count1);i++,j++) {
				//String tag = n2.item().getNodeValue();
				//System.out.println(tag);
			for(int i=0;i<n2.getLength();i++){
				Element e2=(Element)n2.item(i);
				name = e2.getAttribute("title");
				artist_id = Integer.parseInt(e2.getAttribute("id"));
				at[i] = new Albums();
				at[i].title=name;
				at[i].id=artist_id;
				at[i].type="Artist";
			}
		}
		//artist_count+=artist_count1;
		int album_id=0,img_id;
		NodeList n3 = empEl.getElementsByTagName("album");
		if(n3 != null && n3.getLength() > 0) {
			for(int i=0;i<n3.getLength();i++) {
				Element e3=(Element)n3.item(i);
				name= e3.getAttribute("title");
				album_id=Integer.parseInt(e3.getAttribute("id"));
				img_id=Integer.parseInt(e3.getAttribute("img_id"));
				al[i]=new Albums();
				al[i].title=name;
				al[i].id=album_id;
				al[i].image_id=img_id;
				al[i].type="Album";
			}
		}
		/*String name = getTextValue(empEl,"Artist");
		String movie = getTextValue(empEl,"Movie");
		String image = getTextValue(empEl,"Image");*/

		
		//Create a new Albums with the value read from the xml nodes
		Songs mysong = new Songs(al,at);
		mysong.title=title;
		mysong.id=id;
		mysong.length=length;
		mysong.lang=lang;
		return mysong;
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
		System.out.println("Meraaa"+myEmpls.size());
		return myEmpls;
	/*	System.out.println("No of Albumss '" + myEmpls.size() + "'.");

		Iterator it = myEmpls.iterator();
		while(it.hasNext()) {
			Albums e = (Albums)it.next();
			e.print();
		}*/
	}
}
