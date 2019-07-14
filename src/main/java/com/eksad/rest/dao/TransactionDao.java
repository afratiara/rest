package com.eksad.rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.eksad.rest.entity.Transaction;

public interface TransactionDao extends CrudRepository <Transaction, Long> {
	
	@Query("select sum(quantity) from TransactionDetail "
			+ "where transaction.id = ?1")
	public Integer findTotalItemByTransactionId(Long id); // penamaan ga ngaruh, liatnya di query
	
	
	@Query("select td.transaction.id as transactionId,"
			+ "sum(td.quantity * pr.price) as total "
			+ "from TransactionDetail td "
			+ "join td.product pr "
			+ "group by td.transaction.id")
	public List<Object[]> findTotalNominalPerTransaction();
	
// -----------------------------------------------------------------------------------------------------------
	
	@Query(value = "select td.transaction.id, sum(td.quantity * pr.price) "
			+ "from TransactionDetail td "
			+ "join td.product pr "
			+ "on pr.id = td.product_id "
			+ "group by td.transaction.id ", nativeQuery = true)
	public List<Object[]> findTotalNominalPerTransactionNative();
	
// -----------------------------------------------------------------------------------------------------------
	
	// query untuk manggil query yang sudah dibikin di pgAdmin, namanya query native disimpennya
	
//	@Query(value = 
//			"select td.id, t.date, pr.name as product, pr.price, " +  
//			"td.quantity, (pr.price*td.quantity) as total " + 
//			"from transaction t join transaction_detail td " + 
//			"on td.transaction_id = t.id join product pr on " +  
//			"td.product_id = pr.id", nativeQuery = true)
//	public List<Object[]> transactionReport();
}
