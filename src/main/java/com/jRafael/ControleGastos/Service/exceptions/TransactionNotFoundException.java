package com.jRafael.ControleGastos.Service.exceptions;

public class TransactionNotFoundException extends RuntimeException{

    public TransactionNotFoundException(String message) {
        super(message);
    }
}
