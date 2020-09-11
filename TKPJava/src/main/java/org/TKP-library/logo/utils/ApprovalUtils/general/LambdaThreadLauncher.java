package utils;

import org.teachingextensions.approvals.lite.util.lambda.Action0;

public class LambdaThreadLauncher implements Runnable {
    private final Action0 function;

    public LambdaThreadLauncher(Action0 function) {
        this.function = function;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            long delay = 0;
            Thread.sleep(delay);
            function.call();
        } catch (Throwable t) {
            MySystem.warning("Caught throwable exception ", t);
        }
    }
}
