package servlet.manage;

import bbs.dao.impl.forumDaoImpl;
import bbs.dao.impl.managerDaoImpl;
import bbs.dao.impl.postDaoImpl;
import bbs.dao.impl.userDaoImpl;
import bbs.entity.Forum;
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

@WebServlet("/editForum")
public class editForumServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {


        int loginState = 0;
        Cookie cookie = null;
        String userId = null;
        Cookie[] cookies = request.getCookies();
        int isManager = 0;
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if (cookie.getName().equals("userId")) {
                    userId = cookie.getValue();
                    try {
                        isManager = new managerDaoImpl().checkManager(Integer.valueOf(userId));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        String name = request.getParameter("title");
        String introduction = request.getParameter("introduction");
        Forum forum = new Forum();
        forum.setName(name);
        forum.setIntroduction(introduction);

        try {
            int updateResult = new forumDaoImpl().editForumInfo(forum);
            request.setAttribute("updateResult", updateResult);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("isManager", isManager);
        request.getRequestDispatcher("/pages/manage/main.jsp").forward(request, response);


    }
}