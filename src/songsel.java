import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class songsel extends BackgroundPanel implements ActionListener {
	JButton info;
	int length;
	String s;
	Albums artist[];
	select ob;
	String path="D:/images/songsel.png";
	public songsel(String s,Albums artist[],int length,select ob)
	{
		super("D:/images/songsel.png");
		this.ob=ob;
		this.length=length;
		this.s=s;
		this.artist=artist;
		setLayout(null);
		setOpaque(false);
		setPreferredSize(new Dimension(450,60));
		JButton cart=new JButton("Add",new ImageIcon("D:/images/shopc.png"));
		cart.setContentAreaFilled(false);
		cart.setBorder(null);
		JLabel name=new JLabel(s);
		JButton play=new JButton(new ImageIcon("D:/images/playy.png"));
		play.setContentAreaFilled(false);
		play.setBorder(null);
		info=new JButton(new ImageIcon("D:/images/imfo.png"));
		info.setContentAreaFilled(false);
		info.setBorder(null);
		info.addActionListener(this);
		songsel obj=(songsel)info.getParent();
		name.setBounds(15,10,170,40);
		cart.setBounds(200,9,32,32);
		play.setBounds(260,9,32,32);
		info.setBounds(320,9,32,32);
		add(name);
		add(cart);
		add(play);
		add(info);
	}
	public void actionPerformed(ActionEvent event)
	{
		ob.ch();
		path="D:/images/changepanel.png";
		JButton t=(JButton)event.getSource();
		songsel obj=(songsel)t.getParent();
		select g=obj.ob;
		g.info(obj);
		this.image=(new ImageIcon(path)).getImage();
		this.repaint();
		
	}
	public String toString()
	{
		return path;
	}
}
