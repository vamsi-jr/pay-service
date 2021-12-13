package com.hcl.payservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.payservice.model.NEFTTransfer;
import com.hcl.payservice.repo.NEFT_txn_Impl;

@Service
public class NEFT_Service {

	@Autowired
	NEFT_txn_Impl neft_impl;

	public String sendMoney(NEFTTransfer neft_obj) {

		String res = "";
		double txn_amount = neft_obj.getAmount();

		if (txn_amount > 0 && txn_amount < 2000000) {

			neft_impl.save_neft_data(neft_obj);
			res = "Neft Fund Transfer Intiated Successfully";

		} else {
			res = "NEFT Transaction Limit is Exceded";
		}

		return res;
	}

	public List<NEFTTransfer> fetchNeft_txn_details() {

		List<NEFTTransfer> neft_txns = neft_impl.fetchAllNEFT_txns();
		return neft_txns;

	}

	public String delete_pending_txns(long orderId) {

		String res = neft_impl.delete_pending_txns(orderId);
		return res;
	}

	public NEFTTransfer fetch_dtls_byId(long orderId) {

		NEFTTransfer user_neft_obj = neft_impl.fetchMyTxnDetails(orderId);
		return user_neft_obj;
	}

}
