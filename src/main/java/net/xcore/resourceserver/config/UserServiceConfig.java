package net.xcore.resourceserver.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("userservice")
@Data
public class UserServiceConfig {
  private String url;
  private String user;
  private String password;
}
