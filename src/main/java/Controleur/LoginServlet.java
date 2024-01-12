package Controleur;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import Modele.MySQLConnection;
import Modele.Bean.Admin;
import Modele.Bean.Compte;
import Modele.Bean.Professeur;
import Modele.DAO.AdminDAO;
import Modele.DAO.ProfesseurDAO;
import Services.AuthService;
import Token.HandleToken;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    
    /*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.getWriter().write("Hello, Servlet!");
    }*/

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        AuthService auth = new AuthService(MySQLConnection.getInstance());
        Compte compte = auth.authenticate(request.getParameter("username"),
            auth.hashPassword(request.getParameter("pass")));
        System.out.println("Hello = "+auth.hashPassword(request.getParameter("pass")));
        if (compte == null)
            response.sendRedirect("/Mini-Projet-GL");
        HandleToken tok = new HandleToken();
        response.setHeader("Authorization", "Bearer " + tok.generateToken(compte.getLogin()));
        ProfesseurDAO professeurDAO = new ProfesseurDAO(MySQLConnection.getInstance());
        AdminDAO adminDAO = new AdminDAO(MySQLConnection.getInstance());
        Professeur professeur = professeurDAO.GetProfesseurByCode(compte.getLogin(), compte);
        Admin admin = adminDAO.getAdmin(compte);
        if (professeur != null)
            response.sendRedirect("prof.jsp");
        else if (admin != null)
            response.sendRedirect("admin.jsp");
    }
}
