package org.fundacionjala.app.quizz.model.validator;

import java.util.List;

public class MaxLengthValidator implements Validator{

    private static final String ERROR_MESSAGE = "The value length must be less or equal than ";

    @Override
    public void validate(String value, String conditionValueString, List<String> errors) {
        try {
            int conditionValue = IntegerParser.parse(conditionValueString);

            if (value.length() > conditionValue) {
                errors.add(ERROR_MESSAGE + conditionValue);
            }
        } catch (NumberFormatException exception) {
            exception.printStackTrace();
            errors.add(IntegerParser.ERROR_MESSAGE_INVALID_NUMBER);
        }
    }
}
