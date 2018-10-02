package com.github.johanbrorson.zebroid.configuration;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigurationHelper {
  private static final Logger logger =
      LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  public static String getDatabaseHost() {
    return getStringProperty(ConfigurationKeys.DATABASE_HOST);
  }

  public static int getServerPort() {
    return getIntegerProperty(ConfigurationKeys.SERVER_PORT);
  }

  public static String getBaseUrl() {
    return getStringProperty(ConfigurationKeys.URL_BASE);
  }

  public static String getDefaultPath() {
    return getStringProperty(ConfigurationKeys.URL_PATH_DEFAULT);
  }

  private static String getStringProperty(ConfigurationKeys property) {
    String key = property.getKey();
    String defaultValue = (String) property.getDefaultValue();
    String value;
    try {
      value = Configuration.getInstance().getString(key, defaultValue);
    } catch (Exception e) {
      logger.warn("Failed to get property, use default value");
      value = defaultValue;
    }
    return value;
  }

  private static int getIntegerProperty(ConfigurationKeys property) {
    String key = property.getKey();
    int defaultValue = (int) property.getDefaultValue();
    int value;
    try {
      value = Configuration.getInstance().getInteger(key, defaultValue);
    } catch (Exception e) {
      logger.warn("Failed to get property, use default value");
      value = defaultValue;
    }
    return value;
  }

}
