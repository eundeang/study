package com.eundeang.cookie_with_jsp;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("index")
public class MainServlet extends HttpServlet {
    public String index() {
        return "index";
    }
}
