import javax.swing.JOptionPane;

import src.main.java.org.teachingextentions.logo.Tortoise;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.NumberUtils;
import src.main.java.org.teachingextentions.logo.utils.EventUtils.MessageBox;

public class HelloTKPTortoise 
{
    public static void main( String[] args )
    {
       // TEST 1 - does this file work - YES
       System.out.println( "Hello TKP Tortoise World!" );
    
       // TEST 2 - does `teachingextentions` work - YES
       Integer i = NumberUtils.getRandomInt(1, 100);
       System.out.println("number "+ (i));

       // TEST 3 - does `playSound` work - NO
       // URL to /soundFiles folder is mangled, copied `BrainIsGone.wav` to same dir for testing
       // Sound s = new Sound(TKPSound.BrainIsGone);
       //s.playSound();
       
       // TEST 4  - does `JOptionPane` ( becomes `MessageBox`) work - YES
       String message = "JOption";
       JOptionPane.showMessageDialog(null, message);

       // TKPJava `wrapper` for JOptionPane is MessageBox
       //MessageBox.showMessage("this is the message");
      
       // TEST 5 - does Tortoise window work - NO - can't render GUI
       //Tortoise.turn(90);
    }
}
