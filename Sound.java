import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import javax.swing.JOptionPane;

public class Sound {

  public void playSound() {

  	try {

  		File musicPath = new File("nbaespn.wav");

  		if (musicPath.exists()) {
	    	AudioInputStream audioIn = AudioSystem.getAudioInputStream(musicPath);
	    	Clip clip = AudioSystem.getClip();

	    	clip.open(audioIn);
	    	clip.start();
        JOptionPane.showMessageDialog(null, "Timer Finished");
        clip.stop();
	    	
  		} else {
  			System.out.println("File not found");
  		}

    } catch(Exception ex) {
    	System.out.println("error");
    }

  }

}