package org.teachingextensions.setup;

import java.io.File;

import org.teachingextensions.approvals.lite.util.SystemUtils;
import org.teachingextensions.approvals.lite.util.servlets.ValidationError;
import org.teachingextensions.setup.SetupValidator.SetupCheckPoints;

public class SetupConfig
{
  public ValidationError      setup              = new ValidationError(SetupCheckPoints.values());
  public String               workspacePath      = SystemUtils.isWindowsEnvironment() ? "." : System
                                                     .getProperty("user.dir");
  private String              eclipsePath;
  private final static String eclipsePathWindows = "c:\\eclipse\\eclipse.exe";
  private final static String eclipsePathMac     = "/Applications/eclipse/Eclipse.app/Contents/MacOS/eclipse";
  public void assertSetupIsCorrect()
  {
    if (!setup.isOk()) { throw setup; }
  }
  public String getEclipsePath()
  {
    if (this.eclipsePath == null)
    {
      if (SystemUtils.isWindowsEnvironment())
      {
        this.eclipsePath = SetupConfig.eclipsePathWindows;
      }
      else
      {
        String brewEclipsePath = getBrewEclipsePath();
        boolean exists = new File(brewEclipsePath).exists();
        if (exists)
        {
          this.eclipsePath = brewEclipsePath;
        }
        else
        {
          this.eclipsePath = SetupConfig.eclipsePathMac;
        }
      }
    }
    return this.eclipsePath;
  }
  public String getBrewEclipsePath()
  {
    String brewEclipsePath = System.getProperty("user.home") + SetupConfig.eclipsePathMac;
    brewEclipsePath = brewEclipsePath.replace("Applications/eclipse/", "Applications/");
    return brewEclipsePath;
  }
}
