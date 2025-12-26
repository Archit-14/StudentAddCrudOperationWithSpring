package com.jsp.studentadd.exception;

import javax.print.DocFlavor.READER;

public class ResourceAlreadyException extends RuntimeException
{

	public ResourceAlreadyException(String message) {
		super(message);
	}
	
}
