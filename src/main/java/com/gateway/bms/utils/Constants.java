package com.gateway.bms.utils;

public interface Constants{
    String TIME_FORMAT = "HH:mm:ss";
    String EMPTY = "";
    String SUCCESS = "SUCCESS";
    String DELETE_SUCCESS_MSG= "SUCCESSFULLY DELETED ID : ";
    String ERROR = "error";
    String DATE_FORMAT = "dd/MM/yyyy";
    String DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss";
    String E_0001 = "Json data parsing error";
    String QR_ERROR="QR00001";
    String PRIMERRY_KEY_ERROR = "E002627";
    String E002627 = "Violation of PRIMARY KEY constraint. Cannot insert duplicate key.";

    public static final char[] HEX_UPPER = "0123456789ABCDEF".toCharArray();
    public static final char[] HEX_LOWER = "0123456789abcdef".toCharArray();

    String FILE_NOT_EXIST_ERROR_CODE="ER00001";
}
