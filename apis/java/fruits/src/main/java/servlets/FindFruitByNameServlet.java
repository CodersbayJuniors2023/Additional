package servlets;

import controller.FruitManager;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.NoSuchElementException;

public class FindFruitByNameServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        String name = request.getParameter("name");
        try {
            String fruits = FruitManager.getFruitByNameJSON(name);
            response.setStatus(200);
            response.getWriter().println(fruits);
        } catch (NoSuchElementException e) {
            response.setStatus(404);
            response.getWriter().println("Not found");
        }
    }
}
