package org.teachingextensions.approvals.lite.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassUtils {

    public static Class<?> getWrapperClass(Class<?> primitiveType) {
        if (boolean.class.equals(primitiveType)) {
            return Boolean.class;
        } else if (float.class.equals(primitiveType)) {
            return Float.class;
        } else if (long.class.equals(primitiveType)) {
            return Long.class;
        } else if (int.class.equals(primitiveType)) {
            return Integer.class;
        } else if (short.class.equals(primitiveType)) {
            return Short.class;
        } else if (byte.class.equals(primitiveType)) {
            return Byte.class;
        } else if (double.class.equals(primitiveType)) {
            return Double.class;
        } else if (char.class.equals(primitiveType)) {
            return Character.class;
        } else {
            return primitiveType;
        }
    }

    public static boolean hasMethod(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        try {
            return clazz.getMethod(methodName, parameterTypes) != null;
        } catch (SecurityException e) {
            throw ObjectUtils.throwAsError(e);
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    public static File getSourceDirectory(Class<?> clazz) {
        final String name = clazz.getName();
        String[] split = name.split("\\.");
        split[split.length - 1] = split[split.length - 1] + ".java";
        File found = find(new File("."), Arrays.asList(split));
        if (found == null) {
            throw new FormattedException("Didn't find %s under %s", name, new File("."));
        }
        return found.getParentFile();
    }

    public static File find(File file, List<String> matches) {
        ArrayList<String> copy = new ArrayList<>();
        copy.addAll(matches);
        copy.add(0, "*");
        return find2(file, copy);
    }

    public static File find2(File file, List<String> matches) {
        SearchingFileFilter searchingFileFilter = new SearchingFileFilter(matches);
        File[] listFiles = file.listFiles(searchingFileFilter);
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                File found = find2(file2, searchingFileFilter.getSubset(file2.getName()));
                if (found != null) {
                    return found;
                }
            } else {
                return file2;
            }
        }
        return null;
    }

    public static <T> T create(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw ObjectUtils.throwAsError(e);
        }
    }

}
