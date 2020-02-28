package com.volkodav4ik;

public interface MyMap {

    String put(String key, String value);

    boolean containsKey(String key);

    String get(String key);

    boolean isEmpty();

    boolean containsValue(String value);

    int size();

    String toString ();

}
