package application;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.DefaultServlet;
import servlets.FindFruitByNameServlet;
import servlets.GetAllFruitsServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.addServlet(new ServletHolder(new DefaultServlet()), "/");
        context.addServlet(new ServletHolder(new GetAllFruitsServlet()), "/fruits");
        context.addServlet(new ServletHolder(new FindFruitByNameServlet()), "/fruit");

        Server jettyServer = new Server(4000);
        jettyServer.setHandler(context);

        try {
            jettyServer.start();
            jettyServer.join();
        } finally {
            jettyServer.destroy();
        }
    }
}
