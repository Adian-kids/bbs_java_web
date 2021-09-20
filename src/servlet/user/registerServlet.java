package servlet.user;


import bbs.dao.impl.userDaoImpl;
import bbs.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@WebServlet("/register")
public class registerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    public void doPost(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String email = request.getParameter("email");
            String passwd = request.getParameter("passwd");
            User user = new User();
            user.setEmail(email);
            user.setPassword(passwd);
            int checkResult = new userDaoImpl().checkEmail(email);
            System.out.println("checkResult");
            System.out.println(checkResult);
            if (checkResult == 1) {
                int regResult = new userDaoImpl().addUser(user);
                request.setAttribute("regResult", regResult);
            }else{
                request.setAttribute("regResult",-1);
            }
            request.getRequestDispatcher("/pages/register.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
