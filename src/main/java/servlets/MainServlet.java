package servlets;
import accounts.AccountService;
import templater.PageGenerator;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Innokentiy on 15.07.2017.
 */
public class MainServlet extends HttpServlet implements IServlet{
    private String login = "";
    private AccountService accountService;
    public MainServlet(AccountService accountService){
        this.accountService = accountService;
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Map<String, Object> pageVariables = createPageVariableMap(request);
        pageVariables.put("message","");
        response.getWriter().println(PageGenerator.getPageGenerator().getPage("index.html",pageVariables));
        response.setContentType("text/html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        Map<String, Object> pageVariables = createPageVariableMap(request);
        String message = request.getParameter("message");
        pageVariables.put("message",message);
        response.getWriter().println(PageGenerator.getPageGenerator().getPage("index.html",pageVariables));
        response.setContentType("text/html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }
    private static Map createPageVariableMap (HttpServletRequest request){
        Map<String, Object> pageVariables= new HashMap<String, Object>();

        pageVariables.put("method",request.getMethod());
        pageVariables.put("URL",request.getRequestURL().toString());


        return pageVariables;
    }
}
