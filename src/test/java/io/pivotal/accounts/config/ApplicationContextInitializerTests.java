package io.pivotal.accounts.config;

import io.pivotal.accounts.AccountsApplication;
import io.pivotal.spring.cloud.service.common.GemfireServiceInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.cloud.Cloud;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by cdelashmutt@pivotal.io on 1/30/2017.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = AccountsApplication.class)
public class ApplicationContextInitializerTests {

	@Mock
	ConfigurableApplicationContext context;

	@Mock
	ConfigurableEnvironment env;

	@Mock
	Cloud cloud;

	SpringApplicationContextInitializer initializer;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		when(context.getEnvironment()).thenReturn(env);
		initializer = new SpringApplicationContextInitializer();
	}

	@Test
	public void defaultToInMemory(){
		when(env.getActiveProfiles()).thenReturn(new String[]{});
		initializer.initialize(context);
		verify(env).addActiveProfile("in-memory");
	}

	/*
	@Test
	public void cloudProfileSelectsGemFire(){
		System.setProperty("spring.cloud.appId", "account-service");
		System.setProperty("spring.cloud.traderdb", "gemfire://1.2.3.4:10100/");
		when(env.getActiveProfiles()).thenReturn(new String[]{});
		when(cloud.getServiceInfos()).thenReturn(
				Arrays.asList(
						new GemfireServiceInfo("traderdb", (List<String>) Arrays.asList("1.2.3.4[10100]"))
				)
		);
		initializer.initialize(context);
		verify(env).addActiveProfile("gemfire");
		verify(env).addActiveProfile("gemfire-cloud");
	}
	*/
}
