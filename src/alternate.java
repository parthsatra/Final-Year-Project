import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class alternate extends JLabel implements ListCellRenderer {
	/*private Image image;
	public alternate()
	{
	setOpaque(true);
	try
	{
		
	image = (new ImageIcon("D:/images/div1.png")).getImage();
	}
	catch(Exception e){System.out.println("dada");}
	}
	public void paintComponent(Graphics g)
	{
	super.paintComponent(g);
	
	if(image != null) 
		{
		g.drawImage(image,0,0 ,this); //(image,location x, location y, size x, size y)
		}

	}*/
	

	public Component getListCellRendererComponent(
	JList list, Object value, int index,
	boolean isSelected, boolean cellHasFocus )
	{
		setText(value.toString());
		setForeground(Color.white);
		setFont( new Font( "Roman", Font.PLAIN,14 ) );
	/*if(isSelected)
	{
		setBackground(Color.black);
	}
	
	else if( index%2==0 )
	{
	// Set the color and font for a selected item
	setBackground( Color.gray );
	//setForeground( Color.white );
	//setFont( new Font( "Roman", Font.BOLD,14 ) );
	}
	else
	{
	// Set the color and font for an unselected item
	setBackground( Color.darkGray);
	//setForeground( Color.black );
	//setFont( new Font( "Roman", Font.PLAIN, 12 ) );
	}*/

	return this;
	}
}
