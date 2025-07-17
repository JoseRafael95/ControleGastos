package com.jRafael.ControleGastos.Dto;

public class FieldMessage {

    private String FieldName;
    private String Message;

    public FieldMessage(String fieldName, String message) {
        FieldName = fieldName;
        Message = message;
    }

    public String getFieldName() {
        return FieldName;
    }

    public String getMessage() {
        return Message;
    }
}
