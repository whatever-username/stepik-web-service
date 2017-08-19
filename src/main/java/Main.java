import accounts.AccountService;
import accounts.UserProfile;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.*;

import javax.servlet.Servlet;

/**
 * Created by Innokentiy on 15.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        Server server = new Server(8080);
        Servlet mainSerlvet = new MainServlet(accountService);
        Servlet task1Servlet = new Task1Servlet();


        accountService.addNewUser(new UserProfile("admin"));


        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(contextHandler);
        contextHandler.addServlet(new ServletHolder(mainSerlvet),"/*");
        contextHandler.addServlet(new ServletHolder(task1Servlet),"/mirror");
        contextHandler.addServlet(new ServletHolder(new SignInServlet(accountService)),"/signin");
        contextHandler.addServlet(new ServletHolder(new SignUpServlet(accountService)),"/signup");
        contextHandler.addServlet(new ServletHolder(new UserServlet(accountService)), "/api/v1/users");
        contextHandler.addServlet(new ServletHolder(new SessionServlet(accountService)), "/api/v1/sessions");
        try {
            server.start();
            System.out.println("Server started");
            server.join();
        }catch (InterruptedException ie){

        }catch (Exception e){

        }
    }
}
