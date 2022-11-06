package com.marcelus.validators;

import io.vavr.control.Either;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;



class ArrayValidatorTest {

    @Test
    void checkingHappyScenario(){
        // Given
        Integer[] intArray = new Integer[]{1,5,10};
        // When
        Either<Object[], Integer[]> result = ArrayValidator.arrayCorrectSize(intArray, 3);
        // Then
        Assertions.assertTrue(result.isRight());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5,-3, 15, Integer.MAX_VALUE})
    void checkingNegativeScenarios(int size){
        // Given
        Integer[] intArray = new Integer[]{1,5,10};
        // When
        Either<Object[], Integer[]> result = ArrayValidator.arrayCorrectSize(intArray, size);
        // Then
        Assertions.assertTrue(result.isLeft());
    }

    @Test
    void checkingNullArrayScenario(){
        // Given
        Integer[] intArray = null;
        // When
        Either<Object[], Integer[]> result = ArrayValidator.arrayCorrectSize(intArray, 3);
        // Then

        Assertions.assertTrue(result.isLeft());
    }

    @Test
    void checkingNullCorrectSizeScenario(){
        // Given
        Integer[] intArray = new Integer[]{1,5,10};
        // When
        Either<Object[], Integer[]> result = ArrayValidator.arrayCorrectSize(intArray, null);
        // Then
        Assertions.assertTrue(result.isLeft());
    }

    @Test
    void anEmptyArrayIsReturnedOnTheLeftIfListParamIsNull(){
        // When
        Either<Object[],Integer[]> result = ArrayValidator.arrayCorrectSize(null, 3);
        // Then
        Assertions.assertEquals(0, result.getLeft().length);
    }

    @Test
    void anEmptyListIsReturnedOnTheLeftIfCorrectSizeParamIsNull(){
        // When
        Either<Object[],Integer[]> result = ArrayValidator.arrayCorrectSize(new Integer[]{1,2}, null);
        // Then
        Assertions.assertEquals(0, result.getLeft().length);
    }

    @Test
    void anEmptyListIsReturnedOnTheLeftIfCorrectSizeAndListParamsAreNull(){
        // When
        Either<Object[],Integer[]> result = ArrayValidator.arrayCorrectSize(null, null);
        // Then
        Assertions.assertEquals(0, result.getLeft().length);
    }

}