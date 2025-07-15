package com.jRafael.ControleGastos.Dto;

import java.time.Instant;

public class CustomErrorDto {

    private Instant timestamp;
    private int status;
    private String error;
    private String path;

    public CustomErrorDto(Instant timestamp, int status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getPath() {
        return path;
    }
}
