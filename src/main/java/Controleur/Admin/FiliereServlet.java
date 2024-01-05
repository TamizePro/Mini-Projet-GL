package Controleur.Admin;

import Modele.*;
import Modele.Filiere;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class FiliereServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        // Obtaining all the  accounts via the connection instance
        Connection connection = MySQLConnection.getInstance();
        FiliereDAO filiereDAO = new FiliereDAO(connection);

        if (pathInfo == null || pathInfo.equals("/")) {
            List<Filiere> filieres =  filiereDAO.GetAllFiliere();

            // Set the object as a request attribute
            request.setAttribute("filières", filieres);

            // Forward the request to the JSP
            request.getRequestDispatcher("/filières.jsp").forward(request, response);
        } else {
            // modifier getcompte pour avoir pour parametre l'id
            //int userId = pathInfo.substring(1);
            int code = Integer.parseInt(request.getParameter("code"));
            Filiere filiere =  filiereDAO.GetFiliereByCode(code);

            //Set the object as a request attribute
            request.setAttribute("filière", filiere);

            // Forward the request to the JSP
            request.getRequestDispatcher("/filiere.jsp").forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int code = Integer.parseInt(request.getParameter("code"));
        String nom = request.getParameter("nom");
        Filiere filiere = new FiliereBuilder(code, nom).build();

        // Obtaining all the  accounts via the connection instance
        Connection connection = MySQLConnection.getInstance();
        FiliereDAO filiereDAO = new FiliereDAO(connection);
        filiereDAO.AddFiliere(filiere);

        response.sendRedirect(request.getContextPath() + "/filieres");
    }
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pathInfo = request.getPathInfo();

        if (pathInfo != null && !pathInfo.equals("/")) {
            String userId = pathInfo.substring(1);


            // Obtaining all the  accounts via the connection instance
            Connection connection = MySQLConnection.getInstance();
            FiliereDAO filiereDAO = new FiliereDAO(connection);

            int code = Integer.parseInt(request.getParameter("code"));
            String nom = request.getParameter("nom");
            Filiere filiere = new FiliereBuilder(code, nom).build();
            filiereDAO.UpdateFiliereByCode(filiere,code);

            response.sendRedirect(request.getContextPath() + "/filieres");

        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtaining all the  accounts via the connection instance
        Connection connection = MySQLConnection.getInstance();
        FiliereDAO filiereDAO = new FiliereDAO(connection);


        // Delete an existing account
        String pathInfo = request.getPathInfo();
        if (pathInfo != null && !pathInfo.equals("/")) {
            String userId = pathInfo.substring(1);

            int code = Integer.parseInt(request.getParameter("code"));
            String nom = request.getParameter("nom");

            Filiere filiere = new FiliereBuilder(code, nom).build();
            filiereDAO.DeleteFiliere(filiere);
            response.sendRedirect(request.getContextPath() + "/filieres");

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


