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

import com.hcl.payservice.model.NEFTTransfer;
import com.hcl.payservice.service.NEFT_Service;

@RestController
@RequestMapping("/hdfc-bank/neftpayment-services")
public class NEFT_Payment {

	@Autowired
	NEFT_Service neftService;

	@RequestMapping(value = "/intiatePayment", method = RequestMethod.POST)
	public ResponseEntity<String> sendMoney(@RequestBody NEFTTransfer neft_obj) {

		String res = neftService.sendMoney(neft_obj);
		return new ResponseEntity<String>(res, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/fetchByOrderId/{orderId}", method = RequestMethod.GET)
	public ResponseEntity<Object> fetchByOrderId(@PathVariable("orderId") long orderId) {

		NEFTTransfer out = neftService.fetch_dtls_byId(orderId);
		return new ResponseEntity<Object>(out, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/fetchAllTxns", method = RequestMethod.GET)
	public ResponseEntity<Object> ftechAll_txns() {

		List<NEFTTransfer> neft_all_list = neftService.fetchNeft_txn_details();
		return new ResponseEntity<Object>(neft_all_list, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/cancelPayment/{orderId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> cancel_payment(@PathVariable("orderId") long orderId) {

		String res = neftService.delete_pending_txns(orderId);
		return new ResponseEntity<Object>(res, HttpStatus.ACCEPTED);
	}

}
