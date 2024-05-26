package com.cg.ims.exception;
@SuppressWarnings("serial")
public class InvalidProductIdException extends RuntimeException{
	public InvalidProductIdException(String msg)
	{
		super(msg);
	}

}
