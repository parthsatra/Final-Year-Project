import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.*;
import javax.imageio.ImageIO;


public class getimage{
		
	public static void main(String[] args) {
		try{
			 URL url = new URL("http://images.mime360.com/cgi-bin/Resize?h=150&w=150&itype=albums&iid=301221");
		        BufferedImage image = ImageIO.read(url);
		        JFrame jf=new JFrame();
		        JLabel jl=new JLabel(new ImageIcon(image));
		        jf.add(jl);
		        jf.setVisible(true);
		}
		catch(Exception e)
		{
			
		}


	}

}
