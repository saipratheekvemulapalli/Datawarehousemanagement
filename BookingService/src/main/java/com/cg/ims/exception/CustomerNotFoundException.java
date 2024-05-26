package com.cg.ims.exception;
@SuppressWarnings("serial")
public class CustomerNotFoundException extends RuntimeException{
	public CustomerNotFoundException(String msg)
	{
		super(msg);
	}

}
