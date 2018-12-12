import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> map = new HashMap<>();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        String as = req.getParameter("a");
        String bs = req.getParameter("b");
        String cs = req.getParameter("c");

        String bc;
        String c0;
        if (Double.parseDouble(bs) < 0) {
            bc = " ";
        }
        else {
            bc = " +";
        }
        if (Double.parseDouble(cs) < 0) {
            c0 = " ";
        }
        else {
            c0 = " +";
        }
        map.put("bc", bc);
        map.put("c0", c0);
        map.put("a", as);
        map.put("b", bs);
        map.put("c", cs);

        String answer = new SolveQquation(as,bs,cs).getAnswer();
        map.put("answer", answer);
        PrintWriter writer = resp.getWriter();
        writer.write(new Gson().toJson(map));
        writer.flush();
    }
}
