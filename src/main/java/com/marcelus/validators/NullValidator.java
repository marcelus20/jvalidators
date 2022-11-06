package com.marcelus.validators;

import io.vavr.control.Either;
import java.util.ArrayList;

import java.util.List;


public class NullValidator {

    /**
     * Private Constructor to avoid class to be instantiated.
     */
    private NullValidator(){}

    public static <T> Either<List<T>, List<T>> notNull(final List<T> tList){
        if(tList == null){
            return Either.left(new ArrayList<>());
        }else{
            return Either.right(tList);
        }
    }

    public static <T> Either<T, T> notNull(final T t){
        if(t == null){
            return Either.left(null);
        }else{
            return Either.right(t);
        }
    }

    public static <T> Either<Object[], T[]> notNull(final T[] t){
        if(t == null){
            return Either.left(new Object[0]);
        }else{
            return Either.right(t);
        }
    }
}
