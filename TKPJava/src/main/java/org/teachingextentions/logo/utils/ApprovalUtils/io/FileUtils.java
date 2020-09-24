package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ArrayUtils;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.Asserts;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ObjectUtils;

/**
 * A static class of convenience functions for Files
 */
public class FileUtils
{
  public static String readFromClassPath(final Class<?> clazz, final String string)
  {
    final InputStream resourceAsStream = loadInputStream(clazz, string);
    return FileUtils.readStream(resourceAsStream);
  }
  public static InputStream loadInputStream(final Class<?> type, final String name)
  {
    InputStream resource = type.getResourceAsStream(name);
    if (resource == null)
    {
      resource = type.getClassLoader().getResourceAsStream(name);
    }
    if (resource == null) { throw new IllegalStateException("Could not find resource: " + name); }
    return resource;
  }
  public static File[] getRecursiveFileList(final File directory)
  {
    return getRecursiveFileList(directory, new SimpleFileFilter());
  }
  public static File[] getRecursiveFileList(final File directory, final FileFilter filter)
  {
    final ArrayList<File> list = new ArrayList<>();
    if (!directory.isDirectory()) { throw new Error("File is not a directory: " + directory.getName()); }
    final File directories[] = directory.listFiles(new SimpleDirectoryFilter());
    for (final File directory1 : directories)
    {
      ArrayUtils.addArray(list,
          getRecursiveFileList(directory1, filter));
    }
    final File files[] = directory.listFiles(filter);
    ArrayUtils.addArray(list, files);
    return list.toArray(new File[list.size()]);
  }
  public static void writeFile(final File file, final String text) throws IOException
  {
    Asserts
        .assertNotNull("Writing to file: " + file, text);
    final File canonicalFile = file.getCanonicalFile();
    canonicalFile.getParentFile().mkdirs();
    final BufferedWriter out = new BufferedWriter(new FileWriter(file));
    out.write(text);
    out.close();
  }
  public static void writeFileQuietly(final File file, final String text)
  {
    try
    {
      writeFile(file, text);
    }
    catch (final IOException e)
    {
      ObjectUtils.throwAsError(e);
    }
  }
  public static String readFile(final String absolutePath) throws IOException
  {
    return readFile(new File(absolutePath));
  }
  public static String readFile(final File file) throws IOException
  {
    final BufferedReader in = new BufferedReader(new FileReader(file));
    return readBuffer(in);
  }
  public static String readBuffer(final BufferedReader in) throws IOException
  {
    final StringBuilder string = new StringBuilder();
    while (in.ready())
    {
      string.append(in.readLine());
      string.append("\n");
    }
    in.close();
    return string.toString();
  }
  public static String readFileWithSuppressedExceptions(final File databaseFile)
  {
    try
    {
      return FileUtils.readFile(databaseFile);
    }
    catch (final FileNotFoundException e)
    {
      throw new RuntimeException("Invalid file '" + databaseFile.getAbsolutePath() + "'", e);
    }
    catch (final IOException e)
    {
      throw new RuntimeException(e);
    }
  }
  public static String getExtensionWithDot(final String filename)
  {
    final int p = filename.lastIndexOf('.');
    return filename.substring(p);
  }
  public static void createIfNeeded(final String file) throws IOException
  {
    final File f = new File(file);
    if (!f.exists())
    {
      writeFile(f, "");
    }
  }
  public static String readStream(final InputStream resourceAsStream)
  {
    final BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));
    String resource = null;
    try
    {
      resource = FileUtils.readBuffer(reader);
    }
    catch (final IOException e)
    {
      ObjectUtils.throwAsError(e);
    }
    return resource;
  }
  public static boolean isNonEmptyFile(final String approved)
  {
    final File file = new File(approved);
    return file.exists() && file.length() > 0;
  }
}