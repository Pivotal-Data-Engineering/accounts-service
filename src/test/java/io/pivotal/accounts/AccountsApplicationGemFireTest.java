package io.pivotal.accounts;

import io.pivotal.accounts.config.SpringApplicationContextInitializer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by grog on 1/30/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = AccountsApplication.class)
@ContextConfiguration(initializers = SpringApplicationContextInitializer.class)
@WebAppConfiguration
@ActiveProfiles("gemfire")
public class AccountsApplicationGemFireTest {
	/**
	 * test loading of spring context.
	 */
	@Test
	public void contextLoads() {
	}
}
