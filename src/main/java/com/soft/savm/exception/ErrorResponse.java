/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.soft.savm.exception;

/**
 *
 * @author PMYLS
 */
public class ErrorResponse {
    private String errorMessage;
    private boolean flag;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public ErrorResponse() {
    }

    public ErrorResponse(String errorMessage, boolean flag) {
        this.errorMessage = errorMessage;
        this.flag = flag;
    }
}
