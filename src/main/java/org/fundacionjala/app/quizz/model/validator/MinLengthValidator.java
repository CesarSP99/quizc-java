package org.fundacionjala.app.quizz.model.validator;

import java.util.List;

public class MinLengthValidator implements Validator {
    //I changed the error message string because it was confusing.
    private static final String ERROR_MESSAGE = "The value length must be at least ";

    @Override
    public void validate(String value, String conditionValueString, List<String> errors) {
        try {
            int conditionValue = IntegerParser.parse(conditionValueString);

            if (value.length() < conditionValue) {
                errors.add(ERROR_MESSAGE + conditionValue);
            }
        } catch (NumberFormatException exception) {
            exception.printStackTrace();
            errors.add(IntegerParser.ERROR_MESSAGE_INVALID_NUMBER);
        }

    }
}
