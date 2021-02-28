package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

//Partie de code non fait

@WebServlet(name = "listuser", value = "/listuser")

public class ListUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType( "text/html" );
        PrintWriter out = resp.getWriter();
        HashSet<User> users = (HashSet<User>) getServletContext().getAttribute("usersInfo");
        out.print("<table><thead></thead><tbody>");

        if (users != null){
            for (User currentUser : users){
                out.print("<tr>");
                out.print("<td>"+currentUser.getFirstName()+ "</td><td>"+ currentUser.getLastName() + "</td><td>"+ currentUser.getUsername() +"</td>");
                out.print("</tr>");
            }
        }
        out.print("</tbody></table>");
    }
}
