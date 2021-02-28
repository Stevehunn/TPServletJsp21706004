package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;

@WebServlet(name = "deleteAccount", value = "/deleteAccount")

public class DeleteAccount extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // We read the login and password given by the user.
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");

        HashSet<User> users = (HashSet<User>) getServletContext().getAttribute("usersInfo");
        if (users == null){
            response.sendRedirect("register");
        }
        else {
            for (User currentUser : users) {
                if (currentUser.getUsername().equals(login)) {
                    users.remove(currentUser);
                    session.setAttribute("login", "");
                    response.sendRedirect("register");
                    return;
                }
            }
            response.sendRedirect("login");
        }
    }
}
