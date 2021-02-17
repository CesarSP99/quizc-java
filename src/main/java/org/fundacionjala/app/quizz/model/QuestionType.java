package org.fundacionjala.app.quizz.model;

import org.fundacionjala.app.quizz.model.configuration.*;
import org.fundacionjala.app.quizz.model.validator.ValidatorType;

public enum QuestionType {
    TEXT(1, "Text", new TextConfiguration()),
    DATE(2, "Date", new DateConfiguration()),
    PICK_ONE(3, "Pick One", new PickOneConfiguration()),
    NUMERIC(4, "Numeric", new NumericConfiguration());


    private final int code;
    private final String displayName;
    private final QuestionConfiguration configuration;

    QuestionType(int code, String displayName, QuestionConfiguration configuration) {
        this.code = code;
        this.displayName = displayName;
        this.configuration = configuration;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return displayName;
    }

    public boolean hasAdditionalData() {
        return configuration.hasAdditionalData();
    }

    public ValidatorType[] getValidations() {
        return configuration.getSupportedValidations();
    }

    public QuestionConfiguration getConfiguration() {
        return configuration;
    }

    public static QuestionType getByCode(int option) {
        for (QuestionType type : QuestionType.values()) {
            if (type.getCode() == option) {
                return type;
            }
        }

        return null;
    }
}
