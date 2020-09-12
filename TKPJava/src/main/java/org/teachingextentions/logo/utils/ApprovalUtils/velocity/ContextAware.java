package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.velocity;

import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.velocity.context.Context;
//import org.apache.velocity.*;

public interface ContextAware
{
  public void setupContext(Context context);
  public static class ContextAwareMap implements ContextAware
  {
    HashMap<String, Object> add = new HashMap<>();
    public ContextAwareMap(String key, Object object)
    {
      put(key, object);
    }
    public void put(String key, Object object)
    {
      add.put(key, object);
    }
    public void setupContext(Context context)
    {
      for (Entry<String, Object> entry : add.entrySet())
      {
        context.put(entry.getKey(), entry.getValue());
      }
    }
  }
}
