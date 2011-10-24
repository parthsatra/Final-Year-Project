import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class userjp extends BackgroundPanel {
	String songname;
	int id;
	String img;
	public userjp(String s,int n,String path) {
		super(path);
			setOpaque(false);
			setPreferredSize(new Dimension(450,150));
			setLayout(null);
			songname=s;
			id=n;
			JLabel albumname=new JLabel(s);
			JLabel des=new JLabel(new ImageIcon("D:/images/des.png"));
			des.setBounds(170,20,200,100);
			albumname.setBounds(180,25,150,50);
			add(albumname);
			add(des);	
	}
	public void setimage(Image i)
	{
		JLabel jch=new JLabel(new ImageIcon(i));
		jch.setBounds(15, 10, 125, 125);
		add(jch);
		JLabel sha=new JLabel(new ImageIcon("D:/images/shadow.png"));
		sha.setBounds(25, 25, 125, 125);
		add(sha);
	}
	public void setimage(String a)
	{
		JLabel jch=new JLabel(new ImageIcon(a));
		JLabel sha=new JLabel(new ImageIcon("D:/images/shadow.png"));
		jch.setBounds(15, 10, 125, 125);
		sha.setBounds(25, 25, 125, 125);
		add(jch);
		add(sha);
	}
	public String toString()
	{
		String s="";
		s=s+songname;
		s=s+"/"+id;
		return s;
	}

}
