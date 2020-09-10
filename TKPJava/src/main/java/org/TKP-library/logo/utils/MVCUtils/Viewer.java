package logo.utils.MVCUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.teachingextensions.approvals.lite.util.ObjectUtils;
import org.teachingextensions.approvals.lite.util.TestUtils;

/**
 * <img src="http://www.odessa-webdevelopment.nl/Images/view_icon.png" style="text-align: left" alt="a view">
 * Displays a view via a template, populated with a data object 
 */
public class Viewer
{
  /**
   * Uses a RTF Viewer to display the results of a model (or text)
   * <div><b>Example:</b> {@code  viewer.displayRtfFile(text)} </div>
   * 
   * @param text
   *            A model created from a String (text) 
   */
  public static void displayRtfFile(String text)
  {
    try
    {
      File file;
      file = File.createTempFile("currentStory", ".rtf");
      FileWriter f = new FileWriter(file);
      f.write(text);
      f.close();
      TestUtils.displayFile(file.getPath());
    }
    catch (IOException e)
    {
      throw ObjectUtils.throwAsError(e);
    }
  }
}
