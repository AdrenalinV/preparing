package servlet;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class OneServlet implements Servlet {
    private transient ServletConfig servletConf;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConf=servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConf;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.getWriter().println("<h2>Hello World</h2>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
