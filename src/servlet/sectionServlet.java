package servlet;
import bbs.dao.impl.postDaoImpl;
import bbs.dao.impl.sectionDaoImpl;
import bbs.entity.Section;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/section")
public class sectionServlet extends HttpServlet {

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        String sectionId = request.getParameter("sectionId");
        String page = request.getParameter("page");

        try {
            postDaoImpl dao = new postDaoImpl();
            int pageSum = dao.getPageSum();
            Section section = new sectionDaoImpl().getSectionInfoBySectionId(Integer.parseInt(sectionId));
            List postList = dao.getAllPost(Integer.parseInt(sectionId),Integer.parseInt(page));
            request.setAttribute("pageSum",pageSum);
            request.setAttribute("postList",postList);
            request.setAttribute("sectionName",section.getName());
            request.setAttribute("sectionId",sectionId);
            request.setAttribute("page",page);
            request.getRequestDispatcher("/pages/section.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}