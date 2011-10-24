import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
public class select extends BackgroundPanel {
	JLabel length;
	JLabel artist;
	String album;
	int id;
	String ik;
	songsel obj1[];
	Image i;
	//boolean fl=true;
	public select()
	{
		super("D:/images/list1.png");
	}
	public void setselect()
	{
		
		setLayout(null);
		setPreferredSize(new Dimension(300,400));
		
		removeAll();
		try{
			 System.out.println(ik);
			 //if(ik.contains("iid=0"))
			 //{
				// fl=false;
			 //}
			 //else
			 //{
				 URL url = new URL(ik);
			      i= ImageIO.read(url);
			 //}
		      //if(ik.contains("iid=0"))
		      //{
		    	 
		      //}
		}
		catch(Exception e){}
		Font f=new Font("papyrus",Font.PLAIN,12);
		JLabel pic;
		/*if(fl=true)
		{
			pic=new JLabel(new ImageIcon("D:/images/user.png"));
		}*/
		//else
		//{
			pic=new JLabel(new ImageIcon(i));
		//}
		pic.setBounds(30, 30, 200, 200);
		pic.setBackground(new Color(0,0,0,100));
		add(pic);
		//JLabel sha=new JLabel(new ImageIcon("D:/images/shadow.png"));
		//sha.setBounds(100, 70, 125, 125);
		//add(sha);
		length=new JLabel();
		length.setText("");
		length.setFont(f);
		length.setBounds(100,230,50,30);
		add(length);
		JLabel len=new JLabel("Length:");
		len.setFont(f);
		len.setBounds(30,230,60,30);
		add(len);
		JLabel art=new JLabel("Artists:");
		art.setFont(f);
		art.setBounds(30,270,60,30);
		add(art);
		artist=new JLabel("");
		artist.setFont(f);
		artist.setBounds(100,270,150,30);
		add(artist);
		JLabel desc=new JLabel(new ImageIcon("D:/images/desc.png"));
		desc.setBounds(13, 220,275,125);
		add(desc);
		XmlSong xs = new XmlSong(album,id);
		ArrayList sss=xs.parse();
		int n=0;
		int x=0;
		//System.out.println("Teraaa"+sss.size());
		JPanel songs=new JPanel();
		songs.setLayout(new GridLayout(0,1));
		JLabel top=new JLabel(new ImageIcon("D:/images/top.png"));
		top.setBounds(310,0,470,40);
		add(top);
		 JScrollPane max = new JScrollPane(songs, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
			        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		max.setBounds(310,40,470,400);
		max.setBorder(null);
		obj1=new songsel[sss.size()];
		while(n<sss.size())
		{
			Songs temp = (Songs)sss.get(n);
			String title=temp.title;
			obj1[n]=new songsel(title,temp.artist,temp.length,this);
		//obj1[n].setBounds(0,x,450,60);
		songs.add(obj1[n]);
		x=x+62;
		n++;
		}
		obj1[0].info.doClick();
		add(max);
	}
	public void set(String album,int id,String img)
	{
		this.album=album;
		this.id=id;
		ik=img;
	}
	public void info(songsel obj)
	{
		int h=obj.length/60;
		String s=""+h+"mins";
		length.setText(s);
		artist.setText(obj.artist[0].title);
		
		repaint();
	}
	public void ch()
	{
		for(int i=0;i<obj1.length;i++)
		{
			String f=obj1[i].path;
			if(f.contains("changepanel.png"))
			{
				obj1[i].image=new ImageIcon("D:/images/songsel.png").getImage();
				obj1[i].repaint();
			}
		}
	}
}
