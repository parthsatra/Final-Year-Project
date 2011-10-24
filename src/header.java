import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class header extends JPanel{
	public header()
	{
	super();
	JLabel name=new JLabel("Welcome MR. ANAND");
	JLabel counter=new JLabel("SONGS REMAINING : 50");
	setLayout(new GridBagLayout());
	GridBagConstraints cc=new GridBagConstraints();
	//setPreferredSize(new Dimension(100,20));
	cc.insets=new Insets(3,3,3,3);
	cc.gridx=0;
	cc.gridy=0;
	cc.gridwidth=5;
	cc.gridheight=1;
	add(name,cc);
	cc.gridx=5;
	cc.gridy=0;
	cc.gridwidth=2;
	cc.gridheight=1;
	add(counter,cc);
	}
}
	
