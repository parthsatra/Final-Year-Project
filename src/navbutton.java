import java.awt.*;

import javax.swing.*;
public class navbutton extends JButton {
	Image i;
	String s;
	public navbutton(String s)
	{
		super();
		this.s=s;
		//setBorderPainted(false);
		setContentAreaFilled(false);
		//setBorder(null);
		try
		{
		i = (new ImageIcon("D:/images/nav.png")).getImage();
		}
		catch(Exception e){System.out.println("dada");}
		JLabel g=new JLabel(s);
		g.setForeground(Color.white);
		g.setFont(new Font("papyrus",Font.PLAIN,14));
		add(g);
	}
	public void paintComponent(Graphics g)
	{
	super.paintComponent(g);
	
	if(i != null) 
		{
		g.drawImage(i,0,0 ,this); //(image,location x, location y, size x, size y)
		}
	
	}
	public String toString()
	{
		return s;
	}
}
