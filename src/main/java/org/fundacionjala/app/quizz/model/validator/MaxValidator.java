package org.fundacionjala.app.quizz.model.validator;

import java.util.List;

public class MaxValidator implements Validator{
    private static final String ERROR_MESSAGE_LOWER_OR_EQUAL_THAN = "The value must be lower or equal than ";

    @Override
    public void validate(String valueString, String conditionValueString, List<String> errors) {
        try {
            int value = IntegerParser.parse(valueString);
            int conditionValue = IntegerParser.parse(conditionValueString);

            if (value > conditionValue) {
                errors.add(ERROR_MESSAGE_LOWER_OR_EQUAL_THAN + conditionValue);
            }
        } catch (NumberFormatException exception) {
            exception.printStackTrace();
            errors.add(IntegerParser.ERROR_MESSAGE_INVALID_NUMBER);
        }
    }

}
