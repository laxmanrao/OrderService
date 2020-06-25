package com.capgemini.fs.dbs.order.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.fs.dbs.order.entity.Orders;

@Repository
public interface OrderRepository extends CrudRepository<Orders, Long> {

	Optional<Orders> findById(long id);

	List<Orders> findAll();

	List<Orders> findByCustomerName(String customerName);
}
