package servlets;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Innokentiy on 19.07.2017.
 */
public class Task1Servlet extends HttpServlet implements IServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String[]> parametersMap = request.getParameterMap();
        if (parametersMap.containsKey("key")){
            String[] values = parametersMap.get("key");
            for (int i = 0; i < values.length; i++) {
                response.getWriter().println(values[i]);
                response.setContentType("text/html; charset=utf-8");
                response.setStatus(HttpServletResponse.SC_OK);
            }
        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private static void printKeyValue(HttpServletRequest request){
        Map<String,String[]> parametersMap = request.getParameterMap();
        for (Map.Entry<String,String[]> entry : parametersMap.entrySet()){
            for (int i = 0; i < entry.getValue().length; i++) {
                System.out.println(entry.getKey() + " - " + entry.getValue()[i]);

            }
        }
    }
}
