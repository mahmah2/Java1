/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Van.Product.Servlet;

import Van.Model.Product;
import Van.Model.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet("/products")
public class ProductServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void showJPS(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
            List<Product> products =  new ArrayList<Product>();
            products.add(new Product(1, "EGR", "Electronic Gas Releaser", new BigDecimal(20.5)));
            products.add(new Product(10, "ECU", "Electronic Control Unit", new BigDecimal(59.00)));
            products.add(new Product(50, "AGV", "Automatic Guided Vehicle", new BigDecimal(30000.00)));

            products.get(0).setId(7);

            request.setAttribute("products", products);
            request.getRequestDispatcher("/JSP/Product/ProductList.jsp").forward(request, response);
        
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try (PrintWriter out = response.getWriter()) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            List<Product> products =  new ArrayList<Product>();
            products.add(new Product(1, "EGR", "Electronic Gas Releaser", new BigDecimal(20.5)));
            products.add(new Product(10, "ECU", "Electronic Control Unit", new BigDecimal(59.00)));
            products.add(new Product(50, "AGV", "Automatic Guided Vehicle", new BigDecimal(30000.00)));
            
            GsonBuilder builder = new GsonBuilder(); 
            Gson gson = builder.create(); 

            String jsonString = gson.toJson(products); 

            System.out.println(jsonString); //web server output   
            out.println(jsonString);  
            out.flush();
        }
        
    }

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
        showJPS(request, response);
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
