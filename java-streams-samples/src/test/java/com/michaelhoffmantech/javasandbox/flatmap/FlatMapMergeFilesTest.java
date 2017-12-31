package com.michaelhoffmantech.javasandbox.flatmap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * Tests the flat map merge of multiple files.
 *
 */
public class FlatMapMergeFilesTest {

	private FlatMapMergeFiles flatMapMerger = new FlatMapMergeFiles(); 
	
	@Test
	public void test_run_flatmapmergefiles_success() throws Exception {
		Set<String> people = flatMapMerger.run();
		assertNotNull(people);
		assertEquals(12, people.size());
		for (String person : people) {
			System.out.println(person);
		}
	}
}
