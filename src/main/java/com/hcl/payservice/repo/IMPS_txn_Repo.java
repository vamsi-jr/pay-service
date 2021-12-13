package com.hcl.payservice.repo;

import org.springframework.data.repository.CrudRepository;

import com.hcl.payservice.model.IMPSTransfer;

public interface IMPS_txn_Repo extends CrudRepository<IMPSTransfer, Object> {

}
