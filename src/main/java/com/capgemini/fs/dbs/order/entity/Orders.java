package com.capgemini.fs.dbs.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class Orders {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	//private long orderID;
	private long id;

	@Column
	private String customerName;

	@Column
	private String shippingAddress;

	@Column
	private double total;

	

}
