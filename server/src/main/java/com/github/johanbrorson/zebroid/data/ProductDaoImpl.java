package com.github.johanbrorson.zebroid.data;

import com.github.johanbrorson.zebroid.DataClient;
import com.github.johanbrorson.zebroid.JedisClient;
import com.github.johanbrorson.zebroid.SpotifyUrl;
import com.github.johanbrorson.zebroid.configuration.ConfigurationHelper;

public class ProductDaoImpl implements ProductDao {
  private DataClient client;

  public ProductDaoImpl() {
    client = new JedisClient();
  }

  @Override
  public String getUrl(String key) {
    return SpotifyUrl.getUrl(client.getValue(key)
        .orElse(ConfigurationHelper.getDefaultPath()));
  }

  @Override
  public String getRandomUrl() {
    return SpotifyUrl.getUrl(client.getRandomValue()
        .orElse(ConfigurationHelper.getDefaultPath()));
  }

  @Override
  public boolean exists(String key) {
    return client.exists(key);
  }

  @Override
  public String getInfo() {
    return client.info();
  }
}
