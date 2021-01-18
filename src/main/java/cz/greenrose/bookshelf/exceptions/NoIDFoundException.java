package cz.greenrose.bookshelf.exceptions;

public class NoIDFoundException extends RuntimeException{
    public NoIDFoundException(String message) {
        super(message);
    }
}
