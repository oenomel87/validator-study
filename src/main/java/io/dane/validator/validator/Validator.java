package io.dane.validator.validator;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Validator<T> {

    private final List<String> errors = new ArrayList<>();

    private final List<ValidationRule<T>> rules = new ArrayList<>();

    public Validator<T> apply(ValidationRule<T> rule) {
        this.rules.add(rule);
        return this;
    }

    public List<String> checkRules(T t) {
        for(var rule : rules) {
            var result = rule.valid(t);
            if(StringUtils.hasText(result)) {
                this.errors.add(result);
            }
        }

        return errors;
    }

    public static <T> Validator<T> builder() {
        return new Validator<>();
    }
}
