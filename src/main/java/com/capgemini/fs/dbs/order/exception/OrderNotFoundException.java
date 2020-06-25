package com.capgemini.fs.dbs.order.exception;

public class OrderNotFoundException extends Exception{
	 
	private static final long serialVersionUID = 1L;

	public OrderNotFoundException() {
		super();
	}

	public OrderNotFoundException(final String message) {
		super(message);
	}


}
