package Controleur.Admin;

import Modele.Compte;
import Modele.CompteDAO;
import Modele.MySQLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

//@WebServlet("/users/*")
public class CompteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        // Obtaining all the  accounts via the connection instance
        Connection connection = MySQLConnection.getInstance();
        CompteDAO compteDAO = new CompteDAO(connection);

        if (pathInfo == null || pathInfo.equals("/")) {
            List<Compte> comptes =  compteDAO.GetAllCompte();

            // Set the object as a request attribute
            request.setAttribute("comptes", comptes);

            // Forward the request to the JSP
            request.getRequestDispatcher("/comptes.jsp").forward(request, response);
        } else {
            // modifier getcompte pour avoir pour parametre l'id
            //int userId = pathInfo.substring(1);
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            Compte compte = compteDAO.GetCompte(login,password);

            //Set the object as a request attribute
            request.setAttribute("compte", compte);

            // Forward the request to the JSP
            request.getRequestDispatcher("/compte.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Create a new account
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Compte compte = new Compte(login, password);

        // Obtaining all the  accounts via the connection instance
        Connection connection = MySQLConnection.getInstance();
        CompteDAO compteDAO = new CompteDAO(connection);
        compteDAO.AddCompte(compte);

        response.sendRedirect(request.getContextPath() + "/comptes");
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Update an existing account
        String pathInfo = request.getPathInfo();

        if (pathInfo != null && !pathInfo.equals("/")) {
            String userId = pathInfo.substring(1);


            // Obtaining all the  accounts via the connection instance
            Connection connection = MySQLConnection.getInstance();
            CompteDAO compteDAO = new CompteDAO(connection);

            String login = request.getParameter("login");
            String newLogin = request.getParameter("new login");
            String newPassword = request.getParameter("new password");

            Compte newCompte = new Compte(newLogin, newPassword);
            compteDAO.UpdateCompteByLogin(newCompte,login);

            response.sendRedirect(request.getContextPath() + "/comptes");

        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtaining all the  accounts via the connection instance
        Connection connection = MySQLConnection.getInstance();
        CompteDAO compteDAO = new CompteDAO(connection);


        // Delete an existing account
        String pathInfo = request.getPathInfo();
        if (pathInfo != null && !pathInfo.equals("/")) {
            String userId = pathInfo.substring(1);

            String login = request.getParameter("login");
            String password = request.getParameter("password");

            Compte compte = new Compte(login,password);
            compteDAO.DeleteCompte(compte);
            response.sendRedirect(request.getContextPath() + "/comptes");

            /*User userToDelete = userMap.remove(userId);

            if (userToDelete != null) {
                response.sendRedirect(request.getContextPath() + "/comptes");
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }*/
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}

