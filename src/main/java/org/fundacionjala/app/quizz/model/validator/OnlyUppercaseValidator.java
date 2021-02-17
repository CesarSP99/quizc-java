package org.fundacionjala.app.quizz.model.validator;

import java.util.List;

public class OnlyUppercaseValidator implements Validator {
    private static final String ERROR_MESSAGE = "The provided input must contain only uppercase characters ";

    @Override
    public void validate(String value, String conditionValueString, List<String> errors) {
        try {
            if(!value.equals(value.toUpperCase()))
                throw new IllegalArgumentException("Illegal Argument: not uppercase-only string\n");
        } catch (Exception exception) {
            errors.add(exception.getMessage() + ERROR_MESSAGE);
        }
    }
}
