package net.xcore.resourceserver.service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;
import lombok.extern.java.Log;
import net.xcore.resourceserver.config.UserServiceConfig;
import net.xcore.resourceserver.rest.RemoteUser;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@EnableConfigurationProperties(UserServiceConfig.class)
@Log
public class RemoteUserService {

  @Autowired
  private UserServiceConfig userServiceConfig;

  public Optional<RemoteUser> getUser(String username) {
    String userUrl = userServiceConfig.getUrl() + "/user/testuser";
    ResponseEntity<RemoteUser> response = new RestTemplate().exchange(userUrl, HttpMethod.GET,
        new HttpEntity<>(createHeaders()), RemoteUser.class);

    if (response.getStatusCode().equals(HttpStatus.OK)) {
      return Optional.ofNullable(response.getBody());
    }
    return Optional.empty();
  }

  private HttpHeaders createHeaders() {
    return new HttpHeaders() {{
      String auth = userServiceConfig.getUser() + ':' + userServiceConfig.getPassword();
      byte[] encodedAuth = Base64.encodeBase64(
          auth.getBytes(StandardCharsets.US_ASCII));
      String authHeader = "Basic " + new String(encodedAuth, StandardCharsets.US_ASCII);
      set("Authorization", authHeader);
    }};
  }
}
