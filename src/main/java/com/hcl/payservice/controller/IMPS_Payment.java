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
import com.hcl.payservice.model.IMPSTransfer;
import com.hcl.payservice.service.IMPS_Service;


@RestController
@RequestMapping("/hdfc-bank/impspayment-services")
public class IMPS_Payment {

	@Autowired
	IMPS_Service imps_service;

	@RequestMapping(value = "/intiatePayment", method = RequestMethod.POST)
	public ResponseEntity<String> sendMoney(@RequestBody IMPSTransfer imps_obj) {

		String res = imps_service.sendMoney(imps_obj);
		return new ResponseEntity<String>(res, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/fetchByOrderId/{orderId}", method = RequestMethod.GET)
	public ResponseEntity<Object> fetchByOrderId(@PathVariable("orderId") long orderId) {

		IMPSTransfer out = imps_service.fetch_dtls_byId(orderId);
		return new ResponseEntity<Object>(out, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/fetchAllTxns", method = RequestMethod.GET)
	public ResponseEntity<Object> ftechAll_txns() {

		List<IMPSTransfer> imps_all_list = imps_service.fetchNeft_txn_details();
		return new ResponseEntity<Object>(imps_all_list, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/cancelPayment/{orderId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> cancel_payment(@PathVariable("orderId") long orderId) {

		String res = imps_service.delete_pending_txns(orderId);
		return new ResponseEntity<Object>(res, HttpStatus.ACCEPTED);
	}

}
