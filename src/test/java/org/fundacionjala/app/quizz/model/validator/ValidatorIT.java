package org.fundacionjala.app.quizz.model.validator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorIT {

    @Test
    public void testDateValidator() {
        List<String> errors = new ArrayList<>();
        Validator dateValidator = ValidatorType.DATE.getValidator();

        dateValidator.validate("24/12/2021", null, errors);

        Assert.assertEquals(DateValidator.class, dateValidator.getClass());
        Assert.assertTrue(errors.isEmpty());
    }

    @Test
    public void testOnlyUpperCaseValidator() {
        List<String> errors = new ArrayList<>();
        Validator onlyUpperCaseValidator = ValidatorType.ONLY_UPPERCASE.getValidator();

        onlyUpperCaseValidator.validate("HOLA", null, errors);

        Assert.assertEquals(OnlyUppercaseValidator.class, onlyUpperCaseValidator.getClass());
        Assert.assertTrue(errors.isEmpty());
    }

    @Test
    public void testMaxValidator() {
        List<String> errors = new ArrayList<>();
        Validator maxValidator = ValidatorType.MAX.getValidator();

        maxValidator.validate("5", "7", errors);

        Assert.assertEquals(MaxValidator.class, maxValidator.getClass());
        Assert.assertTrue(errors.isEmpty());
    }

}
