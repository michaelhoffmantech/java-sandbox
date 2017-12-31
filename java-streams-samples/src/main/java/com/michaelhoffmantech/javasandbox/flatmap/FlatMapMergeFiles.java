package com.michaelhoffmantech.javasandbox.flatmap;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.michaelhoffmantech.javasandbox.customspliterator.CreatingSpliterator;

/**
 * In this example class, I'm using flat map to flatten more than one stream and
 * combine the stream words into a collection of type set.
 *
 */
public class FlatMapMergeFiles {

	public Set<String> run() throws Exception {
		Set<String> results = null;
		try (Stream<String> stream1 = Files
				.lines(Paths.get(CreatingSpliterator.class.getResource("/person-list-1.txt").toURI()));
				Stream<String> stream2 = Files
						.lines(Paths.get(CreatingSpliterator.class.getResource("/person-list-2.txt").toURI()));
				Stream<String> stream3 = Files
						.lines(Paths.get(CreatingSpliterator.class.getResource("/person-list-3.txt").toURI()))) {
			// Flattens by extracting and combining into one stream, then 
			// flattens again by splitting each line by spaces, then 
			// takes the distinct names that were words, then 
			// finally returns as a collection
			results = Stream.of(stream1, stream2, stream3)
				.flatMap(Function.identity())
				.flatMap(line -> Pattern.compile(" ").splitAsStream(line))
				.distinct()
				.collect(Collectors.toSet());
		}

		return results; 
	}
}
