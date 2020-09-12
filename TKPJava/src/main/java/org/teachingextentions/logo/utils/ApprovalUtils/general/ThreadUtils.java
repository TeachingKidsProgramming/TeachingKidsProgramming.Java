package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general;


public class ThreadUtils {
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            // ignore
        }
    }
}
