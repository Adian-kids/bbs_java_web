package servlet.manage;

import bbs.dao.impl.managerDaoImpl;
import bbs.dao.impl.postDaoImpl;
import bbs.dao.impl.userDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/managerDeletePost")
public class managePostServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int loginState = 0;
            Cookie cookie = null;
            Cookie[] cookies = request.getCookies();
            String userId = null;
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

            String postId = request.getParameter("postId");
            int deleteResult = new postDaoImpl().deletePostByPostId(Integer.valueOf(postId));
            request.setAttribute("deleteResult", deleteResult);

            request.setAttribute("isManager", isManager);

            request.getRequestDispatcher("/pages/manage/main.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}