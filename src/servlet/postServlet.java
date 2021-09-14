package servlet;

import bbs.dao.impl.postDaoImpl;
import bbs.dao.impl.sectionDaoImpl;
import bbs.entity.Post;
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
            postDaoImpl dao = new postDaoImpl();
            Post post = dao.getPostInfoByPostId(Integer.parseInt(postId));
            request.setAttribute("post",post);
            request.getRequestDispatcher("/pages/section.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}