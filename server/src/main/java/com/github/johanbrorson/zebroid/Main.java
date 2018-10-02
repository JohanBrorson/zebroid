package com.github.johanbrorson.zebroid;

import com.github.johanbrorson.zebroid.configuration.ConfigurationHelper;

public class Main {

  public static void main(String[] args) throws Exception {
    ServerHandler serverHandler = new ServerHandler(ConfigurationHelper.getServerPort());
    serverHandler.start();
  }

}
