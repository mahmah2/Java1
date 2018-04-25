/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Van.Security;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 *
 * @author User
 */
public class AuthServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String username = request.getParameter("username"); //username can be any attribute
        String pass = request.getParameter("pass"); //pass can be any attribute

        if(username == null || pass == null)
        throw new RuntimeException("username or password is null");
        WebAuthentication pwl = new WebAuthentication();
        pwl.login(username, pass);

        //Only when there is web login, does the principal be visible
        log("User Principal="+request.getUserPrincipal());
        //Some basic checks to see if the user who just did a programmatic login has a role of "AuthorizedUser"
        log("isUserInRole(Authorized User)="+request.isUserInRole("AuthorizedUser"));
        if(request.getUserPrincipal() == null || !request.isUserInRole("AuthorizedUser"))
        throw new ServletException("User is not authenticated or the isUserInRole check failed");

        //Log the user out
        pwl.logout();

        if(request.getUserPrincipal() != null || request.isUserInRole("AuthorizedUser"))
        throw new ServletException("User is still authenticated or pass: isUserInRole(Authorized User)");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
