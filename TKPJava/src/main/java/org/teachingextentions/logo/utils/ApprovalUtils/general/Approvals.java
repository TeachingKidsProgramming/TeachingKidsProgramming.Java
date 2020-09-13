package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.util.Arrays;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ReporterFactory.FileTypes;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters.ApprovalFailureReporter;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ApprovalNamer;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.JUnitStackTraceNamer;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ArrayUtils;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ObjectUtils;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.StringUtils;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.Function1;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ApprovalTextWriter;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ComponentApprovalWriter;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ImageApprovalWriter;

/**
 * Approvals allows you to unit test complex objects <br><br>
 * 
 * -- Create a Golden Master file (approved) <br>
 * -- Verify against your result file (received) <br>
 * -- Download BeyondCompare to view the two files <br>
 */
public class Approvals
{
  /**
   * Verifies the output file (received) against a Golden Master file (approved)<br/>
   * If there is no GoldenMaster, then the test will fail
   * <div><b>Example:</b> {@code  Approvals.verify(response)}</div>
   *
   * @param response
   *          The string to be verified
   */
  public static void verify(String response) throws Exception
  {
    verify(new ApprovalTextWriter(response, "txt"), FileTypes.Text);
  }
  public static <T> void verifyAll(String header, T[] values)
  {
    Approvals.verifyAll(header, Arrays.asList(values));
  }
  public static <T> void verifyAll(String header, Iterable<T> values)
  {
    Approvals.verifyAll(header, values, new Function1<T, String>()
    {
      @Override
      public String call(T i)
      {
        return i + "";
      }
    });
  }
  public static <T> void verifyAll(String header, T[] values, Function1<T, String> f1)
  {
    verifyAll(header, Arrays.asList(values), f1);
  }
  public static <T> void verifyAll(String header, Iterable<T> array, Function1<T, String> f1)
  {
    String text = formatHeader(header) + ArrayUtils.toString(array, f1);
    verify(new ApprovalTextWriter(text, "txt"), FileTypes.Text);
  }
  private static String formatHeader(String header)
  {
    return StringUtils.isEmpty(header) ? "" : header + "\r\n\r\n\r\n";
  }
  public static void verifyHtml(String response) throws Exception
  {
    verify(new ApprovalTextWriter(response, "html"), FileTypes.Html);
  }
  /**
   * Verifies the output file (received) against a Golden Master file (approved) <br/>
   * If there is no GoldenMaster, then the test will fail
   * <div><b>Example:</b> {@code  Approvals.verify(component)}</div>
   *
   * @param component
   *          The component to be verified
   */
  public static void verify(Component component)
  {
    Approvals.verify(new ComponentApprovalWriter(component), FileTypes.Image);
  }
  public static void verify(BufferedImage bufferedImage)
  {
    verify(new ImageApprovalWriter(bufferedImage), FileTypes.Image);
  }
  public static void verify(ApprovalWriter writer, ApprovalNamer namer, ApprovalFailureReporter reporter)
  {
    verify(new FileApprover(writer, namer), reporter);
  }
  public static void verify(ApprovalWriter writer, String fileType)
  {
    verify(writer, createApprovalNamer(), ReporterFactory.get(fileType));
  }
  public static void verify(FileApprover approver, ApprovalFailureReporter reporter)
  {
    try
    {
      if (!approver.approve())
      {
        boolean passed = false;
        if (reporter instanceof ApprovalFailureReporter)
        {
          passed = approver.askToChangeReceivedToApproved((ApprovalFailureOverrider) reporter);
        }
        if (!passed)
        {
          approver.reportFailure(reporter);
          approver.fail();
        }
        else
        {
          approver.cleanUpAfterSuccess(reporter);
        }
      }
      else
      {
        approver.cleanUpAfterSuccess(reporter);
      }
    }
    catch (Exception e)
    {
      throw ObjectUtils.throwAsError(e);
    }
  }
  public static ApprovalNamer createApprovalNamer()
  {
    return new JUnitStackTraceNamer();
  }
  /**
   * Verifies the output file (received) against a Golden Master file (approved)<br/>
   * If there is no GoldenMaster, then the test will fail
   * <div><b>Example:</b> {@code  Approvals.verify(object)}</div>
   *
   * @param response
   *          The object to be verified <br/>
   *          NOTE: the object will be returned as a String
   */
  public static void verify(Object o) throws Exception
  {
    Approvals.verify(o + "");
  }
}