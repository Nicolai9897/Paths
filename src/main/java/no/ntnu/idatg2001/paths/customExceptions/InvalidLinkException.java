package no.ntnu.idatg2001.paths.customExceptions;

/**
 * Custom exception handler that handles then a link is broken.
 * @author Candidate nr. 10029 & Candidate nr. 10023
 * @version 1.0-SNAPSHOT
 */
public class InvalidLinkException extends Exception {
    public InvalidLinkException() {
        super("invalid passage link. Please check that the next passage is written correctly.");
    }

    public InvalidLinkException(String message) {
        super(message);
    }
}
