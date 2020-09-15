import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.NumberUtils;

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
       //Sound s = new Sound(TKPSound.BrainIsGone);
       //s.playSound();
       
       // TEST 4  - does `JOptionPane` ( becomes `MessageBox`) work - NO
       // need diff JAVA version in DOCKERFILE, using 'headless' - can't render GUI
       // see - https://stackoverflow.com/questions/5218870/getting-a-headlessexception-no-x11-display-variable-was-set
       // must configure from Docker also - see http://fabiorehm.com/blog/2014/09/11/running-gui-apps-with-docker/

        // String message = "JOption";
       // JOptionPane.showMessageDialog(null, message);

       // TKPJava `wrapper` for JOptionPane is MessageBox
       // MessageBox.showMessage("message");
      
       // TEST 5 - does Tortoise window work - NO - can't render GUI
       // Tortoise.show();
    }
}
