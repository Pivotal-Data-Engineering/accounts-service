package io.pivotal.accounts.config.data;

import com.gemstone.gemfire.cache.GemFireCache;
import com.gemstone.gemfire.cache.client.ClientCache;
import com.gemstone.gemfire.cache.client.ClientRegionShortcut;
import com.gemstone.gemfire.pdx.ReflectionBasedAutoSerializer;
import io.pivotal.accounts.domain.Account;
import io.pivotal.spring.cloud.service.gemfire.GemfireServiceConnectorConfig;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.gemfire.client.ClientRegionFactoryBean;

/**
 * Created by cdelashmutt@pivotal.io on 1/25/2017.
 */
@Configuration
@Profile("gemfire-cloud")
public class GemfireCloudConfig extends AbstractCloudConfig {

	@Bean
	ClientCache myClientCache() {
		GemfireServiceConnectorConfig config = new GemfireServiceConnectorConfig();
		config.setPdxReadSerialized(false);
		config.setPdxSerializer(new ReflectionBasedAutoSerializer("io.pivotal.accounts.domain.*"));
		return cloud().getSingletonServiceConnector(ClientCache.class, config);
	}

	@Bean
	ClientRegionFactoryBean<String, Account> accountRegion(final ClientCache cache) {
		ClientRegionFactoryBean<String, Account> accountRegion = new ClientRegionFactoryBean<>();
		accountRegion.setCache(cache);
		accountRegion.setName("Account");
		accountRegion.setShortcut(ClientRegionShortcut.PROXY);
		return accountRegion;
	}
}
