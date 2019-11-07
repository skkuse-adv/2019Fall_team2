package io.victoralbertos.jolyglot;

import java.io.File;

public interface Jolyglot {
    <T> T fromJson(File file, Class<T> cls) throws RuntimeException;

    <T> T fromJson(String str, Class<T> cls) throws RuntimeException;

    String toJson(Object obj);
}
