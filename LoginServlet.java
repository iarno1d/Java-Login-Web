import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/login") // This URL pattern is used in the form action
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Dummy credentials for validation
    private static final String VALID_USERNAME = "CSE";
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the username and password from the request
        String username = request.getParameter("username");
              // Set the response content type
        response.setContentType("text/html");

        // Get the print writer to write the response
        PrintWriter out = response.getWriter();

        // Validate the credentials
        if (VALID_USERNAME.equals(username)) {
            // Successful login
            out.println("<html><body>");
            out.println("<h2>Welcome, " + username + "!</h2>");
            out.println("</body></html>");
        } else {
            // Failed login
            out.println("<html><body>");
            out.println("<h2>Login Failed! Invalid username or password.</h2>");
            out.println("<a href='login.html'>Try Again</a>");
            out.println("</body></html>");
        }
    }
}
