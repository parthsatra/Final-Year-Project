import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class getImages extends Thread {
	userjp[] r;
	ArrayList a;
	JPanel j;
	String type;
	Gallery g;
	public getImages(userjp[] r, ArrayList a,JPanel j,String type,Gallery g)
	{
		this.r=r;
		this.a=a;
		this.j=j;
		this.g=g;
		if(type.equals("at"))
		{
			this.type="artists";
		}
		else
		{
			this.type="albums";
		}
		//System.out.println("hello");
	}
	public void run()
	{
		BufferedImage image=null;
		try{
			int n=0;
			while(n<a.size())
			{
				//System.out.println("new");
			String uu="http://images.mime360.com/cgi-bin/Resize?h=150&w=150&itype="+type+"&iid=";
			Albums obj=(Albums)a.get(n);
			uu=uu+obj.image_id;
			r[n].img=uu;
			//System.out.println("teri");
			if(obj.image_id!=0)
			{
			URL url = new URL(uu);
		      image= ImageIO.read(url);
		     r[n].setimage(image);
		     j.repaint();
			}
			else
			{
				System.out.println("teri");
				r[n].setimage("D:/images/user.png");
				System.out.println("teri");
				j.repaint();
			}
			n++;
			}
			g.setEnabled(true);
			Gallery.hideload();
		}	
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
}
