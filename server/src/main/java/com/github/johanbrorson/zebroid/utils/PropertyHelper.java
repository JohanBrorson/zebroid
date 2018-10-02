package com.github.johanbrorson.zebroid.utils;

import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyHelper {
  private static final Logger logger = LoggerFactory.getLogger(
      MethodHandles.lookup().lookupClass());

  public static String getProperty(String key) {
    String value = System.getProperty(key);
    logger.debug("Property: '{}' = '{}'", key, value);
    return value;
  }

  public static boolean isValid(String key) {
    String value = getProperty(key);
    return !(null == value || value.isEmpty());
  }
}
