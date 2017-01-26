package io.pivotal.accounts.config.data;

import io.pivotal.accounts.repository.IdGenerator;
import io.pivotal.accounts.repository.NullIdGenerator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by grog on 1/25/2017.
 */
@Configuration
@Profile({"mysql", "in-memory"})
@EnableAutoConfiguration
@EnableJpaRepositories("io.pivotal.accounts.repository")
@EntityScan("io.pivotal.accounts.domain")
public class JPAConfig {

	@Bean
	IdGenerator entityidGenerator() {
		return new NullIdGenerator();
	}
}
