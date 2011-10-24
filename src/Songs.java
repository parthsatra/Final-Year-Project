import java.util.*;

class Songs
{
	int id;
	String title;
	Albums album[];
	Albums artist[];
	int length;
	int lang;
	Songs()
	{
	}
	Songs(Albums al[],Albums at[])
	{
		id=0;
		title=new String();
		album=al;
		artist=at;
		length=0;
		lang=1;
	}
	public void print()
	{
		//System.out.println("");
		System.out.println("Title = "+title);
		System.out.println("id = "+id);
		System.out.println("length = "+length);
		System.out.println("language = "+lang);
		for(int i=0;i<album.length;i++)
		{
			System.out.println("Album");
			System.out.println(album[i].title);
		}
		for(int i=0;i<artist.length;i++)
		{
			System.out.println("Artist");
			System.out.println(artist[i].title);
		}
	}
}