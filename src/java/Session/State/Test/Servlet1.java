/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Session.State.Test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
@MultipartConfig
public class Servlet1 extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String name = req.getParameter("user_name");
        String password = req.getParameter("user_password");
        String email = req.getParameter("user_email");
        Part part = req.getPart("image");
        String fileName = part.getSubmittedFileName();
        int noofrows = 0;
        int i = 0;
        i++;
        resp.setContentType("text/html");
        PrintWriter pr = resp.getWriter();
        try {
            Thread.sleep(2000);
            //        Cookie c = new Cookie("u_name", name);
//        resp.addCookie(c);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Reg", "root", "Shivam@2000!");
            Statement s = con.createStatement();

            String g = "insert into Reg_Details(user_name, user_password, user_email, image_name)values(?, ?, ?, ?)";
            PreparedStatement prst = con.prepareStatement(g);
            prst.setString(1, name);
            prst.setString(2, password);
            prst.setString(3, email);
            prst.setString(4, fileName);

            int x = prst.executeUpdate();

            InputStream fis = part.getInputStream();
            byte[] data = new byte[fis.available()];
            String path = req.getRealPath("/") + "img" + File.separator + fileName;
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(data);

//            ResultSet rs = s.executeQuery("select * from Reg_Details");
//            con.close();
            pr.println("success");
        } catch (Exception ex) {
            ex.printStackTrace();
            pr.println("error");
        }
    }

}
