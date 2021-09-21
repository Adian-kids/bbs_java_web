package servlet;

import bbs.dao.impl.postDaoImpl;
import bbs.dao.impl.replyDaoImpl;
import bbs.dao.impl.userDaoImpl;
import bbs.entity.Post;
import bbs.entity.Reply;

import java.io.*;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/addReply")
public class addReplyServlet extends HttpServlet {

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
            String content = request.getParameter("content");
            String postId = request.getParameter("postId");
            Reply reply = new Reply();
            reply.setContent(content);
            reply.setUserId(Integer.valueOf(userId));
            reply.setPostId(Integer.valueOf(postId));

            int insertResult = new replyDaoImpl().addReply(reply);
            request.setAttribute("insertResult", insertResult);
            request.setAttribute("postId", postId);
            request.setAttribute("state", loginState);

            request.getRequestDispatcher("/pages/post.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}