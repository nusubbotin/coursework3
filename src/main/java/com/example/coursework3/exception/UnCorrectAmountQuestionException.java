package com.example.coursework3.exception;

public class UnCorrectAmountQuestionException extends RuntimeException {
    public UnCorrectAmountQuestionException() {
    }

    public UnCorrectAmountQuestionException(String message) {
        super(message);
    }

    public UnCorrectAmountQuestionException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnCorrectAmountQuestionException(Throwable cause) {
        super(cause);
    }

    public UnCorrectAmountQuestionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
