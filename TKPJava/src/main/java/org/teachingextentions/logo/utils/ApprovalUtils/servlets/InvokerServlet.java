package src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.MySystem;
import src.main.java.org.teachingextentions.logo.utils.ApprovalUtils.general.ObjectUtils;

public final class InvokerServlet extends HttpServlet
{
  private static final long    serialVersionUID = 7573882633420881472L;
  HashMap<String, HttpServlet> servlets         = new HashMap<>();
  private String               mask;
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    serveRequest(request, response);
  }
  @Override
  public void doHead(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException
  {
    serveRequest(request, response);
  }
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException
  {
    serveRequest(request, response);
  }
  /**
   * Initialize this servlet.
   */
  @Override
  public void init() throws ServletException
  {
    mask = getServletConfig().getInitParameter("mask");
    MySystem.variable("Mask", mask);
  }
  @Override
  public void destroy()
  {
    for (HttpServlet servlet : servlets.values())
    {
      servlet.destroy();
    }
    super.destroy();
  }
  public void serveRequest(HttpServletRequest request, HttpServletResponse response) throws IOException,
      ServletException
  {
    String pathInfo = request.getPathInfo();
    String servletClass = pathInfo.substring(1);
    int slash = servletClass.indexOf('/');
    if (slash >= 0)
    {
      servletClass = servletClass.substring(0, slash);
    }
    if (!servletClass.startsWith(mask))
    {
      response.sendError(HttpServletResponse.SC_NOT_FOUND, servletClass);
      return;
    }
    HttpServlet servlet;
    synchronized (this)
    {
      servlet = servlets.get(servletClass);
      if (servlet == null)
      {
        try
        {
          servlet = (HttpServlet) Class.forName(servletClass).newInstance();
          servlet.init(getServletConfig());
        }
        catch (Throwable e)
        {
          ObjectUtils.throwAsError(e);
        }
        servlets.put(servletClass, servlet);
      }
    }
    servlet.service(request, response);
  }
}
