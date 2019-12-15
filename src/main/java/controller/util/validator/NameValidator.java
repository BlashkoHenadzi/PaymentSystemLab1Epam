package controller.util.validator;

public class NameValidator extends RegexValidator {
    private final static int MAX_LENGTH = 50;

    private static final String NAME_REGEX = "^([A-Z][a-z]+)$";

    public NameValidator(String errorMessage) {
        super(NAME_REGEX, MAX_LENGTH, errorMessage);
    }
}