package com.cg.ims.exception;
@SuppressWarnings("serial")
public class NoProductsBookedException extends RuntimeException {
	public NoProductsBookedException(String msg)
	{
		super(msg);
	}

}
