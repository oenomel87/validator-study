package io.dane.validator.validator;

public interface ValidationRule<T> {

    String valid(T t);
}
