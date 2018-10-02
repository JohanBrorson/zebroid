package com.github.johanbrorson.zebroid.utils;

import com.github.johanbrorson.zebroid.utils.PropertyHelper;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PropertyHelperTest {

  @Test
  public void shouldHaveValidPropertyWhenPropertyIsNotEmpty() {
    System.setProperty("propertyhelper.valid", "1");
    Assert.assertTrue(PropertyHelper.isValid("propertyhelper.valid"),
        "The property is expected to valid");
    Assert.assertEquals(PropertyHelper.getProperty("propertyhelper.valid"), "1",
        "The value of the property is incorrect");
  }

  @Test
  public void shouldHaveInvalidPropertyWhenPropertyIsEmpty() {
    System.setProperty("propertyhelper.empty", "");
    Assert.assertFalse(PropertyHelper.isValid("propertyhelper.empty"),
        "The property was valid even though it is empty");
  }

  @Test
  public void shouldHaveInvalidPropertyWhenPropertyDoesNotExist() {
    Assert.assertFalse(PropertyHelper.isValid("propertyhelper.notexist"),
        "The property was valid even though it doesn't exist");
  }

}
