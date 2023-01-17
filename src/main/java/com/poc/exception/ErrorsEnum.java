package com.poc.exception;

public enum ErrorsEnum {

    /**
     * ERR_MCS_POC
     */
    ERR_READ_WRITE_CONFIG("Error occurred with the config file READ WRITE option"),
    ERR_MCS_USER_LASTNAME_EMPTY("Error occurred - required field lastName not found"),
    ERR_MCS_USER_ID_EMPTY("Error occurred - required field id empty"),
    ERR_MCS_USER_NOT_FOUND("Error occurred - no user found with this id"),
    ERR_MCS_USER_EMPTY("Error occurred - user profile object or id can not empty");

    private final String errorMessage;

    private ErrorsEnum(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return " errorMessage : " + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
