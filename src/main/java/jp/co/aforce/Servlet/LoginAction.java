package jp.co.aforce.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.DAO.CustomerDAO;
import jp.co.aforce.beans.Customer;

@WebServlet("/login")
public class LoginAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup("jdbc/login_db");
        } catch (NamingException e) {
            throw new ServletException("Cannot retrieve java:/comp/env/jdbc/login_db", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Customer customer = null;
        try (Connection connection = dataSource.getConnection()) {
            CustomerDAO dao = new CustomerDAO(connection);
            customer = dao.search(login, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (customer != null) {
            session.setAttribute("customer", customer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login-out.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/login-error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
