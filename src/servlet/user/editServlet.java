package servlet.user;

import bbs.dao.impl.postDaoImpl;
import bbs.dao.impl.userDaoImpl;
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

@WebServlet("/edit")
public class editServlet extends HttpServlet {

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
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if (cookie.getName().equals("userId")) {
                    loginState = 1;
                    userId = cookie.getValue();
                }
            }
        }
        String nickname = request.getParameter("nickname");
        String signature = request.getParameter("signature");
        User user = new User();
        user.setNickname(nickname);
        user.setSignature(signature);
        user.setUserId(Integer.valueOf(userId));
        try {
            int updateResult = new userDaoImpl().editUserInfo(user);
            request.setAttribute("updateResult", updateResult);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("userId", userId);
        request.setAttribute("state", loginState);
        request.getRequestDispatcher("/pages/edit.jsp").forward(request, response);


    }
}