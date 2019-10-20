package ru.numbdev.FIndMeServer.exception;

public class ServerException extends RuntimeException {

    public ServerException(String message) {
        super(message);
    }

    public ServerException(Throwable e) {
        super(e);
    }
}
