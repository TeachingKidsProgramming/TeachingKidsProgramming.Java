import src.main.java.org.teachingextentions.logo.Tortoise;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.NumberUtils;

public class HelloTKPTortoise 
{
    public static void main( String[] args )
    {
       // TEST 1 - just print something
       System.out.println( "Hello TKP Tortoise World!" );
    
       // TEST 2 - use a class.method from  `teachingextentions` library
       Integer i = NumberUtils.getRandomInt(2, 102);
       System.out.println("number "+ (i));
 
       // TEST 3  - use a Java primitive `JOptionPane` ( becomes `MessageBox`) 
       // String message = "TKP JOption";
       // JOptionPane.showMessageDialog(null, message);

       // TKPJava `wrapper` for JOptionPane is MessageBox
       // MessageBox.showMessage("TKP message");
      
       // TEST 4 - use TKPJava Tortoise window  
       Tortoise.show();
       Tortoise.setSpeed(5);
       for (int j = 0; j < 4; j++) {
        Tortoise.move(50);
        Tortoise.turn(90);
        Tortoise.move(50);
       }
       
    
    }
}
