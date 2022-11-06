package com.marcelus.validators;

import io.vavr.control.Either;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;


class ListValidatorTest {
    @Test
    void checkingHappyScenario(){
        // Given
        List<Integer> intArray = Arrays.asList(1,5,10);
        // When
        Either<List<Integer>, List<Integer>> result = ListValidator.listCorrectSize(intArray, 3);
        // Then
        Assertions.assertTrue(result.isRight());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5,-3, 15, Integer.MAX_VALUE})
    void checkingNegativeScenarios(int size){
        // Given
        List<Integer> intArray = Arrays.asList(1,5,10);
        // When
        Either<List<Integer>, List<Integer>> result = ListValidator.listCorrectSize(intArray, size);
        // Then
        Assertions.assertTrue(result.isLeft());
    }

    @Test
    void checkingNullArrayScenario(){
        // Given
        List<Integer> intArray = null;
        // When
        Either<List<Integer>, List<Integer>> result = ListValidator.listCorrectSize(intArray, 3);
        // Then
        Assertions.assertTrue(result.isLeft());
    }

    @Test
    void checkingNullCorrectSizeScenario(){
        // Given
        List<Integer> intArray = Arrays.asList(1,5,10);
        // When
        Either<List<Integer>, List<Integer>> result = ListValidator.listCorrectSize(intArray, null);
        // Then
        Assertions.assertTrue(result.isLeft());
    }

    @Test
    void anEmptyListIsReturnedOnTheLeftIfListParamIsNull(){
        // Given
        List<Integer> intArray = null;
        // When
        Either<List<Integer>,List<Integer>> result = ListValidator.listCorrectSize(intArray, 3);
        // Then
        Assertions.assertEquals(0, result.getLeft().size());
    }

    @Test
    void anEmptyListIsReturnedOnTheLeftIfCorrectSizeParamIsNull(){
        // Given
        List<Integer> intArray = Arrays.asList(1,5,10);
        // When
        Either<List<Integer>,List<Integer>> result = ListValidator.listCorrectSize(intArray, null);
        // Then
        Assertions.assertEquals(0, result.getLeft().size());
    }

    @Test
    void anEmptyListIsReturnedOnTheLeftIfCorrectSizeAndListParamsAreNull(){
        // When
        Either<List<Integer>,List<Integer>> result = ListValidator.listCorrectSize(null, null);
        // Then
        Assertions.assertEquals(0, result.getLeft().size());
    }
}