/**
 * 
 */
package com.farkalit.webdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farkalit.webdemo.model.Paycontract;
import com.farkalit.webdemo.model.PaycontractId;


/**
 * @author farkalitusman
 *
 */
@Repository
public interface PaycontractRepository extends JpaRepository<Paycontract, PaycontractId> {

}
