package cz.greenrose.bookshelf.exceptions;

public class InvalidEntryException extends RuntimeException{
    public InvalidEntryException(String message) {
        super(message);
    }
}