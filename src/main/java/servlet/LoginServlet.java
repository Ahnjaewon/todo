package servlet;

import dao.UserDao;
import dto.LoginDto;
import dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/login.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        LoginDto loginUser = new LoginDto(username,password);
        UserDao userDao = new UserDao();
        boolean isLogin = userDao.login(loginUser);
        if(isLogin == true) {
            req.getRequestDispatcher("views/main.html").forward(req,resp);
        } else {
            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter out = resp.getWriter();
//            out.println("<script>" +
//                        "alert('입력된 계정정보가 없습니다. 다시 입력 해주세요. '); " +
//                        "location.href='/login';" +
//                        "</script>");
           out.println("<script> " +
                       "var returnValue = confirm('입력된 계정 정보가 없습니다. 회원가입하시겠습니까?'); " +
                       "if(returnValue) { " +
                       "    location.href='/user' " +
                       "} else { " +
                       "    location.href='/login'; " +
                       "} " +
                       "</script> ");
            out.flush();
            out.close();
            req.getRequestDispatcher("views/login.html").forward(req,resp);
        }
    }
}
