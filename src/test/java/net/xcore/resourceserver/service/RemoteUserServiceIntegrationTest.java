package net.xcore.resourceserver.service;

import lombok.extern.java.Log;
import lombok.val;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Log
public class RemoteUserServiceIntegrationTest {

  @Autowired
  RemoteUserService remoteUserService;

  @Test
  public void test() {
    val user = remoteUserService.getUser("testuser");
    log.info("Got user: " + user);
  }

}
