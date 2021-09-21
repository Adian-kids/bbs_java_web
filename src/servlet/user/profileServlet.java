package servlet.user;


import bbs.dao.impl.postDaoImpl;
import bbs.dao.impl.userDaoImpl;
import bbs.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/profile")
public class profileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {

        try {

            int loginState = 0;
            Cookie cookie = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    if (cookie.getName().equals("userId")) {
                        loginState = 1;
                        String cookieId = cookie.getValue();
                        request.setAttribute("cookieId", cookieId);
                    }
                }

            }
            String userId = request.getParameter("userId");
            List posts = new postDaoImpl().getAllPostByUserId(Integer.valueOf(userId));
            User user = new userDaoImpl().getUserInfoById(Integer.valueOf(userId));
            request.setAttribute("userId", userId);
            request.setAttribute("user", user);
            request.setAttribute("posts", posts);
            request.setAttribute("state", loginState);

            request.getRequestDispatcher("/pages/profile.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}