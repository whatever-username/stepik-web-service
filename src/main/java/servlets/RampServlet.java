package servlets;

import templater.PageGenerator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Innokentiy on 16.07.2017.
 */
public class RampServlet extends HttpServlet implements IServlet {
    private String login = "";
    String html =
            "" +
            "";
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        RequestDispatcher view = request.getRequestDispatcher("calculator.html");
        view.forward(request, response);
        response.setContentType("text/html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        RequestDispatcher view = request.getRequestDispatcher("calculator.html");
        view.forward(request, response);
        response.setContentType("text/html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
