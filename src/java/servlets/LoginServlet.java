
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utilities.*;

/**
 *
 * @author 882199
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        User user = (User)  session.getAttribute("user");
        
        if(logout != null){
            session.invalidate();
            request.setAttribute("infoMsg", "You have logged out successfully");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        if(user != null){
            response.sendRedirect("home");
        }else{
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response); 
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(username.equals("")||username == (null)||password.equals("")||password == (null)){
            request.setAttribute("infoMsg", "Enter a Username and Password");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }else{
            AccountService a = new AccountService();
            User user = a.login(username, password);
            
            if(user == null){
                request.setAttribute("infoMsg", "Invalid Login Credentials");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }else{
                session.setAttribute("user", user);
                response.sendRedirect("home");
            }
        }
        
    }
}
