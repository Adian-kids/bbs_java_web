package servlet;


import bbs.dao.impl.*;
import bbs.entity.Classify;
import bbs.entity.Forum;
import bbs.entity.Post;
import bbs.entity.Section;

import java.io.*;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/addPost")
public class addPostPageServlet extends HttpServlet {

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

            List<Section> allSection = new sectionDaoImpl().getAllSection();
            request.setAttribute("sections", allSection);
            request.setAttribute("state", loginState);
            request.getRequestDispatcher("/pages/addPost.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}