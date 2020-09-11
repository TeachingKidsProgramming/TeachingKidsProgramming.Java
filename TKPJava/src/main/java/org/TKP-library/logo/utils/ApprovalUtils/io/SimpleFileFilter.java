package utils.io;

import java.io.File;

public class SimpleFileFilter implements java.io.FileFilter {
    /**
     * ********************************************************************
     */
    public SimpleFileFilter() {
    }

    /**
     * *******************************************************************
     */
    public boolean accept(File pathname) {
        String name = pathname.getName().toLowerCase();
        boolean accept;
        accept = !(name.equals(".") || name.equals("..")) && !pathname.isDirectory();
        return accept;
    }
    /************************************************************************/
    /************************************************************************/
}