package com.example.guestbook;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "guestbook", value = "/guestbook")
public class Guestbook extends HttpServlet {

    private final List<GuestbookEntry> entries = new ArrayList<>();
    private int entryCount = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        // print head and first part of html body
        out.println("<!DOCTYPE html><html lang='en'>");
        printHeader(out);
        printFirstBodyPart(out);

        // print all guestbook entries
        for (GuestbookEntry entry : entries) {
            out.println("<span style='font-weight: bold'>#" + entryCount + "</span>" +
                    "<table class='comment'>" +
                    "<colgroup><col style='width:30%'><col style='width:70%'></colgroup>" +
                    "<tr><td>From:</td><td>" + entry.getName() + " (" + entry.getEmail() + ")</td></tr>" +
                    "<tr><td>Comment:</td><td>" + entry.getComment() + "</td></tr>" +
                    "</table>");

            entryCount++;
        }

        entryCount = 1;
        out.println("<hr>");

        // print second part of html body
        printSecondBodyPart(out);
        out.println("</html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String comment = req.getParameter("comment");

        entries.add(new GuestbookEntry(name, email, comment));

        doGet(req, resp);
    }

    public void printHeader(PrintWriter out) {
        out.println("<head>" +
                "<meta charset='UTF-8'>" +
                "<meta http-equiv='X-UA-Compatible' content='IE=edge'>" +
                "<meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                "<meta name='description' content='Sports Club Altenstadt'>" +
                "<meta name='keywords' content='sports, tennis, football, altenstadt, austria, guestbook'>" +
                "<meta name='author' content='Matthias Meier'>" +
                "<title>Sports Club Altenstadt - Guestbook</title>" +
                "<link rel='stylesheet' href='./css/styles.css'>" +
                "<link rel='stylesheet' media='print' href='./css/print.css'>" +
                "</head>");
    }

    public void printFirstBodyPart(PrintWriter out) {
        out.println("<body>" +
                "<div class='sidenav'>" +
                "<a href='index.html' class='logo'><img src='./img/logo.png' alt='Sports Club Altenstadt' width='150px'></a>" +
                "<a href='index.html'>Home</a>" +
                "<a href='tsv-altenstadt.html'>TSV Altenstadt</a>" +
                "<a href='tc-altenstadt.html'>TC Altenstadt</a>" +
                "<a href='guestbook' class='active'>Guestbook</a>" +
                "<a href='create-account.html'>Create Account</a>" +
                "<a href='mailto: matthias.meier97@hotmail.com'><img src='./img/email.png' class='icon' alt='email' width='30px'>Contact</a>" +
                "</div>" +
                "<div class='main'>" +
                "<h1>Guestbook</h1>" +
                "<h2>Comments</h2>");
    }

    public void printSecondBodyPart(PrintWriter out) {
        out.println("<h2>Add Comment</h2>" +
                "<form method='post' action='guestbook'>" +
                "<p>" +
                "<label for='name'>Name</label><br>" +
                "<input type='text' placeholder='Enter Name' name='name' id='name' required/>" +
                "</p>" +
                "<p>" +
                "<label for='email'>Email</label><br>" +
                "<input type='email' placeholder='Enter Email' name='email' id='email' required/>" +
                "</p>" +
                "<p>" +
                "<label for='comment'>Comment</label><br>" +
                "<textarea placeholder='Enter Comment' name='comment' id='comment' rows='3' required></textarea>" +
                "</p>" +
                "<p>" +
                "<input type='reset' name='reset' id='reset' value='Reset'> " +
                "<input type='submit' name='submit' id='submit' value='Post Comment'>" +
                "</p>" +
                "</form>" +
                "</div>" +
                "</body>");
    }
}