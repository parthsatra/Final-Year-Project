import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

class vi implements Runnable
{
	boolean check=true;
	boolean pause=false;
	Thread t;
	vi()
	{
		t=new Thread(this,"vipul");
		t.start();
	}
	public void run()
	{
		try{
			yo();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void yo()throws IOException,LineUnavailableException,UnsupportedAudioFileException
	{
		File file = new File("F:\\Music\\Hindi\\azamale.mp3");
		AudioInputStream in= AudioSystem.getAudioInputStream(file);
		AudioInputStream din = null;
		AudioFileFormat baseFileFormat = AudioSystem.getAudioFileFormat(file);
		Map properties = baseFileFormat.properties();
		String key_author = "author";
		String author = (String) properties.get(key_author);
		String key_duration = "duration";
		Long duration = (Long) properties.get(key_duration);
		duration=duration/(1000000*60);
		//System.out.print("Author : "+author+"\n");
		//System.out.print("Duration : "+duration+"\n");
		AudioFormat baseFormat = in.getFormat();
		AudioFormat decodedFormat =
		    new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
		                    baseFormat.getSampleRate(),
		                    16,
		                    baseFormat.getChannels(),
		                    baseFormat.getChannels() * 2,
		                    baseFormat.getSampleRate(),
		                    false);
		din = AudioSystem.getAudioInputStream(decodedFormat, in);
		// Play now.
		rawplay(decodedFormat, din);
		in.close();
	}
	private void rawplay(AudioFormat targetFormat,AudioInputStream din)throws IOException,LineUnavailableException
	{
		byte[] data = new byte[4096];
		SourceDataLine line = getLine(targetFormat);
		if (line != null)
		{
// Start
			line.start();
			int nBytesRead = 0, nBytesWritten = 0;
			while (nBytesRead != -1 && check)
			{
				if(pause)
				{continue;}
				nBytesRead = din.read(data, 0, data.length);	
				if (nBytesRead != -1)
					nBytesWritten = line.write(data, 0, nBytesRead);
				try{
				/*Thread.sleep(5);*/}catch(Exception e){}
			}
// Stop
			line.drain();
			line.stop();
			line.close();
			din.close();
}
}

private SourceDataLine getLine(AudioFormat audioFormat)throws LineUnavailableException
	{	
		SourceDataLine res = null;
		DataLine.Info info =
			new DataLine.Info(SourceDataLine.class, audioFormat);
		res = (SourceDataLine) AudioSystem.getLine(info);
		res.open(audioFormat);
		return res;
	}

}


public class mp3 {
	public static void main(String[] args)throws IOException,LineUnavailableException,UnsupportedAudioFileException
	{
		vi obj=new vi();
		System.out.println("press 1 to pause, 2 to play, 3 to stop, 4 to exit ");
		
		Scanner cin=new Scanner(System.in);
		int n;
		Boolean flag=true;
		while(flag)
		{
			n=cin.nextInt();
			if(n==1)
			{
			try{obj.pause=true;
			}
			catch(Exception e){}
			//flag=false;
			}
			else if(n==2)
			{
				if(!obj.check)
				{
					obj=new vi();
				}
				else
					{obj.pause=false;}
			}
			else if(n==3)
			{
				obj.check=false;
			}
			else if(n==4)
			{
				obj.check=false;
				flag=false;
			}
		}
		System.out.println("song terminated");
	}
	
}
