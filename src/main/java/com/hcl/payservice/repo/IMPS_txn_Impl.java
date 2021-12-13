package com.hcl.payservice.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.payservice.model.IMPSTransfer;

@Repository
public class IMPS_txn_Impl {

	@Autowired
	IMPS_txn_Repo imps_txn_Repo;

	public IMPSTransfer save_imps_data(IMPSTransfer impsTransfer) {
		IMPSTransfer res = imps_txn_Repo.save(impsTransfer);
		return res;
	}

	public String delete_pending_txns(long orderId) {
		imps_txn_Repo.deleteById(orderId);
		return "Successfully deleted Record";
	}

	public List<IMPSTransfer> fetchAllIMPS_txns() {

		List<IMPSTransfer> imps_txn_list = new ArrayList<IMPSTransfer>();
		imps_txn_Repo.findAll().forEach(obj -> imps_txn_list.add(obj));

		return imps_txn_list;
	}

	@SuppressWarnings("null")
	public IMPSTransfer fetchMyTxnDetails(long orderID) {

		IMPSTransfer res = null;

		Optional<IMPSTransfer> imps_obj = imps_txn_Repo.findById(orderID);
		if (imps_obj.isPresent()) {
			res = imps_obj.get();
		} else {
//			res.setAmount(0.00);
			res.setBenificary_account_number("NA");
			res.setBenificary_bank("NA");
			res.setBenificary_ifsc("NA");
			res.setBenificary_name("NA");
			res.setOrderId(0);
			res.setNeft_intiated_date(null);
		}

		return res;

	}

}
