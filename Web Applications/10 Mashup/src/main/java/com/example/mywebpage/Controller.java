package com.example.mywebpage;

import com.example.mywebpage.bean.AccountBean;
import com.example.mywebpage.bean.LoginBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    private final List<AccountBean> accounts = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        accounts.add(new AccountBean("user", "pass"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext application = getServletContext();
        HttpSession session = req.getSession();

        String dispatchto = "";

        if (req.getParameter("dispatchto") != null) {
            dispatchto = req.getParameter("dispatchto");
        }

        switch (dispatchto) {
            case "HomeView":
            case "": {
                String page = "/index.jsp";
                RequestDispatcher dispatcher = application.getRequestDispatcher(page);
                dispatcher.forward(req, resp);
                break;
            }
            case "TCAltenstadtView": {
                String page;

                if (session.getAttribute("login") != null) {
                    page = "/TCAltenstadtView.jsp";
                    RequestDispatcher dispatcher = application.getRequestDispatcher(page);
                    dispatcher.forward(req, resp);
                } else {
                    page = "/Login/LoginView.jsp";
                    RequestDispatcher dispatcher = application.getRequestDispatcher(page);
                    dispatcher.forward(req, resp);
                }

                break;
            }
            case "TSVAltenstadtView": {
                String page;

                if (session.getAttribute("login") != null) {
                    page = "/TSVAltenstadtView.jsp";
                    RequestDispatcher dispatcher = application.getRequestDispatcher(page);
                    dispatcher.forward(req, resp);
                } else {
                    page = "/Login/LoginView.jsp";
                    RequestDispatcher dispatcher = application.getRequestDispatcher(page);
                    dispatcher.forward(req, resp);
                }

                break;
            }
            case "DynamicTableView": {
                String page = "/DynamicTableView.jsp";
                RequestDispatcher dispatcher = application.getRequestDispatcher(page);
                dispatcher.forward(req, resp);
                break;
            }
            case "MashupView": {
                String page = "/MashupView.jsp";
                RequestDispatcher dispatcher = application.getRequestDispatcher(page);
                dispatcher.forward(req, resp);
                break;
            }
            case "CreateAccountView": {
                String page = "/CreateAccount/CreateAccountView.jsp";
                RequestDispatcher dispatcher = application.getRequestDispatcher(page);
                dispatcher.forward(req, resp);
                break;
            }
            case "CreateAccount": {
                String firstName = req.getParameter("firstName");
                String lastName = req.getParameter("lastName");
                String userID = req.getParameter("userID");
                String password = req.getParameter("password");

                session.setAttribute("createAccount", new AccountBean(firstName, lastName, userID, password));
                boolean accountIsValid = true;

                for (AccountBean accountBean : accounts) {
                    if (accountBean.getUserID().equals(userID)) {
                        accountIsValid = false;
                    }
                }

                if (accountIsValid) {
                    accounts.add(new AccountBean(firstName, lastName, userID, password));
                    String page = "/CreateAccount/CreateAccountSuccessView.jsp";
                    RequestDispatcher dispatcher = application.getRequestDispatcher(page);
                    dispatcher.forward(req, resp);
                } else {
                    String page = "/CreateAccount/CreateAccountFailureView.jsp";
                    RequestDispatcher dispatcher = application.getRequestDispatcher(page);
                    dispatcher.forward(req, resp);
                }

                session.removeAttribute("createAccount");
                break;
            }
            case "LoginView": {
                String page = "/Login/LoginView.jsp";
                RequestDispatcher dispatcher = application.getRequestDispatcher(page);
                dispatcher.forward(req, resp);
                break;
            }
            case "Login": {
                String userID = req.getParameter("userID");
                String password = req.getParameter("password");

                session.setAttribute("login", new LoginBean(userID, password));
                boolean loginIsValid = false;

                for (AccountBean accountBean : accounts) {
                    if (accountBean.getUserID().equals(userID) && accountBean.getPassword().equals(password)) {
                        loginIsValid = true;
                    }
                }

                String page;

                if (loginIsValid) {
                    page = "/Login/LoginSuccessView.jsp";
                    RequestDispatcher dispatcher = application.getRequestDispatcher(page);
                    dispatcher.forward(req, resp);
                } else {
                    session.removeAttribute("login");
                    page = "/Login/LoginFailureView.jsp";
                    RequestDispatcher dispatcher = application.getRequestDispatcher(page);
                    dispatcher.forward(req, resp);
                }

                break;
            }
        }
    }
}
