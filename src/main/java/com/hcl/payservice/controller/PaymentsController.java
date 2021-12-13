package com.hcl.payservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.payservice.model.UPIAccount;
import com.hcl.payservice.service.UPIService;

@RestController
@RequestMapping("/hdfc-bank/upi/payment-services")
public class PaymentsController {

	@Autowired
	UPIService upiService;

	@RequestMapping(value = "/getDetails/{mobileNumber}", method = RequestMethod.GET)
	public ResponseEntity<Object> getMyDetails(@PathVariable("mobileNumber") long id) {

		UPIAccount upi_obj = upiService.getUPIDetails(id);

		return new ResponseEntity<Object>(upi_obj, HttpStatus.OK);

	}

	@RequestMapping(value = "/getAllAccouuntDetails", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllAccounts() {

		List<UPIAccount> upi_obj = upiService.getAllAccounts();

		return new ResponseEntity<Object>(upi_obj, HttpStatus.OK);

	}

	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public ResponseEntity<Object> createMyAccount(@RequestBody UPIAccount upi_accAccount) {

		upiService.saveDetails(upi_accAccount);

		return new ResponseEntity<Object>("UPI Account Created Successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateMyDetails() {

		return null;

	}

	@RequestMapping(value = "/deleteAccount/{mobileNumber}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteMyDetails(@PathVariable("mobileNumber") String mobileNumber) {

		int res = upiService.deleteMyAccount(mobileNumber);

		return new ResponseEntity<Object>("total " + res + "record's found, Your Account details will be removed soon",
				HttpStatus.OK);
	}

}
