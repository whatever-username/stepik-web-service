package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Innokentiy on 18.08.2017.
 */
public class SignUpServlet extends HttpServlet {
    private AccountService accountService;
    public SignUpServlet(AccountService accountService){
        this.accountService = accountService;
    }
    public void doPost(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if ((login == null) || (password == null)){
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        UserProfile userProfile = new UserProfile(login, password, "");
        accountService.addNewUser(userProfile);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
