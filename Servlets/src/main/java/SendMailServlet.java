import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SendMailServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String recepient = request.getParameter("subject");

        if (recepient.contains("@") == false) {
            out.print("no correct mail = no message ");
        }
        else {
            String msg=request.getParameter("msg");
            new Mailer().send(recepient, "привет из сервелета!", msg);
            out.print("message has been sent successfully");
        }
        out.close();
    }
}