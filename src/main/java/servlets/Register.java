package servlets;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "register", value = "/register")

public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Display the login form.
     *
     * @param request {@link HttpServletRequest} The HTTP request filled with
     * the user data.
     * @param response {@link HttpServletResponse} The HTTP response we want
     * to send to the user.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/WEB-INF/register.jsp");
        // We do NOT send an HTTP 302 redirection code to the user, it's
        // still the same request. But we forward this request to the JSP
        // to handle it. Show the login form.

        dispatcher.forward(request, response);
    }

    /**
     * Handle the login form.
     *
     * @param request {@link HttpServletRequest} The HTTP request filled with
     * the user data.
     * @param response {@link HttpServletResponse} The HTTP response we want
     * to send to the user.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = (String) request.getParameter("nom");
        String prenom = (String) request.getParameter("prenom");
        String username = (String) request.getParameter("nomutilisateur");
        String password = (String) request.getParameter("mdp");
        String secondPassword = (String) request.getParameter("mdp2");

        String contextPath = getServletContext().getContextPath();

        HttpSession session = request.getSession();

        if (!password.equals(secondPassword)){
            response.sendRedirect("register");
        }

        HashSet<User> users = (HashSet<User>) getServletContext().getAttribute("usersInfo");
        if (users == null){
            users = new HashSet<User>();
        }

        User actualUser = new User(username, prenom, nom, password);

        if (!users.contains(actualUser)) {
            users.add(actualUser);
            getServletContext().setAttribute("usersInfo", users);
            response.sendRedirect("login");
        }
        else{
            response.sendRedirect("register");
        }
    }
}
