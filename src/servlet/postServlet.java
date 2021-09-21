package servlet;

import bbs.dao.impl.postDaoImpl;
import bbs.dao.impl.sectionDaoImpl;
import bbs.dao.impl.userDaoImpl;
import bbs.entity.Post;
import bbs.entity.Reply;
import bbs.entity.Section;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/post")
public class postServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {

        String postId = request.getParameter("postId");

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

            // 获取帖子内容
            postDaoImpl dao = new postDaoImpl();
            Post post = dao.getPostInfoByPostId(Integer.parseInt(postId));
            // 获取回复信息
            List<Reply> allReply = dao.getAllReplyInfo(Integer.parseInt(postId));
            request.setAttribute("post", post);
            request.setAttribute("allReply", allReply);
            request.setAttribute("state", loginState);
            request.getRequestDispatcher("/pages/post.jsp").forward(request, response);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}