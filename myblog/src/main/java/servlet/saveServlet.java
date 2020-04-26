package servlet;

import dao.io.textio;
import domain.text;
import service.textService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/saveServlet")
public class saveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        textService service = new textService();
        String title = request.getParameter("title");
        String label = request.getParameter("label");
        String main = request.getParameter("main");
        String name = request.getParameter("name");
        name = name.substring(name.lastIndexOf("\\")+1);
        text t = new text();
        t.setTitle(title);
        t.setTextAddress(textio.getPath()+"\\text\\"+title+".txt");
        t.setCreatTime(new Date());
        t.setLabel(label);
        t.setCount(1);
        t.setPicture("images\\"+name);
        service.save(t, title, main);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }


}
