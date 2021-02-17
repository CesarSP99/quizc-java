package org.fundacionjala.app.quizz.model.configuration;

import org.fundacionjala.app.quizz.model.validator.ValidatorType;

public class NumericConfiguration extends QuestionConfiguration{
    public NumericConfiguration() {
        super(false, ValidatorType.REQUIRED, ValidatorType.MIN, ValidatorType.MAX);
    }
}
