package com.michaelhoffmantech.javasandbox.stream;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

/**
 * Sandbox exmaples for getting the average of numbers in different ways.
 */
public class GetAverageOfNumbers {

  public static void getAverageOfIntegers() {
    IntStream
        .of(4, 10, 72, 13, 9, 55, 22, 14, 99, 98, 66, 72, 4, 42, 72)
        .average()
        .ifPresentOrElse(
            value -> System.out.println("Average = " + value),
            () -> System.out.println("Error"));
  }

  public static void main(String[] args) {
    getAverageOfIntegers();
  }
}
