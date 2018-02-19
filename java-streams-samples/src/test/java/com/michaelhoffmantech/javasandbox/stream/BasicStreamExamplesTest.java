package com.michaelhoffmantech.javasandbox.stream;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicStreamExamplesTest {

  @Test
  public void test_Stream_Of_StaticMethod() {
    String beers = Stream
        .of("Coors", "Miller", "Bells", "Bud", "Goose Island")
        .collect(Collectors.joining(","));
    assertEquals("Coors,Miller,Bells,Bud,Goose Island", beers);
  }

  @Test
  public void test_Stream_Of_StaticMethodSingleElement() {
    String beer = Stream
        .of("Coors")
        .collect(Collectors.toList())
        .get(0);
    assertEquals("Coors", beer);
  }

  @Test
  public void test_Arrays_Stream_StaticMethod() {
    String[] beers = {"Coors", "Miller", "Bells", "Bud", "Goose Island"};
    String joinedBeers = Arrays.stream(beers)
        .collect(Collectors.joining(","));
    assertEquals("Coors,Miller,Bells,Bud,Goose Island", joinedBeers);
  }

  @Test
  public void test_Stream_Iterate_StaticMethod() {
    List<BigDecimal> nums = Stream.iterate(
        BigDecimal.ONE,
        n -> n.add(BigDecimal.ONE))
        .limit(5)
        .collect(Collectors.toList());
    assertEquals(5, nums.size());
    assertEquals(1, nums.get(0).intValue());
    assertEquals(2, nums.get(1).intValue());
    assertEquals(3, nums.get(2).intValue());
    assertEquals(4, nums.get(3).intValue());
    assertEquals(5, nums.get(4).intValue());
  }

  @Test
  public void test_BoxedStream_IntStream_Of_StaticMethod() {
    /**
     * This won't compile because it needs to be boxed.
    List<Integer> results =
      IntStream
        .of(1, 4, 9, 3)
        .collect(Collectors.toList());
     */

    List<Integer> resultsBox =
      IntStream
        .of(1, 4, 9, 3)
        .boxed()
        .collect(Collectors.toList());

    List<Integer> resultsMap =
      IntStream
        .of(1, 4, 9, 3)
        .mapToObj(Integer::valueOf)
        .collect(Collectors.toList());

    /**
     * Collect has a supplier (constructor), an accumulator (add)
     * and a combiner (addAll)
     */
    List<Integer> resultsCollect =
      IntStream
        .of(1, 4, 9, 3)
        .collect(ArrayList<Integer>::new, ArrayList::add,
          ArrayList::addAll);

    assertEquals(1, resultsBox.get(0).intValue());
    assertEquals(1, resultsMap.get(0).intValue());
    assertEquals(1, resultsCollect.get(0).intValue());
    assertEquals(4, resultsBox.get(1).intValue());
    assertEquals(4, resultsMap.get(1).intValue());
    assertEquals(4, resultsCollect.get(1).intValue());
    assertEquals(9, resultsBox.get(2).intValue());
    assertEquals(9, resultsMap.get(2).intValue());
    assertEquals(9, resultsCollect.get(2).intValue());
    assertEquals(3, resultsBox.get(3).intValue());
    assertEquals(3, resultsMap.get(3).intValue());
    assertEquals(3, resultsCollect.get(3).intValue());
  }
}
