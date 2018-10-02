package com.github.johanbrorson.zebroid;

import java.net.MalformedURLException;
import java.net.URL;

import com.github.johanbrorson.zebroid.configuration.ConfigurationHelper;

public class SpotifyUrl {

  public static String getUrl(String path) {
    final String baseUrl = ConfigurationHelper.getBaseUrl();
    try {
      URL url = new URL(baseUrl);
      return new URL(url, path).toString();
    } catch (MalformedURLException e) {
      return baseUrl;
    }
  }

}
