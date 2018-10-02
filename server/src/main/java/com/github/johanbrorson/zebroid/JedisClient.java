package com.github.johanbrorson.zebroid;

import java.util.Optional;

import com.github.johanbrorson.zebroid.configuration.ConfigurationHelper;

import redis.clients.jedis.Jedis;

public class JedisClient implements DataClient {

  private Jedis jedis;

  public JedisClient() {
    jedis = new Jedis(ConfigurationHelper.getDatabaseHost());
  }

  @Override
  public Optional<String> getRandomValue() {
    return getValue(jedis.randomKey());
  }

  @Override
  public Optional<String> getValue(String key) {
    if (null != key) {
      return Optional.ofNullable(jedis.get(key));
    } else {
      return Optional.empty();
    }
  }

  @Override
  public boolean exists(String key) {
    return jedis.exists(key);
  }

  @Override
  public String info() {
    return jedis.info();
  }
}
