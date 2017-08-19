package servlets;

import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Innokentiy on 16.07.2017.
 */
public interface IServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException;

}
