package controller.util.validator;

public class EmailValidator extends RegexValidator {
    private final static String INVALID_EMAIL_KEY = "invalid.email";

    private final static int MAX_LENGTH = 50;

    private static final String EMAIL_REGEX = "^(.+\\@.+\\..+)$";

    public EmailValidator() {
        super(EMAIL_REGEX, MAX_LENGTH, INVALID_EMAIL_KEY);
    }
}
