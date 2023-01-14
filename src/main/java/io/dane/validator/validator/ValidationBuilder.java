package io.dane.validator.validator;

public class ValidationBuilder {

    private ValidationBuilder() {}

    public static <T> Validator<T> builder() {
        return new Validator<>();
    }
}
