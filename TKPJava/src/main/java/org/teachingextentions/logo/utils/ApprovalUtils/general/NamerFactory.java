package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general;

public class NamerFactory {
    private static String additionalInformation;

    public static String getAndClearAdditionalInformation() {
        if (additionalInformation == null) {
            return "";
        }
        String out = "." + additionalInformation;
        additionalInformation = null;
        return out;
    }

    public static void asMachineSpecificTest(Function0<String> environmentLabeller) {
        additionalInformation = environmentLabeller.call();
    }
}