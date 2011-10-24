import java.util.ArrayList;

class test
{
	public static void main(String[] args)
	{
		XMLParser xp=new XMLParser("b","at");
		ArrayList album=xp.parse();
		int n=0;
		while(n<album.size())
		{
			Albums a = (Albums)album.get(n);
			a.print();
			n++;
		}
	}
}