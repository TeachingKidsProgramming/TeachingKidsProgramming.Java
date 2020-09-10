package org.teachingextensions.logo.utils.MVCUtils;

import java.lang.reflect.Field;
import java.util.List;

import org.teachingextensions.approvals.lite.util.ObjectUtils;
import org.teachingextensions.approvals.lite.util.io.FileUtils;
import org.teachingextensions.approvals.lite.util.lambda.Function1;
import org.teachingextensions.approvals.lite.util.lambda.Query;

/**
 * <img src="http://www.orbis-software.com/sage/gfx/Text%20Parser%20Icon.gif" style="text-align: left" alt="A parser">
 * Parses a data object for display, using a template  
 */
public class Parser
{
  /**
   * Parses a template with a data object to create a string
   * 
   * <div><b>Example:</b><pre>{@code
   * Words data = new Words();
   * data.action = "Shake";
   * data.weapon = "speare";
   * String greeting = Parser.parse("Captain {action}{weapon}!!!", data);
   * }</pre></div>
   *
   * Captain Shakespeare!!! 
   * 
   * @param text
   *          The template with the fields from the data object surrounded in {curlyBraces}
   * @param data
   *          an object whose fields will be merged with the template during parsing
   * @return the completed string
   */
  public static String parse(String text, Object data)
  {
    return parse(text, "{", "}", data);
  }
  public static String parse(String text, String startCharacter, String endCharacter, Object data)
  {
    StringBuilder sb = new StringBuilder();
    String temp = text;
    int start = temp.indexOf(startCharacter);
    while (start > 0)
    {
      int end = temp.indexOf(endCharacter, start);
      sb.append(temp.substring(0, start));
      String key = temp.substring(start + startCharacter.length(), end);
      sb.append(getValue(key, data));
      temp = temp.substring(end + endCharacter.length());
      start = temp.indexOf(startCharacter);
    }
    sb.append(temp);
    return sb.toString();
  }
  private static String getValue(final String piece, Object data)
  {
    try
    {
      Field[] declaredFields = data.getClass().getDeclaredFields();
      List<Field> f = Query.where(declaredFields, new Function1<Field, Boolean>()
      {
        @Override
        public Boolean call(Field i)
        {
          return i.getName().equals(piece);
        }
      });
      f.get(0).setAccessible(true);
      return "" + f.get(0).get(data);
    }
    catch (Exception e)
    {
      return piece;
    }
  }
  /**
   * Parses a file
   * <div><b>Example:</b> {@code parser.parseRtfFile(filename,data)} </div>
   *
   * @param fileName A filename for the new file, built from the template view.rtf
   * @param data A data object to put into the template fields.
   * @return the completed template
   */
  public static String parseRtfFile(String fileName, Object data)
  {
    try
    {
      String text = FileUtils.readFromClassPath(data.getClass(), fileName);
      return parse(text, "\\{", "\\}", data);
    }
    catch (Exception e)
    {
      throw ObjectUtils.throwAsError(e);
    }
  }
}
