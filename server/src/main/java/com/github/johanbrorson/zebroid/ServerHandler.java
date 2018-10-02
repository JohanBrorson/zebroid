package com.github.johanbrorson.zebroid;

import java.lang.invoke.MethodHandles;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServerHandler {
  private static final Logger logger = LoggerFactory.getLogger(
      MethodHandles.lookup().lookupClass());
  private final int port;
  private Server server;
  private ServletContextHandler context;

  public ServerHandler(int port) {
    this.port = port;
  }

  public void start() throws Exception {
    context = new ServletContextHandler(ServletContextHandler.SESSIONS);
    context.setContextPath("/");

    server = new Server(port);
    server.setHandler(context);

    ServletHolder servlet = context.addServlet(
        org.glassfish.jersey.servlet.ServletContainer.class, "/*");
    servlet.setInitOrder(0);

    servlet.setInitParameter(
        "jersey.config.server.provider.classnames",
        BarcodeService.class.getCanonicalName());

    try {
      logger.info("Start server on port {}", port);
      server.start();
      server.join();
    } catch (Exception e) {
      logger.error("Failed to start server", e);
    } finally {
      server.destroy();
    }
  }
}
