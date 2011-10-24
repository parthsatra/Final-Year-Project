import java.awt.*;
import javax.swing.*;

public class BackgroundPanel extends JPanel {
	Image image;
	public BackgroundPanel(String s)
	{
	try
	{
	image = (new ImageIcon(s)).getImage();
	}
	catch(Exception e){System.out.println("dada");/*handled in paintComponent()*/}
	}
	public void paintComponent(Graphics g)
	{
	super.paintComponent(g);
	
	if(image != null) 
		{
		g.drawImage(image,0,0 ,this); //(image,location x, location y, size x, size y)
		}
	
	}
}
