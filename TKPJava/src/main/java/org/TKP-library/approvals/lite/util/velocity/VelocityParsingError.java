package org.teachingextensions.approvals.lite.util.velocity;

import org.apache.velocity.util.introspection.Info;

public class VelocityParsingError extends Error
{
  private static final long serialVersionUID = -6815526646140474951L;
  private String            message;
  private transient Info    info;
  public VelocityParsingError(String message, Info info)
  {
    this.message = message;
    this.info = info;
  }
  @Override
  public String getMessage()
  {
    return message + "  " + getInfoText(info);
  }
  public static String getInfoText(Info i)
  {
    return " at [" + i.getLine() + "," + i.getColumn() + "]" + " in template " + i.getTemplateName();
  }
}
