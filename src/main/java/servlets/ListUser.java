package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

@WebServlet(name = "listuser", value = "/listuser")

public class ListUser extends HttpServlet {

  //  HttpSession session = request.getSession();
    HashSet<User> users = (HashSet<User>) getServletContext().getAttribute("usersInfo");
      /*  if (users == null){


        }
        else{

        }*/
}
