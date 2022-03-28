package cz.greenrose.bookshelf.exceptions;

public class CantDeleteException extends RuntimeException {
    public CantDeleteException(String message) {
        super(message);
    }
}
