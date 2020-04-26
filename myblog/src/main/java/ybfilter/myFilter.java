package ybfilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/write.html")
public class myFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        String attribute = (String) session.getAttribute("password");
        if (attribute != null) {
            chain.doFilter(req, resp);
        } else {
            String password = request.getParameter("password");
            if ("2022666".equals(password)) {
                session.setAttribute("password","2022666");
                chain.doFilter(req, resp);
            } else {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("密码有误，请重新输入");
            }
        }


    }

    public void destroy() {
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
