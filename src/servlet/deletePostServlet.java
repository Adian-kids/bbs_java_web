package servlet;


import bbs.dao.impl.*;

import java.io.*;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/deletePost")
public class deletePostServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int loginState = 0;
            Cookie cookie = null;
            Cookie[] cookies = request.getCookies();
            String userId = null;
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    if (cookie.getName().equals("userId")) {
                        loginState = 1;
                        System.out.println(loginState);
                        userId = cookie.getValue();
                        String nickname = new userDaoImpl().getUserInfoById(Integer.valueOf(userId)).getNickname();
                        request.setAttribute("nickname", nickname);
                        request.setAttribute("userId", userId);
                    }
                }

            }

            String postId = request.getParameter("postId");
            int deleteResult = new postDaoImpl().deletePostByPostId(Integer.valueOf(postId));
            request.setAttribute("deleteResult", deleteResult);

            request.setAttribute("state", loginState);

            request.getRequestDispatcher("/pages/profile.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}