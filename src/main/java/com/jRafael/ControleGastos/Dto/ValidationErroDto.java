package com.jRafael.ControleGastos.Dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationErroDto extends CustomErrorDto{

    private List<FieldMessage> errors = new ArrayList<>();


    public ValidationErroDto(Instant timestamp, int status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String FieldName, String Message){
        errors.add(new FieldMessage(FieldName,Message));

    }
}
