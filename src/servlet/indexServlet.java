package servlet;

import bbs.dao.impl.*;
import bbs.entity.*;


import java.io.*;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/index")
public class indexServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {

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
            forumDaoImpl dao = new forumDaoImpl();
            Forum forum = dao.getForumInfo();
            List<Classify> allClassify = new classifyDaoImpl().getAllClassifyInfo();
            List<Section> allSection = new sectionDaoImpl().getAllSection();
            List<Post> top10Post = new postDaoImpl().getTop10Post();

            request.setAttribute("classifyList", allClassify);
            request.setAttribute("sectionList", allSection);
            request.setAttribute("postList", top10Post);
            request.setAttribute("state", loginState);


            request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}