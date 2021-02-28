package servlets;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Request;


@WebServlet(name = "login", value = "/login")

public class Login extends HttpServlet {
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
                .getRequestDispatcher("/WEB-INF/login.jsp");
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
        // We read the login and password given by the user.
        String givenLogin = (String) request.getParameter("nomUtilisateur");
        String givenPassword = (String) request.getParameter("mdp");
        String contextPath = getServletContext().getContextPath();

        HttpSession session = request.getSession();
        HashSet<User> users = (HashSet<User>) getServletContext().getAttribute("usersInfo");
        if (users == null){
            response.sendRedirect("register");
        }
        else {
            for (User currentUser : users) {
                if (currentUser.getUsername().equals(givenLogin) && currentUser.getPassword().equals(givenPassword)) {
                    System.out.println("found");
                    session.setAttribute("login", givenLogin);
                    return;
                }
            }
            //response.sendRedirect("login");
        }
    }
}
