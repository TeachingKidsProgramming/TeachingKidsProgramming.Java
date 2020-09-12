package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.Function0;

public class OsEnvironmentLabeller implements Function0<String> {
    @Override
    public String call() {
        return System.getProperty("os.name").replace(' ', '_');
    }
}