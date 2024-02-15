package com.javamsdt.classes.enums;

public class EnumRunner {
    public static void main(String[] args) {
        int databaseError = ErrorCode.DATABASE_ERROR.getCode();
        System.out.println("DATABASE_ERROR:: " + databaseError);

        System.out.println("=================== handleErrorIfElse =================");
        handleErrorIfElse(ErrorCode.NETWORK_ERROR);

        System.out.println("=================== handleErrorSwitch =================");
        System.out.println("handleErrorSwitch Error code:: " + handleErrorSwitch(ErrorCode.PERMISSION_DENIED));
    }

    // Enum using If Else
    public static void handleErrorIfElse(ErrorCode errorCode) {
        if (errorCode == ErrorCode.INVALID_INPUT) {
            System.out.println("Invalid input error. Please check your input data.");
        } else if (errorCode == ErrorCode.DATABASE_ERROR) {
            System.out.println("Database error. Please try again later.");
        } else if (errorCode == ErrorCode.NETWORK_ERROR) {
            System.out.println("Network error. Please check your network connection.");
        } else if (errorCode == ErrorCode.PERMISSION_DENIED) {
            System.out.println("Permission denied error. You do not have sufficient permissions.");
        } else {
            System.out.println("Unknown error occurred.");
        }
    }

    // Enum using Switch
    public static int handleErrorSwitch(ErrorCode errorCode) {
        return switch (errorCode) {
            case INVALID_INPUT -> ErrorCode.INVALID_INPUT.getCode();
            case DATABASE_ERROR -> ErrorCode.DATABASE_ERROR.getCode();
            case NETWORK_ERROR -> ErrorCode.NETWORK_ERROR.getCode();
            case PERMISSION_DENIED -> ErrorCode.PERMISSION_DENIED.getCode();
            default -> ErrorCode.DEFAULT_ERROR.getCode();
        };
    }

}
