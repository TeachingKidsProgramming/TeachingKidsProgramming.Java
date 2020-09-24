package src.main.java.org.teachingextentions.logo.utils.VirtualProctorUtils;

import java.io.File;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.StringUtils;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.io.FileUtils;

/**
 * <img src="http://indiajkd.com/wp-content/uploads/2013/08/JKD-India-6.gif"
 * style="text-align: left" alt="A teacher at a blackboard" height="30" width="30"> Virtual
 * Proctor allows you to see what all the TKPJava coders are making
 */
public class VirtualProctor
{
  public static class internals
  {
    private static final String FILE_NAME       = ".virtual_proctor.txt";
    private static final String FILE_CLASS_NAME = ".class.virtual_proctor.txt";
    public static String getName()
    {
      String name = getCustomName();
      if (name == null)
      {
        name = getComputerName();
      }
      if (name == null)
      {
        name = getUserName();
      }
      return name;
    }
    private static String getCustomName()
    {
      File file = new File(FILE_NAME);
      if (file.exists()) { return FileUtils
            .readFileWithSuppressedExceptions(file).trim();
      }
      return null;
    }
    public static String getComputerName()
    {
      return System.getenv("COMPUTERNAME");
    }
    public static String getUserName()
    {
      return System.getenv("USER");
    }
    public static void resetName()
    {
      File file = new File(FILE_NAME);
      if (file.exists())
      {
        file.delete();
      }
    }
    public static void setName(String name)
    {
      if (StringUtils.isEmpty(name)) {
        return;
      }
      FileUtils.writeFileQuietly(new File(FILE_NAME), name);
    }
    public static void setClassName(String className)
    {
      if (StringUtils.isEmpty(className)) { return; }
      FileUtils.writeFileQuietly(new File(FILE_CLASS_NAME), className);
    }
    public static void resetClassName()
    {
      File file = new File(FILE_CLASS_NAME);
      if (file.exists())
      {
        file.delete();
      }
    }
    public static String getClassName()
    {
      String name = getCustomClassName();
      if (name == null)
      {
        name = "world";
      }
      return name;
    }
    private static String getCustomClassName()
    {
      File file = new File(FILE_CLASS_NAME);
      if (file.exists()) { return FileUtils.readFileWithSuppressedExceptions(file).trim(); }
      return null;
    }
    public static String getFullName()
    {
      return getClassName() + "." + getName();
    }
  }
  /**
   * Allows you to set the displayed username in Virtual Proctor
   * <div><b>Example:</b> {@code  VirtualProctor.setName("Grace Hopper")} </div>
   * 
   * @param name
   *            A name that is displayed for the user in the Virtual
   *            Proctor client
   */
  public static void setName(String name)
  {
    internals.setName(name);
  }
  /**
   * Allows you to set the displayed classroom name in Virtual Proctor
   * <div><b>Example:</b> {@code  VirtualProctor.setClassName("LePort School")} </div>
   * 
   * @param className
   *            A name that is displayed for the student classroom in the Virtual
   *            Proctor client
   */
  public static void setClassName(String className)
  {
    internals.setClassName(className);
  }
}
