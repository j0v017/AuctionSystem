package com.wells.qart.eAuction.exceptions;

public class CannotDeleteProductException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public CannotDeleteProductException() {
        super();
    }

    public CannotDeleteProductException(String message) {
        super(message);
    }

}
