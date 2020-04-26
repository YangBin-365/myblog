package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.text;
import service.textService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findOneServlet")
public class findOneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        textService service = new textService();
        int id = Integer.parseInt(request.getParameter("id"));
        text t = service.findOne(id);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(t);
        response.setContentType("application/json;charset = utf-8");
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
