package com.marcelus.validators;

import io.vavr.control.Either;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class NullValidatorTest {


    @Test
    void checkingParamNullScenario(){
        // Given
        Integer notNullParam = 1;

        // Given
        Either<Integer, Integer> either = NullValidator.notNull(notNullParam);

        // Then
        Assertions.assertEquals(notNullParam, either.get());
    }

    @Test
    void checkingHappyScenario(){
        // Given
        String notNullParam = "Hello";

        // Given
        Either<String, String> either = NullValidator.notNull(notNullParam);

        // Then
        Assertions.assertTrue(either.isRight());
    }

    @Test
    void checkingNullArrayScenario(){
        // Given
        String[] nullParam = null;

        // Given
        Either<?, String[]> either = NullValidator.notNull(nullParam);

        // Then
        Assertions.assertTrue(either.isLeft());
    }

    @Test
    void checkingNullListScenario(){
        // Given
        List<String> nullParam = null;

        // Given
        Either<List<String>, List<String>> either = NullValidator.notNull(nullParam);

        // Then
        Assertions.assertTrue(either.isLeft());
    }

}