import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class TestFrame extends JFrame implements ActionListener
{
	final JPanel content;
	JFileChooser jfc;
	userbutton b1;
	userbutton b2;
	userbutton b3;
	userbutton b4;
	int j=0;
	JPanel first1;
	Gallery gallery;
	select obj1;
	userbutton next;
	userbutton pre;
	userbutton goback;
	ImageIcon earth;
	JLabel backlabel;
	String pa[];
	public void actionPerformed(ActionEvent event)
	{	String s=event.getSource().toString();
		System.out.println(s);
		if((event.getActionCommand()).equals("setpath"))
		{
			int a=jfc.showDialog(content, "Set Path");
			if(a==JFileChooser.APPROVE_OPTION)
			{
				String src = "C:\\Users\\vipul\\Downloads";
				String song = "rockstar04.mp3";
				String target = jfc.getSelectedFile().getPath();
				Transfer tf= new Transfer(src,target,song);
				tf.copy();
				System.out.println(target);
			}
			else
			{System.out.println("wassas");}
		}
		else if(s.contains("b2.png"))
		{
			gallery.setVisible(true);
			first1.setVisible(false);
			b2.setSelected(true);
			b1.setSelected(false);
		}
		else if(s.contains("goback.png"))
		{
			System.out.println("wassa");
			gallery.hidee();
		}
		else if(s.contains("b1.png"))
		{
			b1.setSelected(true);
			b2.setSelected(false);
			gallery.setVisible(false);
			first1.setVisible(true);
			pre.setVisible(false);
			next.setVisible(false);
		}
		
		else if(s.contains("az1.png"))
		{
			gallery.flag=true;
			//Thread t=new Thread(gallery);
			//t.start();
		}
		else if(s.contains("az2.png"))
		{
			gallery.flag=true;
			//Thread t=new Thread(gallery);
			//t.start();
		}
	}
	public TestFrame()
	{			
		super("JLayeredPane Demo");
		pa=new String[5];
		pa[0]="D:/images/dell22.jpg";
		pa[1]="D:/images/music2.jpg";
		pa[2]="D:/images/music3.jpg";
		pa[3]="D:/images/music4.jpg";
		pa[4]="D:/images/music5.jpg";
		goback=new userbutton(new ImageIcon("D:/images/goback.png"));
		goback.setBounds(900,30,125,40);
		goback.addActionListener(this);
		next=new userbutton(new ImageIcon("D:/images/az2.png"));  
		pre=new userbutton(new ImageIcon("D:/images/az1.png"));
		pre.setBounds(70,110,40,40);
		next.setBounds(920,110,40,40);
		pre.addActionListener(this);
		next.addActionListener(this);
		pre.setVisible(false);
		next.setVisible(false);
		
		gallery=new Gallery();
		gallery.setLayout(null);
		//gallery.setVisible(false);
		content = new JPanel();
		content.setLayout(null);
		content.setOpaque(false);
		getContentPane().add(content);
		((JPanel) getContentPane()).setOpaque(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    setBounds(0,0,screenSize.width, screenSize.height);  
		System.out.println("again");
	    earth = new ImageIcon(pa[j]);
		backlabel = new JLabel(earth);
		getLayeredPane().add(backlabel, new Integer(Integer.MIN_VALUE));		
		
		//content.add(n);		
		backlabel.setBounds(0, 0, getWidth(), getHeight());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//mediaplayer player=new mediaplayer();
		//player.setBounds(480,5,300,40);
		
		//content.add(player);
		content.add(pre);
		content.add(next);
		content.add(goback);
		//player.setOpaque(false);
		b1=new userbutton(new ImageIcon("D:/images/b1.png"),new ImageIcon("D:/images/b11.png"));
		b2=new userbutton(new ImageIcon("D:/images/b2.png"),new ImageIcon("D:/images/b22.png"));
		b3=new userbutton(new ImageIcon("D:/images/b3.png"),new ImageIcon("D:/images/b33.png"));
		b4=new userbutton(new ImageIcon("D:/images/b4.png"),new ImageIcon("D:/images/b44.png"));
		b1.setSelected(true);
		b1.setBounds(10, 30, 125, 40);		
		b2.setBounds(150, 30, 125, 40);
		b3.setBounds(300, 30, 125, 40);
		b4.setBounds(450, 30, 125, 40);
		gallery.setBounds(110,90,800,500);
		content.add(b1);
		content.add(b2);
		content.add(b3);
		content.add(b4);
		content.add(gallery);
		b1.addActionListener(this);
		b2.addActionListener(this);
		first1=new BackgroundPanel("D:/images/start.png");
		first1.setBounds(110, 150, 810, 410);
		first1.setOpaque(false);
		//first1.setVisible(false);
		content.add(first1);
		obj1=new select();
		obj1.setBounds(180,200,800,400);
		obj1.setOpaque(false);
		obj1.setVisible(false);
		content.add(obj1);
		JButton exit=new JButton(new ImageIcon("D:/images/exit.png"));
		exit.setContentAreaFilled(false);
		exit.setBorder(null);
		JButton cartgo=new JButton(new ImageIcon("D:/images/cart1.png"));
		cartgo.setContentAreaFilled(false);
		cartgo.setBorder(null);
		exit.setBounds(100,625,64,64);
		cartgo.setBounds(220,625,64,64);
		content.add(exit);
		content.add(cartgo);
		setVisible(true);
		JLabel change=new JLabel("Change Background");
		change.setBounds(900,625,170,50);
		content.add(change);
		MouseListener mouseListener = new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	if (e.getClickCount() == 1)
		    	{
		    		System.out.println("sas");
		    		change();
		    	}
		    }
		    
		};
		change.addMouseListener(mouseListener);
		JButton chndir=new JButton("Set Path");
		chndir.addActionListener(this);
		chndir.setActionCommand("setpath");
		chndir.setBounds(800,200,100,100);
		content.add(chndir);
		chndir.setVisible(false);
		jfc=new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		    
		
	}
	public void change()
	{
		j=(j+1)%5;
		getLayeredPane().remove(backlabel);
		earth = new ImageIcon(pa[j]);
		backlabel = new JLabel(earth);
		getLayeredPane().add(backlabel, new Integer(Integer.MIN_VALUE));
		backlabel.setBounds(0, 0, getWidth(), getHeight());
		System.out.println(getWidth()+" "+ getHeight());
		repaint();
	}
	
	
}
