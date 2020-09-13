package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.velocity;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

import org.apache.velocity.runtime.RuntimeLogger;
import org.apache.velocity.runtime.parser.node.AbstractExecutor;
import org.apache.velocity.runtime.parser.node.BooleanPropertyExecutor;
import org.apache.velocity.runtime.parser.node.GetExecutor;
import org.apache.velocity.runtime.parser.node.PropertyExecutor;
import org.apache.velocity.util.ArrayIterator;
import org.apache.velocity.util.EnumerationIterator;
import org.apache.velocity.util.introspection.Info;
import org.apache.velocity.util.introspection.Introspector;
import org.apache.velocity.util.introspection.IntrospectorBase;
import org.apache.velocity.util.introspection.Uberspect;
import org.apache.velocity.util.introspection.UberspectLoggable;
import org.apache.velocity.util.introspection.VelMethod;
import org.apache.velocity.util.introspection.VelPropertyGet;
import org.apache.velocity.util.introspection.VelPropertySet;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ObjectUtils;

/**
 * Implementation of Uberspect to provide the default introspective
 * functionality of Velocity
 *
 * @author <a href="mailto:geirm@optonline.net">Geir Magnusson Jr.</a>
 * @version $Id: UberspectImpl.java,v 1.2.4.1 2004/03/03 23:23:08 geirm Exp $
 */
public class TestableUberspect implements Uberspect, UberspectLoggable {
  /**
   * the default Velocity introspector
   */
  private static IntrospectorBase introspector;
  private static Introspector introspectorWithLog;
  private RuntimeLogger log;

  /***********************************************************************/
  /**
   * init - does nothing - we need to have setRuntimeLogger called before getting
   * our introspector, as the default vel introspector depends upon it.;
   */
  @Override
  public void init() throws Exception {
  }

  @Override
  public void setRuntimeLogger(final RuntimeLogger runtimeLogger) {
    introspector = new IntrospectorBase();
    introspectorWithLog = new Introspector(runtimeLogger);
    log = runtimeLogger;
  }

  @Override
  public Iterator<?> getIterator(final Object obj, final Info i) throws Exception {
    return getStandardIterator(obj, i);
  }

  public static Iterator<?> getStandardIterator(final Object obj, final Info i) {
    if (obj.getClass().isArray()) {
      return new ArrayIterator(obj);
    } else if (obj instanceof Collection) {
      return ((Collection<?>) obj).iterator();
    } else if (obj instanceof Map) {
      return ((Map<?, ?>) obj).values().iterator();
    } else if (obj instanceof Iterator) {
      return ((Iterator<?>) obj);
    } else if (obj instanceof Enumeration) {
      return new EnumerationIterator((Enumeration<?>) obj);
    }
    try {
      throw new VelocityParsingError("Could not determine type of iterator in " + "#foreach loop ", i);
    } catch (VelocityParsingError e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }
  @Override
  public VelMethod getMethod(final Object obj, final String methodName, final Object[] args, final Info i) throws Exception
  {
    if (obj == null) { throw new VelocityParsingError("tried " + getMethodText("null", methodName, args), i); }
    final Method m = introspector.getMethod(obj.getClass(), methodName, args);
    if (m == null) { throw new VelocityParsingError("Method "
        + getMethodText(obj.getClass().getName(), methodName, args) + " does not exist.", i); }
    return new VelMethodImpl(m);
  }
  public static String getMethodText(final String className, final String methodName, final Object[] args)
  {
    final StringBuilder methodSignature = new StringBuilder();
    for (int i = 0; args != null && i < args.length; i++)
    {
      methodSignature.append(ObjectUtils.getClassName(args[i]));
      methodSignature.append(i == (args.length - 1) ? "" : ", ");
    }
    return className + "." + methodName + "(" + methodSignature + ") ";
  }
  @Override
  public VelPropertyGet getPropertyGet(final Object obj, final String identifier, final Info i) throws Exception
  {
    AbstractExecutor executor;
    if (obj == null) { throw new VelocityParsingError("tried " + getPropertyText("null", identifier), i); }
    final Class<?> type = obj.getClass();
    // trying getFoo()
    executor = new PropertyExecutor(log, introspectorWithLog, type, identifier);
    if (!executor.isAlive())
    {
      // trying get("foo")
      executor = new GetExecutor(log, introspectorWithLog, type, identifier);
    }
    if (!executor.isAlive())
    {
      // trying isFoo()
      executor = new BooleanPropertyExecutor(log, introspectorWithLog, type, identifier);
    }
    if (!executor.isAlive()) { throw new VelocityParsingError("Did not find "
        + getPropertyText(obj.getClass().getName(), identifier), i); }
    return new VelGetterImpl(executor);
  }
  private String getPropertyText(final String className, final String identifier)
  {
    return className + "." + identifier + " ";
  }
  @Override
  public VelPropertySet getPropertySet(final Object obj, final String identifier, final Object arg, final Info i) throws Exception
  {
    final Class<?> type = obj.getClass();
    VelMethod vm = null;
    try
    {
      /*
       * first, we introspect for the set<identifier> setter method
       */
      final Object[] params = {arg};
      try
      {
        vm = getMethod(obj, "set" + identifier, params, i);
        if (vm == null) { throw new NoSuchMethodException(); }
      }
      catch (final NoSuchMethodException e)
      {
        final StringBuilder sb = new StringBuilder("set");
        sb.append(identifier);
        if (Character.isLowerCase(sb.charAt(3)))
        {
          sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
        }
        else
        {
          sb.setCharAt(3, Character.toLowerCase(sb.charAt(3)));
        }
        vm = getMethod(obj, sb.toString(), params, i);
        if (vm == null) { throw new NoSuchMethodException(); }
      }
    }
    catch (final NoSuchMethodException e)
    {
      /*
       * right now, we only support the Map interface
       */
      if (Map.class.isAssignableFrom(type))
      {
        final Object[] params = {new Object(), new Object()};
        vm = getMethod(obj, "put", params, i);
        if (vm != null)
          return new VelSetterImpl(vm, identifier);
      }
    }
    return (vm != null) ? new VelSetterImpl(vm) : null;
  }
  public static class VelMethodImpl implements VelMethod
  {
    Method method = null;
    public VelMethodImpl(final Method m)
    {
      method = m;
    }
    @Override
    public Object invoke(final Object o, final Object[] params) throws Exception
    {
      return method.invoke(o, params);
    }
    @Override
    public boolean isCacheable()
    {
      return true;
    }
    @Override
    public String getMethodName()
    {
      return method.getName();
    }
    @Override
    public Class<?> getReturnType()
    {
      return method.getReturnType();
    }
  }
  public static class VelGetterImpl implements VelPropertyGet
  {
    AbstractExecutor ae = null;
    public VelGetterImpl(final AbstractExecutor exec)
    {
      ae = exec;
    }
    @Override
    public Object invoke(final Object o) throws Exception
    {
      return ae.execute(o);
    }
    @Override
    public boolean isCacheable()
    {
      return true;
    }
    @Override
    public String getMethodName()
    {
      return ae.getMethod().getName();
    }
  }
  public static class VelSetterImpl implements VelPropertySet
  {
    VelMethod vm     = null;
    String    putKey = null;
    public VelSetterImpl(final VelMethod velmethod)
    {
      this.vm = velmethod;
    }
    public VelSetterImpl(final VelMethod velmethod, final String key)
    {
      this.vm = velmethod;
      putKey = key;
    }
    @Override
    public Object invoke(final Object o, final Object value) throws Exception
    {
      final ArrayList<Object> al = new ArrayList<>();
      if (putKey != null)
      {
        al.add(putKey);
        al.add(value);
      }
      else
      {
        al.add(value);
      }
      return vm.invoke(o, al.toArray());
    }
    @Override
    public boolean isCacheable()
    {
      return true;
    }
    @Override
    public String getMethodName()
    {
      return vm.getMethodName();
    }
  }
}
