package com.coveros.feedback.event;

import javax.sql.DataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@MapperScan("com.coveros.feedback.event")
public class EventPersistenceTestConfig extends PersistenceConfig {

  @Bean
  public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.H2)
        .addScript("event-schema.sql")
        .addScript("event-test-data.sql")
        .build();
  }
}
