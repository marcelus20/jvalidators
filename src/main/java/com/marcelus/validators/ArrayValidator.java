package com.marcelus.validators;

import io.vavr.control.Either;

public class ArrayValidator {

    /**
     * Private Constructor to avoid class to be instantiated.
     */
    private ArrayValidator() {}

    public static <T> Either<Object[], T[]> arrayCorrectSize(final T[] array, final Integer correctSize){
        return NullValidator.notNull(array)
                .flatMap(correctSizeNotNull->{
                    final Either<Integer, Integer> nonNullInteger = NullValidator.notNull(correctSize);
                    if(nonNullInteger.isLeft()){
                        return Either.left(new Object[0]);
                    }
                    if(array.length != correctSize){
                        return Either.left(array);
                    }else{
                        return Either.right(array);
                    }
                });
    }
}
