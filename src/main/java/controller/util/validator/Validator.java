package controller.util.validator;

public interface Validator<T> {

    String getErrorKey();

    boolean isValid(T obj);

    void resetErrorStatus();
}
