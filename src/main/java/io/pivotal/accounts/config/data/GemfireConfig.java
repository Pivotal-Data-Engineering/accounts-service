package io.pivotal.accounts.config.data;

import io.pivotal.accounts.repository.IdGenerator;
import io.pivotal.accounts.repository.gemfire.UUIDIdGenerator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

/**
 * Created by cdelashmutt@pivotal.io on 1/25/2017.
 */
@Configuration
@Profile("gemfire")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableGemfireRepositories("io.pivotal.accounts.repository")
public class GemfireConfig {

	@Bean
	IdGenerator entityidGenerator() {
		return new UUIDIdGenerator();
	}
}
