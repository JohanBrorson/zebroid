package com.github.johanbrorson.zebroid.configuration;

import java.io.File;
import java.lang.invoke.MethodHandles;
import java.net.URL;

import com.github.johanbrorson.zebroid.utils.PropertyHelper;

import org.apache.commons.configuration2.CombinedConfiguration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.SystemConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.FileBasedBuilderParameters;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.convert.DefaultListDelimiterHandler;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.tree.OverrideCombiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Configuration {
  private static final String PROPERTIES_FILE_NAME = "server.properties";
  private static final Logger logger =
      LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
  private static Configuration instance;
  private PropertiesConfiguration config = new PropertiesConfiguration();

  private Configuration() throws ConfigurationException {
    CombinedConfiguration combinedConfig = new CombinedConfiguration();
    combinedConfig.setNodeCombiner(new OverrideCombiner());
    combinedConfig.addConfiguration(new SystemConfiguration());
    if (getOverrideFile().exists()) {
      combinedConfig.addConfiguration(
          getFileBasedConfiguration(getOverrideFileBasedBuilderParameters()));
    }
    combinedConfig.addConfiguration(
        getFileBasedConfiguration(getDefaultFileBasedBuilderParameters()));

    config.append(combinedConfig);
  }

  /**
   * Gets a instance of the Configuration class.
   *
   * @return The Configuration instance
   * @throws ConfigurationException Failed to initialize a Configuration object
   */
  public static Configuration getInstance() throws ConfigurationException {
    if (Configuration.instance == null) {
      Configuration.instance = new Configuration();
    }
    return Configuration.instance;
  }

  private FileBasedConfiguration getFileBasedConfiguration(
      FileBasedBuilderParameters builderParams) throws ConfigurationException {
    FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
        new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
            .configure(builderParams.setListDelimiterHandler(new DefaultListDelimiterHandler(',')));
    return builder.getConfiguration();
  }

  private FileBasedBuilderParameters getOverrideFileBasedBuilderParameters() {
    return new Parameters().fileBased().setFile(getOverrideFile());
  }

  private File getOverrideFile() {
    final String configFileProperty = "zebroid.configuration";

    // Check if the properties file location has been set in system property,
    // otherwise use properties file in working directory
    if (PropertyHelper.isValid(configFileProperty)) {
      String fileLocation = PropertyHelper.getProperty(configFileProperty);
      logger.debug("Use properties file set by system property: " + fileLocation);
      return new File(fileLocation);
    } else {
      return new File(PropertyHelper.getProperty("user.dir"), PROPERTIES_FILE_NAME);
    }
  }

  private FileBasedBuilderParameters getDefaultFileBasedBuilderParameters() {
    URL defaultProperties = getClass().getClassLoader().getResource(PROPERTIES_FILE_NAME);
    return new Parameters().fileBased().setURL(defaultProperties);
  }

  /**
   * Gets a string associated with the given configuration key. The default value is returned, if
   * the key doesn't map to an existing object.
   *
   * @param propertyKey The configuration key
   * @param defaultValue The default value
   * @return String with the value of the key
   */
  public String getString(final String propertyKey, String defaultValue) {
    return config.getString(propertyKey, defaultValue);
  }

  /**
   * Gets an integer associated with the given configuration key.
   *
   * @param propertyKey The configuration key
   * @return Integer with the value of the key
   */
  public Integer getInteger(final String propertyKey, final Integer defaultValue) {
    return config.getInteger(propertyKey, defaultValue);
  }

}
