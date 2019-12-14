package parsers.exceptions;

public class ParserExceptions extends Exception {
    public ParserExceptions(String message, Exception cause) {
        super(message, cause);
    }

    public ParserExceptions(String message) {
        super(message);
    }

    public ParserExceptions() {
    }
}
