package com.poc.exception;

public enum ErrorsEnum {

    /**
     * ERR_MCS_POC
     */
    ERR_READ_WRITE_CONFIG("Error occurred with the config file READ WRITE option"),
    ERR_MCS_USER_LASTNAME_EMPTY("Error occurred - user profile lastName shouldn't be NULL or EMPTY"),
    ERR_MCS_USER_FIRSTNAME_EMPTY("Error occurred - user profile firstName shouldn't be NULL or EMPTY"),
    ERR_MCS_USER_ID_EMPTY("Error occurred - user profile id shouldn't be NULL or EMPTY"),
    ERR_MCS_USER_AGE_NOT_VALID("Error occurred - user profile age not valid"),
    ERR_MCS_USER_NOT_FOUND("Error occurred - no user found with this id"),
    ERR_MCS_USER_NAME_EMPTY("Error occurred - user profile lastName or firstName can not empty"),
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
