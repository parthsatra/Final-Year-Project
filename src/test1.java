
class test1
{
	public static void main(String args[])
	{
		/*String msg=null;
		String file=null;
		GenURL gu = new GenURL();
		msg = gu.getURL("F A L T U", 1, 82266);
		System.out.println(msg);
		XmlUrl xu=new XmlUrl();
		file=xu.getXML(msg);
		System.out.println(file);
		
		XmlSong xs=new XmlSong("A R Rahman",4567);
		xs.parse();
		*/
		String url = "http://www.mime360.com/properties/26852361/1/browseAlama.php?";
		String arr[]=new String [3];
		arr[0]="b";
		arr[1]="1";
		arr[2]="al";
		RESTClient r = new RESTClient(url,"Post",arr,0);
		String file = r.getResponse();
		System.out.println(file);
	}
}