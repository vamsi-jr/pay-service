package com.hcl.payservice.repo;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import com.hcl.payservice.model.UPIAccount;

public interface UPIAccountRepo extends CrudRepository<UPIAccount, Object>
{

	@Transactional
	public int deleteByMobileNumber(String str);
	
	
}
