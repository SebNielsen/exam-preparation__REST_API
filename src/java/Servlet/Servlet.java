/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sebastiannielsen
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("in do get");
        String id = request.getParameter("id");
        
        URL url = new URL("http://restcountries.eu/rest/v1/alpha?codes=" +id); 
        HttpURLConnection con = (HttpURLConnection)url.openConnection(); 
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json;charset=UTF-8"); 
        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr=null;
        if (scan.hasNext()) {
        jsonStr = scan.nextLine();
        }
        scan.close();
        response.setContentType("text/json");
        PrintWriter pw = response.getWriter();
        pw.print(jsonStr);
        pw.close();
    }

}
