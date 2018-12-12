import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServerlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String login = req.getParameter("login");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();

        if (new PasswordValidator().isValidPassword(password)) {
            pw.println("<H1> Привет мир! ой... привет " + login + "</H1>");
        }
        else {
            pw.println("<H1> непраильно написан пароль" + "</H1>");
            pw.println("<H1> пароль должен содержать 8 символов и иметь хотя бы 1 чило и заглавную букву" + "</H1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
