import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class userjp1 extends JPanel{

	
public userjp1(String s){
	super();
	setLayout(new FlowLayout(FlowLayout.LEFT,10,5));
	JCheckBox cb=new JCheckBox();
	JLabel lab=new JLabel(s);
	add(cb);
	add(lab);
	
}
}
