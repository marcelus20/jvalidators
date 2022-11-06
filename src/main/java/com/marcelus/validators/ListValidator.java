package com.marcelus.validators;


import io.vavr.control.Either;

import java.util.Arrays;
import java.util.List;

public class ListValidator {

    private ListValidator(){

    }

    public static <T> Either<List<T>, List<T>> listCorrectSize(final List<T> list, final Integer correctSize){
        return NullValidator.notNull(list)
                .flatMap(nonNullList->ArrayValidator.arrayCorrectSize((T[])list.toArray(), correctSize)
                        .map(Arrays::asList)
                        .swap()
                        .map(arrayLeft ->(List<T>)Arrays.asList())
                        .swap()
                );
    }
}
