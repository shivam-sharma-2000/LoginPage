/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Session.State.Test;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author DELL
 */
public class Servlet2 extends HttpServlet{
    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException,ServletException
    {
          Cookie c[]= req.getCookies();
           resp.setContentType("text/html");
           PrintWriter pr = resp.getWriter();
//           pr.println("<h1>welcome,"+c[0].getValue()+"</h1>");
    }
    
}
