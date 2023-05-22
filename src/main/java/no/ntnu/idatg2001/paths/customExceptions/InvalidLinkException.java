package no.ntnu.idatg2001.paths.customExceptions;

public class InvalidLinkException extends Exception {
    public InvalidLinkException() {
        super("invalid passage link. Please check that the next passage is written correctly.");
    }

    public InvalidLinkException(String message) {
        super(message);
    }
}
