package test;

import java.util.stream.Stream;

public class TestStream {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "c", "d", "e"};
        Stream stream = Stream.of(arr);
    }
}
