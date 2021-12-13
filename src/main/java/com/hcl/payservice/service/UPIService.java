package com.hcl.payservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.payservice.model.UPIAccount;
import com.hcl.payservice.repo.DemoRepository;

@Service
public class UPIService {

	@Autowired
	DemoRepository demoRepository;

	public UPIAccount getUPIDetails(long id) {

		UPIAccount obj1 = demoRepository.getMyDetails(id);
		return obj1;

	}
	
	
	public List<UPIAccount> getAllAccounts() {
		List<UPIAccount> upi_dtls =  demoRepository.getAllAccountDetails();
		return upi_dtls;
		
	}
	

	public String saveDetails(UPIAccount upi_acc) {

		demoRepository.saveData(upi_acc);

		return "Account Created Successfully";

	}

	public int deleteMyAccount(String mobileNumber) {
		
		int out = demoRepository.deleteAccount(mobileNumber);
		return out;

	}

}
