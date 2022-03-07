import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Foo extends HttpServlet 
{
    public void service(HttpServletRequest request
                        , HttpServletResponse response)
                        throws IOException, ServletException
    {
        // WAS(Tomcat) gives response instance to Foo instance
        // os instance is the instance of WAS
        OutputStream os = response.getOutputStream();
        // out instance prints out the String to the os instance of the WAS
        // "true" = flush the buffered output when entered
        PrintStream out = new PrintStream(os, true);
        out.println("Hello Servlet");
    }
}