# Java Streams Samples

## General Info
The samples here are influenced by several sources:

1. Pluralsight course Streams, Collectors and Optionals for Data Processing in Java 8: https://app.pluralsight.com/library/courses/java-8-data-processing-streams-collectors-optionals/table-of-contents

2. Modern Java Recipes by Ken Kousen

## Stream Overview

* Streams support functional programming concepts
* Stream is a sequence of data elements that does not save the elements or modify the original source as part of processing.
* Approach is take a stream of source data, pass the elements through a series of intermediate operations called a pipeline and complete the process with a terminal expresssion.
* Can only be used once. 
* Lazy in that streams will only process as much data as is necessary to reach the terminal condition. 

### Stream.of

* Provides a static method that accepts T... elements to use as a stream. 
* Good for when you have elements not already in a collection.
* Includes support for streaming a single data element; though, not sure why it would be used. 

### Arrays.stream

* Provides a static method that supports streaming an array of elements. 
* Could be used for variable arguments. 

### Stream.iterate

* Provides an infinite sequentially ordered Stream produced by the iterative application of a function to an initial element seed. 
* Could be used to iterate dates from a seed date and apply a function against certain days based on some criteria. 

### Stream.generate

* Provides an infinite sequentially unordered stream by repeatedly invoking the Supplier. 

### Boxed Streams

* Supports the creation of a collection from a primitive stream. 
* Necessary because of Java's use of primitives. 

### Reduce Operations

* Supports production of a single element from stream operations. 
* Accumulates calculations on each element
* Common paradigm with functional programming: map -> filter -> reduce. Map transforms a stream of one type into another. Filter is applied to produce a new stream with only the desired elements. Reduce provides a terminal operation that generates a single value from the stream. 
* An example is if you wanted to do a calculation on Strings that you mapped to integers, filtered to only include integers in a certain range and then accumulated the sum of the integers.  