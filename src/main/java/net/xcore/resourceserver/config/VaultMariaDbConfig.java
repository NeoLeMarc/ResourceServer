package net.xcore.resourceserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("resourceserver")
public class VaultConfig {
  private String mariaDbUsername;
  private String mariaDbPassword;
  private String mariaDbUrl;

  public String getMariaDbUsername() {
    return mariaDbUsername;
  }

  public void setMariaDbUsername(String mariaDbUsername) {
    this.mariaDbUsername = mariaDbUsername;
  }

  public String getMariaDbPassword() {
    return mariaDbPassword;
  }

  public void setMariaDbPassword(String mariaDbPassword) {
    this.mariaDbPassword = mariaDbPassword;
  }

  public String getMariaDbUrl() {
    return mariaDbUrl;
  }

  public void setMariaDbUrl(String mariaDbUrl) {
    this.mariaDbUrl = mariaDbUrl;
  }
}

