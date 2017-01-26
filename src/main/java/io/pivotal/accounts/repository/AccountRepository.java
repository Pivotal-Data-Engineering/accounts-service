package io.pivotal.accounts.repository;

import io.pivotal.accounts.domain.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by cdelashmutt@pivotal.io on 1/25/2017.
 */
public interface AccountRepository extends CrudRepository<Account,String> {
	public Account findByUseridAndPasswd(String userId, String passwd);
	public Account findByUserid(String userId);
	public Account findByAuthtoken(String authtoken);
}
