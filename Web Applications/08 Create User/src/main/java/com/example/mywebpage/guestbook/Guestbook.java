package com.example.mywebpage.guestbook;

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
            out.println(
                    "<div class='border border-secondary'><span style='font-weight: bold'>Entry #" + entryCount + "</span><table><colgroup><col style='width:30%'><col style='width:70%'></colgroup><tr><td>From:</td><td>" + entry.getName() + " (" + entry.getEmail() + ")</td></tr><tr><td>Comment:</td><td>" + entry.getComment() + "</td></tr></table></div><br>"
            );

            entryCount++;
        }

        entryCount = 1;
        out.println("<hr>");

        // print second part of html body
        printSecondBodyPart(out);
        out.println("</html>");
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
        out.println(
                "<head><title>Sports Club Altenstadt - Home</title><meta charset='utf-8'><meta content='width=device-width, initial-scale=1, shrink-to-fit=no' name='viewport'><meta name='description' content='Sports Club Altenstadt'><meta name='keywords' content='sports, tennis, football, altenstadt, austria, overview, home'><meta name='author' content='Matthias Meier'><link href='https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900' rel='stylesheet'><link href='https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css' rel='stylesheet'><link href='css/style.css' rel='stylesheet'></head>"
        );
    }

    public void printFirstBodyPart(PrintWriter out) {
        out.println(
                "<body><div class='wrapper d-flex align-items-stretch'><nav class='active' id='sidebar'><div class='custom-menu'><button class='btn btn-primary' id='sidebarCollapse' type='button'><i class='fa fa-bars'></i><span class='sr-only'>Toggle Menu</span></button></div><div class='p-4'><h1><a class='logo' href='index.jsp'><img alt='Logo' src='images/logo.png'></a></h1><ul class='list-unstyled components mb-5'><li><a href='index.jsp'><span class='fa fa-home mr-3'></span> Home</a></li><li><a aria-expanded='false' class='dropdown-toggle' data-toggle='collapse' href='#pageSubmenu'><span class='fa fa-building mr-3'></span> Departments</a><ul class='collapse list-unstyled' id='pageSubmenu'><li><a href='Controller?dispatchto=TCAltenstadtView'>TC Altenstadt</a></li><li><a href='Controller?dispatchto=TSVAltenstadtView'>TSV Altenstadt</a></li></ul></li><li class='active'><a href='guestbook'><span class='fa fa-book mr-3'></span> Guestbook</a></li><li><a aria-expanded='false' class='dropdown-toggle' data-toggle='collapse' href='#testingSubmenu'><span class='fa fa-star mr-3'></span> Fun Pages</a><ul class='collapse list-unstyled' id='testingSubmenu'><li><a href='Controller?dispatchto=DynamicTableView'>Dynamic Table</a></li></ul></li><li><a href='Controller?dispatchto=CreateAccountView'><span class='fa fa-user mr-3'></span> Create Account</a></li><li><a href='mailto: matthias.meier@students.fhv.at'><span class='fa fa-paper-plane mr-3'></span>Contact</a></li></ul><div class='footer'><p>Copyright &copy;<script>document.write(new Date().getFullYear());</script>Matthias Meier</p></div>        </div></nav><div class='p-4 p-md-5 pt-5' id='content'><h2 class='mb-4'>Guestbook</h2><div class='row'><div class='col'><h4>Entries</h4>"
        );
    }

    public void printSecondBodyPart(PrintWriter out) {
        out.println(
                "</div></div><div class='row'><div class='col'><h4>Add Entry</h4><form method='post' action='guestbook'><div class='formgroup'><label for='name'>Name</label><input type='text' class='form-control' name='name' id='name' required/></div><div class='formgroup'><label for='email'>Email</label><br><input type='email' class='form-control' name='email' id='email' required/></div><div class='formgroup'><label for='comment'>Comment</label><textarea class='form-control' name='comment' id='comment' rows='3' required></textarea></div><br><button type='reset' class='btn btn-light' name='reset' id='reset'>Reset</button> <button type='submit' class='btn btn-primary' name='submit' id='submit'>Add Entry</button></form></div></div><script src='js/jquery.min.js'></script><script src='js/popper.js'></script><script src='js/bootstrap.min.js'></script><script src='js/main.js'></script><script src='js/cookies.js'></script></body>"
        );
    }
}