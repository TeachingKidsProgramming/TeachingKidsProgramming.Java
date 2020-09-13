import javax.swing.JOptionPane;

import src.main.java.org.teachingextentions.logo.Tortoise;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.NumberUtils;
import src.main.java.org.teachingextentions.logo.utils.EventUtils.MessageBox;

public class HelloTKPTortoise 
{
    public static void main( String[] args )
    {
       // First test - does this file work - YES
       System.out.println( "Hello TKP Tortoise World!" );
    
       // Second test - does `teachingextentions` work - YES
       Integer i = NumberUtils.getRandomInt(1, 100);
       System.out.println("number "+ (i));

       // Third test - does `JOptionPane` ( becomes `MessageBox`) work - NO
       // need diff JAVA version in DOCKERFILE, using 'headless' - can't render GUI
       String message = "JOption";
       JOptionPane.showMessageDialog(null, message);
       // MessageBox.showMessage("message");
      
       // Fourth Test - does Tortoise window work - NO - can't render GUI
       // Tortoise.show();
    }
}
