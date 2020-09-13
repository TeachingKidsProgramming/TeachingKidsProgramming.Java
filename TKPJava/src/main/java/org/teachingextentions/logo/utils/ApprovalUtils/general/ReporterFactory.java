package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.reporters.*;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ClassUtils;

public class ReporterFactory {
    private static HashMap<String, Class<? extends ApprovalFailureReporter>> reporters = new HashMap<>();

    public static class FileTypes {
        public static final String Text = "txt";
        public static final String Html = "html";
        public static final String Excel = "csv";
        public static final String File = "file";
        public static final String Image = "png";
        private static final String Default = "default";
    }

    static {
        setupReporters();
    }

    public static ApprovalFailureReporter get(final String string) {
        ApprovalFailureReporter returned = getFromAnnotation();
        returned = tryFor(returned, reporters.get(string));
        returned = tryFor(returned, reporters.get(FileTypes.Default));
        return returned;
    }

    public static ApprovalFailureReporter getFromAnnotation() {
        final UseReporter reporter = getAnnotationFromStackTrace(UseReporter.class);
        return reporter == null ? null : getReporter(reporter);
    }

    private static ApprovalFailureReporter getReporter(final UseReporter reporter) {
        final Class<? extends ApprovalFailureReporter>[] classes = (Class<? extends ApprovalFailureReporter>[]) reporter
                .value();
        final List<ApprovalFailureReporter> reporters = new ArrayList<>();
        for (final Class<? extends ApprovalFailureReporter> clazz : classes) {
            final ApprovalFailureReporter instance = ClassUtils.create(clazz);
            reporters.add(instance);
        }
        return reporters.size() == 1 ? reporters.get(0) : (ApprovalFailureReporter) new MultiReporter(reporters);
    }

    private static <T extends Annotation> T getAnnotationFromStackTrace(final Class<T> annotationClass) {
        final StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        for (final StackTraceElement stack : trace) {
            Method method = null;
            Class<?> clazz = null;
            try {
                final String methodName = stack.getMethodName();
                clazz = Class.forName(stack.getClassName());
                method = clazz.getMethod(methodName, (Class<?>[]) null);
            } catch (final Exception e) {
                // ignore
            }
            T annotation = null;
            if (method != null) {
                annotation = method.getAnnotation(annotationClass);
            }
            if (annotation != null) {
                return annotation;
            }
            annotation = clazz != null ? clazz.getAnnotation(annotationClass) : null;
            if (annotation != null) {
                return annotation;
            }
        }
        return null;
    }

    private static ApprovalFailureReporter tryFor(final ApprovalFailureReporter returned,
            final Class<? extends ApprovalFailureReporter> trying) {
        if (returned == null && trying != null) {
            return ClassUtils.create(trying);
        }
        return returned;
    }

    private static void setupReporters() {
        reporters.put(FileTypes.Text, (Class<? extends ApprovalFailureReporter>) DiffReporter.class);
        reporters.put(FileTypes.Html, (Class<? extends ApprovalFailureReporter>) DiffReporter.class);
        reporters.put(FileTypes.Excel, (Class<? extends ApprovalFailureReporter>) FileLauncherReporter.class);
        reporters.put(FileTypes.File, (Class<? extends ApprovalFailureReporter>) FileLauncherReporter.class);
        reporters.put(FileTypes.Image, (Class<? extends ApprovalFailureReporter>) ImageReporter.class);
        reporters.put(FileTypes.Default, (Class<? extends ApprovalFailureReporter>) QuietReporter.class);
    }
}
