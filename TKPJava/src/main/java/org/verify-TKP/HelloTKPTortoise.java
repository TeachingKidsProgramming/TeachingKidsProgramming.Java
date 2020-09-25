import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.NumberUtils;

public class HelloTKPTortoise 
{
    public static void main( String[] args )
    {
       // TEST 1 - does this file work
       System.out.println( "Hello TKP Tortoise World!" );
    
       // TEST 2 - does `teachingextentions` work
       Integer i = NumberUtils.getRandomInt(2, 102);
       System.out.println("number "+ (i));
 
       // TEST 3  - does `JOptionPane` ( becomes `MessageBox`) work
       // String message = "JOption";
       // JOptionPane.showMessageDialog(null, message);

       // TKPJava `wrapper` for JOptionPane is MessageBox
       // MessageBox.showMessage("this is the message");
      
       // TEST 4 - does Tortoise window work 
       // Tortoise.show();
       // Tortoise.move(50);
       // Tortoise.turn(90);
    }
}
