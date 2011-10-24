public class Albums {
	String title;
	int song_count;
	int image_id;
	int id;
	String type;
	
	Albums()
	{
	}
	Albums(String title,int song_count,int image_id,int id,String type)
	{
		this.title=title;
		this.song_count=song_count;
		this.image_id=image_id;
		this.id=id;
		this.type=type;
	}
	public void print()
	{
		//System.out.println("");
		System.out.println("Title = "+title);
		System.out.println("Song Count = "+song_count);
		System.out.println("Image Id = "+image_id);
		System.out.println("Id = "+id);
	}
}
