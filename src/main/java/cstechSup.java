import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class cstechSup extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Test</title></head><body>");
        out.print("<form method='post'>");
        out.print("Name: <input type='text' name='name' /><br>");
        out.print("Email: <input type='email' name='email'/><br>");
        out.print("Problem: <input type='text' name='problem'/><br>");
        out.print("Problem Description: <textarea name='pdescription'  rows='10' cols='80'></textarea><br>");
        out.print("<input type='submit' value='Help'/>");
        out.print("</form>");
        out.print("</body></html>");
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext sc = this.getServletContext();
        String supEmail=sc.getInitParameter("support-email");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Test</title></head><body>");
        out.print("<p>Thank you! "+ name +" for contacting us. We should receive reply" +
                " from us with in 24 hrs in your email address "+ email +".");
        out.print("Let us know in our support email "+ supEmail +" if you " +
                "don’t receive reply within 24 hrs. Please be sure to attach your</p>");
        out.print("</body></html>");

       // Thank you! [Name] for contacting us. We should receive reply from us with in 24 hrs in your email address [Email Address].
        // Let us know in our support email [support email] if you don’t receive reply within 24 hrs. Please be sure to attach your
        // reference [support_ticket_id] in your email.
        //        Support_email should come from context param.
        //        Support_ticket_id is generated automatically for every request.

    }
}
