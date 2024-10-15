package com.eundeang.cookie_with_jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet
public class MakeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("쿠키 발급하겠삼");
        int cookieNum = 0;

        // 쿠키 이름, 쿠키 값
        Cookie cookie = new Cookie("cookie" + cookieNum, "hi" + cookieNum);
        resp.addCookie(cookie);
        cookieNum++;

        req.getRequestDispatcher("/webapp/WEB-INF/views/makeCookie.jsp").forward(req, resp);
    }
}
