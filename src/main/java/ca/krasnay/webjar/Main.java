package ca.krasnay.webjar;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;


public class Main {

    public static void main(String[] args) throws Exception {

        ConsoleAppender appender = new ConsoleAppender(new PatternLayout("%d %-5p [%t] [%c] %m%n"));
        BasicConfigurator.configure(appender);

        Logger rootLogger = Logger.getRootLogger();
        rootLogger.addAppender(appender);
        rootLogger.setLevel(Level.INFO);

        Logger springLogger = Logger.getLogger("ca.krasnay.webjar");
        springLogger.setLevel(Level.DEBUG);
        springLogger.setAdditivity(true);

        Logger log = Logger.getLogger(Main.class);
        log.info("=== WebJar Application ===");


        Server server = new Server(8888);
        server.setStopAtShutdown(true);

        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS|ServletContextHandler.NO_SECURITY);
        handler.addServlet(HelloServlet.class, "/*");
        server.setHandler(handler);

        server.start();
        server.join();

    }
}
