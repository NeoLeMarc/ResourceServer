package net.xcore.resourceserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;

@Configuration
public class ApplicationConfiguration {

  @Bean
  public CqlSessionFactoryBean session() {
    CqlSessionFactoryBean session = new CqlSessionFactoryBean();
    session.setContactPoints("cassandra01.kubernetes.ka.xcore.net");
    session.setKeyspaceName("resourceserver");
    session.setLocalDatacenter("datacenter1");
    return session;
  }
}
