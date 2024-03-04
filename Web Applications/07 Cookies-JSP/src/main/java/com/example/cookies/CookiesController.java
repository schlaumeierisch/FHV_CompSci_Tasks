package com.example.cookies;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/index.html"})
public class CookiesController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        boolean cookiesAvailable = false;

        // avoid browser caching ("no-store" & "must-revalidate" are required for Firefox)
        resp.setHeader("Cache-Control", "no-cache, must-revalidate");

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie c = cookies[i];
                if ("lastView".equals(c.getName())) {
                    cookiesAvailable = true;
                    resp.sendRedirect(c.getValue());
                }
            }
        }

        if (!cookiesAvailable) {
            resp.sendRedirect("home.html");
        }

    }

}
