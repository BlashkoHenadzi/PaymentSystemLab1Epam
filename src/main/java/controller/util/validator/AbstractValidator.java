package controller.util.validator;

public abstract class AbstractValidator<T> implements Validator<T> {

    private final String ERROR_MESSAGE;

    private boolean isError;

    public AbstractValidator(String errorMessage) {
        this.ERROR_MESSAGE = errorMessage;
    }

    @Override
    public String getErrorKey() {
        return isError ? ERROR_MESSAGE : null;
    }

    @Override
    public void resetErrorStatus() {
        isError = false;
    }

    public void setErrorStatus(boolean status) {
        isError = status;
    }
}
