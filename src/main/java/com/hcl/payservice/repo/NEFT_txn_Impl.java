package com.hcl.payservice.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.payservice.model.NEFTTransfer;

@Repository
public class NEFT_txn_Impl {

	@Autowired
	NEFT_Txn_Repo neft_Txn_Repo;

	public NEFTTransfer save_neft_data(NEFTTransfer neft_obj) {
		NEFTTransfer res = neft_Txn_Repo.save(neft_obj);
		return res;
	}

	public String delete_pending_txns(long orderId) {
		neft_Txn_Repo.deleteById(orderId);
		return "Successfully deleted Record";
	}

	public List<NEFTTransfer> fetchAllNEFT_txns() {

		List<NEFTTransfer> neft_txn_list = new ArrayList<NEFTTransfer>();
		neft_Txn_Repo.findAll().forEach(obj -> neft_txn_list.add(obj));

		return neft_txn_list;
	}

	@SuppressWarnings("null")
	public NEFTTransfer fetchMyTxnDetails(long orderID) {

		NEFTTransfer res = null;

		Optional<NEFTTransfer> neft_obj = neft_Txn_Repo.findById(orderID);
		if (neft_obj.isPresent()) {
			res = neft_obj.get();
		} else {
			res.setAmount(0.00);
			res.setBenificary_account_number("NA");
			res.setBenificary_bank("NA");
			res.setBenificary_ifsc("NA");
			res.setBenificary_name("NA");
			res.setId(0);
			res.setNeft_intiated_date(null);
		}

		return res;
		
	}

}
