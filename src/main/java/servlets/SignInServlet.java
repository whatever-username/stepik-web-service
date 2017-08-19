package servlets;

import accounts.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Innokentiy on 18.08.2017.
 */
public class SignInServlet extends HttpServlet {
    private AccountService accountService;
    public SignInServlet(AccountService accountService){
        this.accountService = accountService;
    }

    //sign up
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if ((login == null) || (password == null)){
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        if ((accountService.getUserByLogin(login)!=null) && (accountService.getUserByLogin(login).getPass().equals(password))){
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("Authorized: "+ login);
            response.setStatus(HttpServletResponse.SC_OK);

        }else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("Unathorized");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }




}
