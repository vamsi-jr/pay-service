package com.hcl.payservice.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.payservice.model.UPIAccount;

@Repository
public class DemoRepository {

	@Autowired
	UPIAccountRepo accountRepo;

	public UPIAccount getMyDetails(long id) {

		Optional<UPIAccount> upi_obj = accountRepo.findById(id);
		UPIAccount upi_obj1 = upi_obj.get();
		return upi_obj1;

	}

	public List<UPIAccount> getAllAccountDetails() {

		List<UPIAccount> upi_accounts = new ArrayList<UPIAccount>();
		accountRepo.findAll().forEach(upi_obj -> upi_accounts.add(upi_obj));
		return upi_accounts;

	}

	public void saveData(UPIAccount upi_obj) {

		UPIAccount obj = accountRepo.save(upi_obj);
		System.out.println(obj);

	}

	public int deleteAccount(String mobileNumber) {

		int out = accountRepo.deleteByMobileNumber(mobileNumber);
		return out;

	}

}
