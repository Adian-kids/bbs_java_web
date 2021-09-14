package servlet;

import bbs.dao.impl.classifyDaoImpl;
import bbs.dao.impl.forumDaoImpl;
import bbs.dao.impl.sectionDaoImpl;
import bbs.dao.impl.postDaoImpl;
import bbs.entity.Classify;
import bbs.entity.Forum;
import bbs.entity.Post;
import bbs.entity.Section;


import java.io.*;
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
            forumDaoImpl dao = new forumDaoImpl();
            Forum forum = dao.getForumInfo();
            List<Classify> allClassify = new classifyDaoImpl().getAllClassifyInfo();
            List<Section> allSection = new sectionDaoImpl().getAllSection();
            List<Post> top10Post = new postDaoImpl().getTop10Post();
            request.setAttribute("classifyList",allClassify);
            request.setAttribute("sectionList",allSection);
            request.setAttribute("postList",top10Post);




            request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}