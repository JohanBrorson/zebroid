package com.github.johanbrorson.zebroid.configuration;

public enum ConfigurationKeys {

  DATABASE_HOST("database.host", "localhost"),
  SERVER_PORT("server.port", 8080),
  URL_PATH_DEFAULT("url.path.default", "user/jbrorson/playlist/3LOBSAJ3zNjxkqo2w6dpAY"),
  URL_BASE("url.base", "https://open.spotify.com");

  private final String key;
  private final Object defaultValue;

  ConfigurationKeys(String key, Object defaultValue) {
    this.key = key;
    this.defaultValue = defaultValue;
  }

  public String getKey() {
    return key;
  }

  public Object getDefaultValue() {
    return defaultValue;
  }

}
