package io.victoralbertos.jolyglot;

import java.io.File;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public interface JolyglotGenerics extends Jolyglot {
    GenericArrayType arrayOf(Type type);

    <T> T fromJson(File file, Type type) throws RuntimeException;

    <T> T fromJson(String str, Type type) throws RuntimeException;

    ParameterizedType newParameterizedType(Type type, Type... typeArr);

    String toJson(Object obj, Type type);
}
