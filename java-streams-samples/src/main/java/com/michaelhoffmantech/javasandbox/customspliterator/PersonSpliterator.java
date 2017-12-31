package com.michaelhoffmantech.javasandbox.customspliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Example of a custom Spliterator pattern implementation where one Spliterator
 * is built upon another Spliterator to have logic for regrouping lines that
 * were input.
 *
 */
public class PersonSpliterator implements Spliterator<PersonModel> {

	private final Spliterator<String> lineSpliterator;
	private String name;
	private int age;
	private String city;

	public PersonSpliterator(Spliterator<String> lineSpliterator) {
		this.lineSpliterator = lineSpliterator;
	}

	@Override
	public boolean tryAdvance(Consumer<? super PersonModel> action) {
		// Called by the Stream API and passes the action object
		// Action object will need to call accept method with the
		// current element of the stream
		// Read three lines of the line spliterator
		if (this.lineSpliterator.tryAdvance(line -> this.name = line)
				&& this.lineSpliterator.tryAdvance(line -> this.age = Integer.parseInt(line))
				&& this.lineSpliterator.tryAdvance(line -> this.city = line)) {
			PersonModel p = new PersonModel(name, age, city);
			action.accept(p);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Spliterator<PersonModel> trySplit() {
		// Not parallel processing
		return null;
	}

	@Override
	public long estimateSize() {
		// Returns the number of people with three lines per pseron
		return lineSpliterator.estimateSize() / 3;
	}

	@Override
	public int characteristics() {
		// Just return the line spliterator characteristics
		return this.lineSpliterator.characteristics();
	}

}
