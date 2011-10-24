import javax.swing.*;
import javax.swing.text.html.HTMLDocument.Iterator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
public class Gallery extends JPanel implements ActionListener{
	final JPanel jp2;
	final JPanel butt;
	final JPanel jlt;
	final navbutton b[];
	final select obj1;
	static JLabel loading;
	userbutton album;
	userbutton songs;
	userjp arr[];
	JScrollPane maxpane ;
	JTextField ss;
	JLabel sear;
	JScrollPane pane ;
	JLabel tab;
	static boolean flag=true;
	String type="al";
	ArrayList al;
	String path[]=new String[2];
	final JSeparator sep;
	userbutton ab;
	userbutton art;
	static void hideload()
	{
		loading.setVisible(false);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String s=event.getSource().toString();
		if(s.contains("art.png"))
		{
			type="at";
			Gallery.flag=false;
			//Thread t=new Thread(gallery);
			//t.start();
			
		}
		else if(s.contains("al.png"))
		{
			type="al";
			Gallery.flag=true;
			//Thread t=new Thread(gallery);
			//t.start();
			
		}
		else
		{
			loading.setVisible(true);
			setEnabled(false);
			navbutton but=(navbutton)event.getSource();
			//int a=text.indexOf("text=");
			String artist=but.toString();
			jp2.removeAll();
			jlt.removeAll();
				//String artist=(String)(jlt.getSelectedValue());
				//System.out.println(artist);
				al=new ArrayList();
				XMLParser xp=new XMLParser(artist,type);
				al=xp.parse();
				int no=0;
				arr=new userjp[al.size()];
				getImages thread =new getImages(arr,al,jp2,type,this);
				no=0;
				//setComponentZOrder(loading, 1);
				while(no<al.size())
				{
					String ppath;
					if(flag==true)
					{ppath=path[0];}
					else
					{ppath=path[1];}
					String aa;
					Albums alb=(Albums)al.get(no);
					aa=alb.title;
					int id=alb.id;
					arr[no]=new userjp(aa,id,ppath);
					//if(flag==true)
					//{
						jp2.add(arr[no]);
					//}
					//else
					//{
						//jlt.add(arr[no]);
					//}
					
					MouseListener mouseListener = new MouseAdapter() {
					    public void mouseClicked(MouseEvent e) {
					        if (e.getClickCount() == 2) {
					        	ss.setVisible(false);
								sear.setVisible(false);
								tab.setVisible(false);
								ab.setVisible(false);
								art.setVisible(false);
								maxpane.setVisible(false);
								album.setVisible(false);
								songs.setVisible(false);
					        	obj1.setVisible(true);
					        	butt.setVisible(false);
					        	sep.setVisible(false);
					        	userjp uj=(userjp)e.getSource();
					        	String clas=uj.toString();
					        	String arr[];
					        	arr=clas.split("/");
					        	System.out.println(arr[0]+arr[1]);
					        	//removeAll();
					        	obj1.set(arr[0], Integer.parseInt(arr[1]),uj.img);
					        	obj1.setselect();
					        	repaint();
					        	
					         }
					    }
					};
					jlt.addMouseListener(mouseListener);	
					
						arr[no].addMouseListener(mouseListener);
						no++;
				}
				thread.start();
				jp2.repaint();

		}
	
	}
	public Gallery()
	{
		path[0]="D:/images/div.png";
		path[1]="D:/images/div.png";
		//path[1]="D:/images/artistpanel.png";
		ab=new userbutton(new ImageIcon("D:/images/al.png"));
		art=new userbutton(new ImageIcon("D:/images/art.png"));
		ab.addActionListener(this);
		art.addActionListener(this);
		ab.setBounds(300,0,100,40);
		art.setBounds(450,0,100,40);
		setLayout(null);
		String s[]=new String[26];
		int j=97;
		int x=0;
		add(ab);
		add(art);
		b=new navbutton[26];
		loading=new JLabel(new ImageIcon("D:/images/pro.gif"));
		loading.setBounds(700,300,32,32);
		add(loading);
		loading.setVisible(false);
		int count=0;
		int xdi=0;
		butt=new JPanel();
		butt.setLayout(null);
		for(int i=0;i<26;i++)
		{
			s[i]=""+(char)j;
			j++;
			b[i]=new navbutton(s[i]);
			b[i].setBounds(xdi,x,45,30);
			butt.add(b[i]);
			x=x+35;
			//b[i].setContentAreaFilled(false);
			b[i].addActionListener(this);
			count++;
			if(count==13)
			{
				x=0;
				xdi=55;
			}
			
			//b.setFont(new Font( "Roman", Font.BOLD,8 ));
		}
		sep=new JSeparator(SwingConstants.VERTICAL);
		//sep.setBackground(Color.black);
		sep.setBounds(104,45,10,480);
		add(sep);
		butt.setBounds(55,50,100,470);
		butt.setOpaque(false);
		add(butt);
		
		album=new userbutton(new ImageIcon("D:/images/albums.png"));
		songs=new userbutton(new ImageIcon("D:/images/songs.png"));
		//JPanel obj=new JPanel();
		jp2=new JPanel();
		 maxpane = new JScrollPane(jp2, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
		        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		 maxpane.getVerticalScrollBar().setUnitIncrement(18);
		sear=new JLabel(new ImageIcon("D:/images/se.png"));
		tab=new JLabel(new ImageIcon("D:/images/tab.png"));
		sear.setBounds(0,50,300,50);
		tab.setBounds(250,50,470,50);
		album.setBounds(265,57,125,35);
		songs.setBounds(410,57,125,35);
		add(album);
		add(songs);
		jlt=new JPanel();
		
		jlt.setLayout(new GridLayout(0,1));		
		jp2.setLayout(new GridLayout(0,1));
		
		maxpane.setBounds(250,100,470,400);
		maxpane.setBorder(null);
		maxpane.setOpaque(false);
		jp2.setOpaque(false);
		//obj.add(jp2);
		ss=new JTextField();
		ss.setBounds(80,62,200,25);
		add(ss);
		add(tab);
		add(sear);
		ss.setVisible(false);
		//tab.setVisible(false);
		sear.setVisible(false);
		//add(pane);
		add(maxpane);
		setOpaque(false);
		setVisible(false);
		obj1=new select();
		obj1.setBounds(0,50,800,450);
		obj1.setOpaque(false);
		add(obj1);
		obj1.setVisible(false);
			
		//jp2.addMouseListener(mouseListener);
	}
	public void hidee()
	{
		//if(obj1!=null)
		System.out.println("wassa");
		//remove(obj1);
			obj1.setVisible(false);
			if(flag==false)
			{
				//ss.setVisible(true);
				//sear.setVisible(true);
				//pane.setVisible(true);
			}
			tab.setVisible(true);
			maxpane.setVisible(true);
			album.setVisible(true);
			songs.setVisible(true);
			butt.setVisible(true);
			sep.setVisible(true);
			ab.setVisible(true);
			art.setVisible(true);
			/*
			repaint();*/
	}

}/*
JLabel loading=new JLabel(new ImageIcon("D:/images/progress.gif"));
loading.setBounds(200,200,180,180);
add(loading);*/