package com.michaelhoffmantech.javasandbox.customspliterator;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Uses a custom Spliterator pattern to support reading a file line by line,
 * then having a second Spliterator that can read in the contents for every
 * three line and convert it into a Person Model object.
 *
 */
public class CreatingSpliterator {

	public List<PersonModel> run() throws Exception {
		// We want to read the file in the resources directory called people.txt first.
		Path path = Paths.get(CreatingSpliterator.class.getResource("/people.txt").toURI());
		// We use Files.lines to read in the file to a stream.
		// A stream is just a sequence of elements that can be processed sequentially or
		// in parallel.
		List<PersonModel> results = new ArrayList<>();
		try (Stream<String> lines = Files.lines(path);) {
			// This is the inital spliterator
			Spliterator<String> lineSpliterator = lines.spliterator();
			// This is the custom spliterator used for reading every three lines into a
			// person object.
			Spliterator<PersonModel> peopleSpliterator = new PersonSpliterator(lineSpliterator);
			// Then we use StreamSupport to stream the lines and then in an ordered fashion,
			// collect them into a list.
			StreamSupport.stream(peopleSpliterator, false).forEachOrdered(results::add);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return results;
	}

}
