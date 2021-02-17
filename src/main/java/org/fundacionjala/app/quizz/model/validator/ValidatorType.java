package org.fundacionjala.app.quizz.model.validator;

public enum ValidatorType {
    REQUIRED(1, "Required", new RequiredValidator()),
    DATE(2, "Date", new DateValidator()),
    MIN(3, "Min", new MinValidator()),
    MIN_LENGTH(4, "Min Length", new MinLengthValidator()),
    MAX_LENGTH(5, "Max Length", new MaxLengthValidator()),
    ONLY_UPPERCASE(6, "Only Uppercase", new OnlyUppercaseValidator()),
    MAX(7, "Max", new MaxValidator());

    private final int code;
    private final String displayName;
    private final Validator validator;

    ValidatorType(int code, String displayName, Validator validator) {
        this.code = code;
        this.displayName = displayName;
        this.validator = validator;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return displayName;
    }

    public Validator getValidator() {
        return validator;
    }

    public static ValidatorType getByCode(int option) {
        for (ValidatorType validator : ValidatorType.values()) {
            if (validator.getCode() == option) {
                return validator;
            }
        }

        return null;
    }
}
