package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general;

public class OsEnvironmentLabeller implements Function0<String> {
    @Override
    public String call() {
        return System.getProperty("os.name").replace(' ', '_');
    }
}