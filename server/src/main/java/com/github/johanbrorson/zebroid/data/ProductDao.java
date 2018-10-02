package com.github.johanbrorson.zebroid.data;

public interface ProductDao {

  public boolean exists(String key);
  public String getUrl(String key);
  public String getRandomUrl();
  public String getInfo();

}
