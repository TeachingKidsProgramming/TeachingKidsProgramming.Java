package org.teachingextensions.setup;

import java.io.File;
import java.io.IOException;

import org.teachingextensions.approvals.lite.util.ObjectUtils;
import org.teachingextensions.approvals.lite.util.SystemUtils;
import org.teachingextensions.approvals.lite.util.io.FileUtils;
import org.teachingextensions.approvals.lite.util.io.ZipUtils;
import org.teachingextensions.logo.utils.EventUtils.MessageBox;

public class SetupValidator
{
  public enum SetupCheckPoints {
    MetadataUnzipped, EclipseIsInstalled, WorkspaceFound
  }
  public static void main(String[] args)
  {
    try
    {
      SetupConfig config = new SetupConfig();
      validateEclipse(config);
      validateWorkspace(config);
      launchEclipse(config);
      config.assertSetupIsCorrect();
    }
    catch (Throwable t)
    {
      MessageBox.showMessage("Something went wrong: \r\n" + t.getMessage());
    }
  }
  private static void launchEclipse(SetupConfig config)
  {
    if (!config.setup.isOk()) { return; }
    String cmd = SystemUtils.isWindowsEnvironment() ? "%s -data \"%s\"" : "%s -data %s";
    CommandLineUtils.launch(cmd, config.getEclipsePath(), config.workspacePath);
  }
  private static void validateWorkspace(SetupConfig config)
  {
    isCodeUnpacked(config);
    isWorkSpaceConfigured(config);
  }
  private static void isWorkSpaceConfigured(SetupConfig config)
  {
    String metadataPath = config.workspacePath + File.separator + ".metadata";
    unpackWorkspaceIfNeeded(config, metadataPath);
    boolean metadata = new File(metadataPath).exists();
    if (metadata)
    {
      String configPath = metadataPath + File.separator
          + ".plugins/org.eclipse.core.runtime/.settings/org.eclipse.ui.editors.prefs";
      String configText = FileUtils.readFileWithSuppressedExceptions(new File(configPath));
      metadata = configText.contains("lineNumberRuler=true");
      config.setup.set(SetupCheckPoints.MetadataUnzipped, metadata,
          "The metadata was not unzipped correctly, you need to delete: " + metadataPath);
    }
  }
  private static void unpackWorkspaceIfNeeded(SetupConfig config, String metadataPath)
  {
    try
    {
      boolean metadata = new File(metadataPath).exists();
      if (!metadata)
      {
        ZipUtils.doUnzip(new File(config.workspacePath), new File(config.workspacePath + File.separator
            + "eclipse_workspace.zip"));
      }
    }
    catch (IOException e)
    {
      ObjectUtils.throwAsError(e);
    }
  }
  private static void isCodeUnpacked(SetupConfig config)
  {
    try
    {
      config.workspacePath = new File(".").getCanonicalPath();
      String relativePath = "TeachingKidsProgramming/src/org/teachingkidsprogramming/section01forloops/SimpleSquare.java"
          .replace('/', File.separatorChar);
      File simpleSquare = new File(config.workspacePath + File.separator + relativePath);
      config.setup.set(SetupCheckPoints.WorkspaceFound, simpleSquare.exists(),
          "could not find the TKP workspace at " + config.workspacePath + "\r\n The Following File should exist:"
              + simpleSquare.getAbsolutePath());
    }
    catch (IOException e)
    {
      ObjectUtils.throwAsError(e);
    }
  }
  private static void validateEclipse(SetupConfig config)
  {
    boolean exists = new File(config.getEclipsePath()).exists();
    String base = config.getEclipsePath().substring(0, config.getEclipsePath().indexOf(File.separator, 3));
    config.setup.set(SetupCheckPoints.EclipseIsInstalled, exists, "could not find Eclipse at: " + base);
  }
}
