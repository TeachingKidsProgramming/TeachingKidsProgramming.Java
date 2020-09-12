package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general;

import java.lang.reflect.Method;

import org.teachingextensions.approvals.lite.util.lambda.Action0;

public class ThreadLauncher implements Runnable {
    private Object object = null;
    private Object[] objectParams = null;
    private Method method = null;
    private long delay;

    public ThreadLauncher(Object object, Method method, Object[] objectParams, long delay) {
        this.delay = delay;
        this.object = object;
        this.method = method;
        this.objectParams = objectParams;
        new Thread(this).start();
    }

    public void run() {
        try {
            Thread.sleep(delay);
            method.invoke(object, objectParams);
        } catch (Throwable t) {
            MySystem.warning("Caught throwable exception ", t);
        }
    }

    public static void launch(Action0 action) {
        new LambdaThreadLauncher(action);
    }
}
