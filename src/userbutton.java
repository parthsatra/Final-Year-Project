import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class userbutton extends JButton {
	public userbutton(ImageIcon a,ImageIcon b)
	{
		super();
		setIcon(a);
		setPressedIcon(b);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setBorder(null);
		setRolloverIcon(b);
		setSelectedIcon(b);
	}
	public userbutton(ImageIcon a)
	{
		super();
		setIcon(a);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setBorder(null);
		
	}
}
