package com.github.johanbrorson.zebroid;

import java.util.Optional;

public interface DataClient {

  public boolean exists(String key);
  public Optional<String> getValue(String key);
  public Optional<String> getRandomValue();
  public String info();

}
