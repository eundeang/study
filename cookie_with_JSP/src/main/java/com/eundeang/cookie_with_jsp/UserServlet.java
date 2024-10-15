package com.eundeang.cookie_with_jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if("login".equals(action)) {
            HttpSession session = req.getSession();
            String loginId = (String)session.getAttribute("loginId");
            if(loginId==null) {
                req.getRequestDispatcher("/webapp/WEB-INF/views/login.jsp").forward(req,resp);
            } else {
                req.setAttribute("msg", "이미 로그인 내역이 있습니다");
                req.setAttribute("path", req.getContextPath());
                req.getRequestDispatcher("/webapp/WEB-INF/views/alert.jsp");
            }
        } else if ("logout".equals(action)) {
            HttpSession session = req.getSession();
            session.removeAttribute("loginId");
            req.setAttribute("msg", "로그아웃 되었습니다.");
            req.setAttribute("path", req.getContextPath());
            req.getRequestDispatcher("/webapp/WEB-INF/views/alert.jsp");
        }
    }
}
