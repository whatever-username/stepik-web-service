import accounts.AccountService;
import accounts.UserProfile;
import dbService.DBException;
import dbService.DBService;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.*;

import javax.servlet.Servlet;

/**
 * Created by Innokentiy on 15.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        DBService dbService = new DBService();
        dbService.printConnectInfo();


        AccountService accountService = new AccountService();
        Server server = new Server(8080);
        Servlet mainSerlvet = new MainServlet(accountService);
        Servlet task1Servlet = new Task1Servlet();


        accountService.addNewUser(new UserProfile("admin"));
        accountService.addNewUser(new UserProfile("test"));


        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);

        contextHandler.addServlet(new ServletHolder(mainSerlvet),"/*");
        contextHandler.addServlet(new ServletHolder(task1Servlet),"/mirror");
        contextHandler.addServlet(new ServletHolder(new SignInServlet(accountService)),"/signin");
        contextHandler.addServlet(new ServletHolder(new SignUpServlet(accountService)),"/signup");
        contextHandler.addServlet(new ServletHolder(new UserServlet(accountService)), "/api/v1/users");
        contextHandler.addServlet(new ServletHolder(new SessionServlet(accountService)), "/api/v1/sessions");
        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("src/main/resources/public_html");
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler,contextHandler});
        server.setHandler(handlers);
        try {
            server.start();
            System.out.println("Server started");
            server.join();
        }catch (InterruptedException ie){

        }catch (Exception e){

        }
    }
}
