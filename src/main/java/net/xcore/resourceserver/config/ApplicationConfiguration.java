package net.xcore.resourceserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.core.cql.CqlTemplate;
import org.springframework.data.cassandra.core.cql.session.DefaultSessionFactory;

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

  @Bean
  public CqlTemplate cqlTemplate() {
    CqlTemplate template = new CqlTemplate();
    template.setSessionFactory(new DefaultSessionFactory(session().getObject()));
    return template;
  }
}
