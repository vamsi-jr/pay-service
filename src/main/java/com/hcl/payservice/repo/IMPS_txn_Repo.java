package com.hcl.payservice.repo;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.hcl.payservice.model.IMPSTransfer;

public interface IMPS_txn_Repo extends CrudRepository<IMPSTransfer, Object> {

	//Testing Named Query
	@Query("select * from IMPSTransfer a where a.benificary_name = ?1")
	public IMPSTransfer findBybenificary_name(String benficaryName);
	
	//For custom sorting using Sort class 
	@Query("select u from User u where u.lastname like ?1%")
	  List<IMPSTransfer> findByAndSort(String lastname, Sort sort);
	
	//Using named Parameters
	@Query("select u from User u where u.firstname = :firstname or u.lastname = :lastname")
	IMPSTransfer findByLastnameOrFirstname(@Param("lastname") String lastname,
	                                 @Param("firstname") String firstname);
	
	//Using SpEL Expressions
	@Query("select u from #{#entityName} u where u.lastname = ?1")
	  List<IMPSTransfer> findByLastname(String lastname);
	
	
}
