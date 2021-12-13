package com.hcl.payservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.payservice.model.IMPSTransfer;
import com.hcl.payservice.repo.IMPS_txn_Impl;

@Service
public class IMPS_Service {

	@Autowired
	IMPS_txn_Impl imps_txn_Impl;

	public String sendMoney(IMPSTransfer impsTransfer) {

		String res = "";
		double txn_amount = impsTransfer.getAmount();

		if (txn_amount > 0 && txn_amount < 5000000) {

			imps_txn_Impl.save_imps_data(impsTransfer);
			res = "IMPS Fund Transfer Intiated Successfully";

		} else {
			res = "IMPS Transaction Limit is Exceded";
		}

		return res;
	}

	public List<IMPSTransfer> fetchNeft_txn_details() {

		List<IMPSTransfer> imps_txns = imps_txn_Impl.fetchAllIMPS_txns();
		return imps_txns;

	}

	public String delete_pending_txns(long orderId) {

		String res = imps_txn_Impl.delete_pending_txns(orderId);
		return res;
	}

	public IMPSTransfer fetch_dtls_byId(long orderId) {

		IMPSTransfer user_neft_obj = imps_txn_Impl.fetchMyTxnDetails(orderId);
		return user_neft_obj;
	}

}
